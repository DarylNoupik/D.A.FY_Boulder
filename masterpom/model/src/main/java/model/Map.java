package model;

import java.awt.Point;
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

	private int diamondCount =0;

	private ArrayList<IMobile> pawns;

	


/**
* 
* @param fileName
* @throws IOException
*/
public Map(int wid , int heg , IElement[][] map ) throws IOException {
super();
this.onTheMap = map ;
this.width=wid;
this.height=heg;
this.pawns = new ArrayList<IMobile>();
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

public final String toString() {
    String temp = new String();
    for (int y = 0; y < this.getHeight(); y++) {
      for (int x = 0; x < this.getWidth(); x++) {
        temp += onTheMap[x][y].getSprite().getConsoleImage();
      }
      temp += '\n';
    }
    return temp;
  }
public IElement getOnTheMapXY(final int x, final int y) {
	if(x >= 0 && x < this.getWidth() && y >= 0 && y < this.getHeight())
    	return this.onTheMap[x][y];
    else
    	return this.onTheMap[0][0];
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
        //this.setWidth(Integer.parseInt(line));
        line = buffer.readLine();
        //this.setHeight(Integer.parseInt(line));
        this.onTheMap = new IElement[21][41];
        line = buffer.readLine();
        while (line != null) {
            for (int x = 0; x < 21; x++) {
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
	 this.onTheMap[x][y] = elem;
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
	  this.setDiamondCount(this.getDiamondCount() - 1);
}


@Override
public void addDiamondCount() {
	// TODO Auto-generated method stub
	  this.setDiamondCount(this.getDiamondCount() + 1);
}


@Override
public int getDiamondCount() {
	// TODO Auto-generated method stub
	  return this.diamondCount;
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
	 Point point = new Point(x, y);
	    for(IMobile pawn : this.getPawns()) {
	      if (pawn.getPosition().equals(point))
	        return pawn.getPermeability();
	    }
	    if(this.getMyCharacter().getPosition().equals(point))
	    	return this.getMyCharacter().getPermeability();
	    
	    return this.getOnTheMapXY(x, y).getPermeability();
	  }



public void setDiamondCount(int diamondCount) {
	this.diamondCount = diamondCount;
}


}
