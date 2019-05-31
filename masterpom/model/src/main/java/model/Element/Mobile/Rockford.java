package model.Element.Mobile;

import java.io.IOException;

import entity.IMap;
import entity.Permeability;
import entity.Sprite;

public class Rockford extends Mobile {

	 /** The Constant SPRITE. */
    private static final Sprite sprite          = new Sprite('H', "perso.png");
    
    private static final Sprite spriteTurnLeft  = new Sprite('H', "persoLeft.png");
    
    /** The Constant spriteTurnRight. */
    private static final Sprite spriteTurnRight = new Sprite('H', "persoRight.png");
    
    /** The Constant spriteUp. */
    private static final Sprite spriteUp   = new Sprite('H', "persoUp.png");
	
	
	public Rockford(int x, int y, IMap map) throws IOException {
		super(x, y, sprite, Permeability.BLOCKING);
		    spriteTurnLeft.loadImage();
	        spriteTurnRight.loadImage();
	        spriteUp.loadImage();
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void moveDown() {
		// TODO Auto-generated method stub
		super.moveDown();
		this.setSprite(spriteTurnRight);
	}
	
	@Override
	public void moveRight() {
		// TODO Auto-generated method stub
		super.moveRight();
		this.setSprite(spriteTurnRight);
	}
	@Override
	public void moveUp() {
		// TODO Auto-generated method stub
		super.moveUp();
		this.setSprite(spriteUp);
	}
	@Override
	public void moveLeft() {
		// TODO Auto-generated method stub
		super.moveLeft();
		this.setSprite(spriteTurnLeft);
	}
@Override
protected void die() {
	// TODO Auto-generated method stub
	super.die();
}

@Override
public void doNothing() {
	// TODO Auto-generated method stub
	super.doNothing();
	this.setSprite(sprite);
}
	

	

}
