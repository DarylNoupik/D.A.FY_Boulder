package model;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Observable;

import entity.IElement;
import entity.IMap;
import entity.IMobile;
import entity.Permeability;
import model.Element.MotionlessElement.MotionlessElementFactory;

public class Map extends Observable implements IMap {

	/** The width. */
    private int          width;

    /** The height. */
    private int          height;

    /** The on the map. */
    private IElement[][] onTheMap;


/**
* 
* @param fileName
* @throws IOException
*/
public Map(String fileName) throws IOException {
super();
this.loadFile(fileName);
}


@Override
public void setMobileHasChanged() {
this.setChanged();
this.notifyObservers();

}

@Override
public Observable getObservable() {
// TODO Auto-generated method stub
return null;
}

public IElement getOnTheMapXY(final int x, final int y) {
return this.onTheMap[x][y];
}

public void setOnTheMap(IElement onTheMap, final int x, final int y) {
this.onTheMap[x][y] = onTheMap;
}

public int getHeight() {
return height;
}

public void setHeight(int height) {
this.height = height;
}

public int getWidth() {
return width;
}

public void setWidth(int width) {
this.width = width;
}

private void loadFile( String fileName) throws IOException {
        final BufferedReader buffer = new BufferedReader(new InputStreamReader(new FileInputStream(fileName)));
        String line;
        int y = 0;
        line = buffer.readLine();
        this.setWidth(Integer.parseInt(line));
        line = buffer.readLine();
        this.setHeight(Integer.parseInt(line));
        this.onTheMap = new IElement[this.getWidth()][this.getHeight()];
        line = buffer.readLine();
        while (line != null) {
            for (int x = 0; x < line.toCharArray().length; x++) {
                this.setOnTheMap(MotionlessElementFactory.getFromFileSymbol(line.toCharArray()[x]), x, y);
            }
            line = buffer.readLine();
            y++;
        }
        buffer.close();
    }


@Override
public void setOnTheMapXY(int x, int y, IElement elem) {
	// TODO Auto-generated method stub
	
}


@Override
public void addPawn(IMobile pawn) {
	// TODO Auto-generated method stub
	
}


@Override
public ArrayList<IMobile> getPawns() {
	// TODO Auto-generated method stub
	return null;
}


@Override
public void decreaseDiamondCount() {
	// TODO Auto-generated method stub
	
}


@Override
public void addDiamondCount() {
	// TODO Auto-generated method stub
	
}


@Override
public int getDiamondCount() {
	// TODO Auto-generated method stub
	return 0;
}


@Override
public IMobile getMyCharacter() {
	// TODO Auto-generated method stub
	return null;
}


@Override
public void setMyCharacter(IMobile character) {
	// TODO Auto-generated method stub
	
}


@Override
public Permeability getSquareIsOccupiedXY(int x, int y) {
	// TODO Auto-generated method stub
	return null;
}


}
