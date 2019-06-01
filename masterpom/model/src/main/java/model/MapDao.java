package model;

import java.io.IOException;
import java.sql.*;

import entity.IElement;
import model.Element.Mobile.Diamond;
import model.Element.Mobile.Monster;
import model.Element.MotionlessElement.MotionlessElementFactory;

public class MapDao extends AbstractDAO {

	/** The sql map by id. */
	private static String sqlMapById = "{call prolevel3(?)}";

	/** The id column index. */
	// private static int idColumnIndex = 1;

	/** The height column index. */
	private static int heightColumnIndex = 2;
	
	/** The width column index. */
	private static int widthColumnIndex = 3;



	/** The map column index. */
	private static int mapColumnIndex = 4;

	/**
	 * Gets the example by id.
	 *
	 * @param id
	 *            the id
	 * @return the map by id
	 * @throws SQLException
	 *             the SQL exception
	 * @throws IOException
	 */
	public static Map prolevel3( int id) throws SQLException, IOException {
		final CallableStatement callStatement = prepareCall(sqlMapById);
		callStatement.setInt(1, id);
		int width = 0;
		int height = 0;
		Map tempMap = null;

		if (callStatement.execute()) {
			final ResultSet result = callStatement.getResultSet();
			if (result.first()) {
				width = result.getInt(widthColumnIndex);
				height = result.getInt(heightColumnIndex);
				try{
					MapDao.testCorrectLevel(width, height, result.getString(mapColumnIndex));
				}
				catch(Exception e){
					System.out.println(e.getMessage());
					System.exit(0);
				}
				tempMap = new Map(width, height, new IElement[width][height]);

				MapDao.placePawnsOnMap(result, tempMap, width);
			} else {
				System.out.println("Could not find map");
				System.exit(1);
			}
			result.close();
		}
		return tempMap;
	}
	
	private static void testCorrectLevel(final int width, final int height, final String mapString) throws Exception {
		System.out.println(width * height + height);
		System.out.println(mapString.length());
		if(width * height + height != mapString.length())
			throw new Exception("Level is not good >:( x:" + width + " y: " + height + " size: " + mapString.length());
		System.out.println(width * height + height);
		System.out.println(mapString.length());
	}

	private static void placePawnsOnMap(final ResultSet result, final Map tempMap, int width) throws SQLException, IOException {

		int currentXToWrite = 0;
		int currentYToWrite = 0;
		boolean skipNext = false;

		for (char c : result.getString(mapColumnIndex).toCharArray()) {
			if (!skipNext) {
				// Adding map element, if pawn, adding dug dirt
				tempMap.setOnTheMapXY(currentXToWrite, currentYToWrite, MotionlessElementFactory.getFromFileSymbol(c));

				// Now let's check if the element to insert is an IMobile
				// (boulder, diamond..)
				 if (c == 'D') {
					tempMap.addPawn(new Diamond(currentXToWrite, currentYToWrite, tempMap));
					tempMap.addDiamondCount();
				} else if (c == 'M') {

					tempMap.addPawn(new Monster(currentXToWrite, currentYToWrite, tempMap));
				}
				currentXToWrite++;
			} else {
				skipNext = false;
			}
			// If we get to the carriage return character
			if (currentXToWrite % width == 0 && currentXToWrite != 0) {
				currentXToWrite = 0;
				currentYToWrite++;
				skipNext = true;
			}
		}
	}
}
