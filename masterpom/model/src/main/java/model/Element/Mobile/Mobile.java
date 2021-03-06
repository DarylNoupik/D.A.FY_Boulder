package model.Element.Mobile;

//import java.awt.Image;

import java.awt.Point;
import java.io.IOException;

import entity.IMap;
import entity.IMobile;
import entity.Permeability;
import entity.Sprite;
import fr.exia.showboard.IBoard;
import model.Element.Element;
import model.Element.MotionlessElement.MotionlessElementFactory;

public abstract class Mobile  extends Element implements IMobile {

	 /**
     * The x.
     */
    private Point   position;

    /** The alive. */
    private Boolean alive = true;

    /** The road. */
   

    /** The board. */
    private IBoard  board;
    
    private IMap map ;

	private boolean fallSpeed = false;

    /**
     * Instantiates a new mobile.
     *
     * @param sprite
     *            the sprite
     * @param road
     *            the road
     * @param permeability
     *            the permeability
     */
    Mobile(final Sprite sprite,  final Permeability permeability, IMap map) {
        super(sprite, permeability);
        this.map = map;
        this.position = new Point();
    }

    /**
     * Instantiates a new mobile.
     *
     * @param x
     *            the x
     * @param y
     *            the y
     * @param sprite
     *            the sprite
     * @param road
     *            the road
     * @param permeability
     *            the permeability
     */
    Mobile(final int x, final int y, final Sprite sprite,  final Permeability permeability,IMap map) {
        this(sprite, permeability,map);
        this.getPosition().x = x;
        this.getPosition().y = y ;
    }

    /*
     * (non-Javadoc)
     * @see fr.exia.insanevehicles.model.element.mobile.IMobile#moveUp()
     */
    @Override
    public void moveUp() {
        this.setY(this.getY() - 1);
        this.setHasMoved();
    }

    /*
     * (non-Javadoc)
     * @see fr.exia.insanevehicles.model.element.mobile.IMobile#moveLeft()
     */
    @Override
    public void moveLeft() {
        this.setX(this.getX() - 1);
        this.setHasMoved();
    }

    /*
     * (non-Javadoc)
     * @see fr.exia.insanevehicles.model.element.mobile.IMobile#moveDown()
     */
    @Override
    public void moveDown() {
        this.setY(this.getY() + 1);
        this.setHasMoved();
        this.fallSpeed  = true;
    }

    /*
     * (non-Javadoc)
     * @see fr.exia.insanevehicles.model.element.mobile.IMobile#moveRight()
     */
    @Override
    public void moveRight() {
        this.setX(this.getX() + 1);
        this.setHasMoved();
    }

    /*
     * (non-Javadoc)
     * @see fr.exia.insanevehicles.model.element.mobile.IMobile#doNothing()
     */
    @Override
    public void doNothing() {
        this.setHasMoved();
        this.fallSpeed = false;
    }

    /**
     * Sets the has moved.
     */
    private void setHasMoved() {
      this.getMap().setMobileHasChanged();
    }
    public void dig() {
		this.getMap().setOnTheMapXY(this.getX(), this.getY(), MotionlessElementFactory.createBackground() );
		try {
			this.getMap().getOnTheMapXY(getX(), getY()).getSprite().loadImage();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}


    public IMap getMap() {
		return map;
	}

	public void setMap(IMap map) {
		this.map = map;
	}

	/*
     * (non-Javadoc)
     * @see fr.exia.insanevehicles.model.element.mobile.IMobile#getX()
     */
    @Override
    public final int getX() {
        return this.getPosition().x;
    }

    /**
     * Sets the x.
     *
     * @param x
     *            the new x
     */
    public final void setX(final int x) {
        this.getPosition().x = x;
        if (this.isCrashed()) {
            this.die();
        }
    }

    /*
     * (non-Javadoc)
     * @see fr.exia.insanevehicles.model.element.mobile.IMobile#getY()
     */
    @Override
    public final int getY() {
        return this.getPosition().y;
    }

    /**
     * Sets the y.
     *
     * @param y
     *            the new y, as the road is an infinite loop, there's a modulo
     *            based on the road height.
     */
    public final void setY(final int y) {
        
        }
    

    /**
     * Gets the road.
     *
     * @return the road
     */
    
    /**
     * Sets the road.
     *
     * @param road
     *            the new road
     */
   
    /*
     * (non-Javadoc)
     * @see fr.exia.insanevehicles.model.element.mobile.IMobile#isAlive()
     */
    @Override
    public Boolean isAlive() {
        return this.alive;
    }

    /**
     * Dies.
     */
    protected void die() {
        this.alive = false;
        this.setHasMoved();
    }

    /*
     * (non-Javadoc)
     * @see fr.exia.insanevehicles.model.element.mobile.IMobile#isCrashed()
     */
    @Override
    public Boolean isCrashed() {
		return alive;
       
    }

    public Point getPosition() {
        return this.position;
    }

    /**
     * Sets the position.
     *
     * @param position
     *            the position to set
     */
    public void setPosition(final Point position) {
        this.position = position;
    }

    /**
     * Gets the board.
     *
     * @return the board
     */
    protected IBoard getBoard() {
        return this.board;
    }


}
