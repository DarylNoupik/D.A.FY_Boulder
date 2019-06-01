package model.Element.Mobile;

import java.awt.Rectangle;
import java.io.IOException;

import entity.IMap;
import entity.Permeability;
import entity.Sprite;

public class Monster extends Mobile {
	private static final Sprite sprite = new Sprite('M', Sprite.mapTileSet, new Rectangle(144, 16, 16, 16));
	public Monster(int x, int y, IMap map) throws IOException {
		super(x, y, sprite, Permeability.BLOCKING ,map);
		sprite.loadImage();		
		// TODO Auto-generated constructor stub
	}

}
