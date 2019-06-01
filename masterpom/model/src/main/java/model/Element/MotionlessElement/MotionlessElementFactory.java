package model.Element.MotionlessElement;

public class MotionlessElementFactory {
	/**
	* Instantiates the constants motionless Elements for their creation .
	*/
	private static final Wall wall = new Wall ();
	private static final Background background = new Background ();
	private static final Ground ground = new Ground ();
	/**
	*  The motionless elements is an array of all possible motionlessElements
	*/
	private static MotionlessElement[] motionlessElements = {
	wall,
	background,
	ground
	};
	/**
	* Creation of motionless elements .
	* 
	* @return the motionlessElement
	*/
	public static MotionlessElement createWall() {
	return wall;
	}
	public static  MotionlessElement createGround() {
	return ground;
	}
	public static MotionlessElement createBackground() {
	return background ;
	}
	/**
	* Gets the motionlesselement from file symbol
	* 
	* @param fileSymbol
	* the file symbol
	* @return the from file symbol
	*/
	public static MotionlessElement getFromFileSymbol(char fileSymbol) {
	for (MotionlessElement motionlessElement : motionlessElements) {
	if (motionlessElement.getSprite().getConsoleImage()== fileSymbol) {
	return motionlessElement;
	}
	}
	return background;
	}

}
