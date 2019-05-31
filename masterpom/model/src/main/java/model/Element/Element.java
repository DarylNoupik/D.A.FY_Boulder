package model.Element;

import java.awt.Image;

import entity.IElement;
import entity.Permeability;
import entity.Sprite;

public abstract class Element implements IElement {

	private Sprite sprite ;
	
	private Permeability permeability ;
	
	  public Element(final Sprite sprite, final Permeability permeability) {
	        this.setSprite(sprite);
	        this.setPermeability(permeability);
	    }

	public Sprite getSprite() {
		return sprite;
	}

	public void setSprite(Sprite sprite) {
		this.sprite = sprite;
	}

	public Permeability getPermeability() {
		return permeability;
	}

	public void setPermeability(Permeability permeability) {
		this.permeability = permeability;
	}

	@Override
	public Image getImage() {
		// TODO Auto-generated method stub
		return this.getSprite().getImage();
	}
	
	
	
}
