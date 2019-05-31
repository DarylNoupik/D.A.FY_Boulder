package model.Element.MotionlessElement;

import entity.Permeability;
import entity.Sprite;

public class Wall extends MotionlessElement {

	private static Sprite sprite = new Sprite ('W', "mur.png");
	public Wall() {
	super(sprite, Permeability.BLOCKING);
	}

}
