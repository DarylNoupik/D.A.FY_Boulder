package model.Element.MotionlessElement;

import java.awt.Rectangle;

import entity.Permeability;
import entity.Sprite;

public class Ground extends MotionlessElement {

	private static Sprite sprite = new Sprite ('G',Sprite.mapTileSet, new Rectangle(16, 0, 16, 16));
	public Ground( ) {
	super(sprite, Permeability.MINEABLE);
		// TODO Auto-generated constructor stub
	}

}
