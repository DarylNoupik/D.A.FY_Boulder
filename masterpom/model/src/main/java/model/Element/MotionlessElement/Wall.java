package model.Element.MotionlessElement;

import java.awt.Rectangle;

import entity.Permeability;
import entity.Sprite;

public class Wall extends MotionlessElement {

	private static Sprite sprite = new Sprite ('W', Sprite.mapTileSet, new Rectangle(0, 0, 16, 16));
	public Wall() {
	super(sprite, Permeability.BLOCKING);
	}

}
