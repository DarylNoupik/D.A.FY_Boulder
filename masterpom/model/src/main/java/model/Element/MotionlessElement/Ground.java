package model.Element.MotionlessElement;

import entity.Permeability;
import entity.Sprite;

public class Ground extends MotionlessElement {

	private static Sprite sprite = new Sprite ('G', "terre.png;");
	public Ground( ) {
	super(sprite, Permeability.MINEABLE);
		// TODO Auto-generated constructor stub
	}

}
