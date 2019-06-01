package model.Element.Mobile;

import java.awt.Rectangle;

import entity.IMap;
import entity.Permeability;
import entity.Sprite;

public class Stone extends Mobile {
	
	/** The static Constant SPRITE. */
	private static final Sprite sprite = new Sprite('R', Sprite.mapTileSet, new Rectangle(144, 16, 16, 16));

	Stone(int x, int y,IMap map) {
		super(x, y, sprite, Permeability.BLOCKING,map);
		// TODO Auto-generated constructor stub
	}

}
