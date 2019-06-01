package model.Element.MotionlessElement;

import java.awt.Rectangle;

import entity.Permeability;
import entity.Sprite;

public class Background extends MotionlessElement {

	private static Sprite sprite = new Sprite (' ', Sprite.mapTileSet, new Rectangle(32, 0, 16, 16));
	public Background() {
	super(sprite, Permeability.PENETRABLE);
		// TODO Auto-generated constructor stub
	}

}
