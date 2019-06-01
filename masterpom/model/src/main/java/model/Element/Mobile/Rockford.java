package model.Element.Mobile;

import java.awt.Rectangle;
import java.io.IOException;

import entity.IMap;
import entity.Permeability;
import entity.Sprite;

public class Rockford extends Mobile {

	 /** The Constant SPRITE. */
    private static final Sprite sprite          = new Sprite('H', Sprite.characterTileSet, new Rectangle(16, 0, 16, 16));
    
    private static final Sprite spriteTurnLeft  = new Sprite('H',Sprite.characterTileSet,
			new Rectangle(16, 16, 16, 16));
    
    /** The Constant spriteTurnRight. */
    private static final Sprite spriteTurnRight = new Sprite('H', Sprite.characterTileSet,
			new Rectangle(16, 48, 16, 16));
    
    /** The Constant spriteUp. */
    private static final Sprite spriteUp   = new Sprite('H',Sprite.characterTileSet, new Rectangle(32, 80, 16, 16));
    
    /** The Constant spriteTurnDown. */
	private static final Sprite spriteTurnDown = new Sprite('H', Sprite.characterTileSet,
			new Rectangle(64, 16, 16, 16));
	private static final Sprite spriteDie = new Sprite('H', Sprite.characterTileSet, new Rectangle(64, 0, 16, 16));
	
	
	public Rockford(int x, int y, IMap map) throws IOException {
		super(x, y, sprite, Permeability.BLOCKING,map);
		    spriteTurnLeft.loadImage();
	        spriteTurnRight.loadImage();
	        spriteUp.loadImage();
	        spriteTurnDown.loadImage();
			spriteDie.loadImage();
			sprite.loadImage();
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
