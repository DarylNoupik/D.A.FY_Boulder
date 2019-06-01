package model.Element.Mobile;

import java.awt.Rectangle;

import entity.IMap;
import entity.Permeability;
import entity.Sprite;

public class Diamond extends Mobile {

	private static final Sprite sprite = new Sprite('D', Sprite.mapTileSet, new Rectangle(64, 0, 16, 16));
public	Diamond(int x, int y,IMap map) {
		super(x, y, sprite, Permeability.MINEABLE,map);
		// TODO Auto-generated constructor stub
	}

}
