package model.Element.MotionlessElement;

import entity.Permeability;
import entity.Sprite;

public class Background extends MotionlessElement {

	private static Sprite sprite = new Sprite (' ', "solnoire.png");
	public Background() {
	super(sprite, Permeability.PENETRABLE);
		// TODO Auto-generated constructor stub
	}

}
