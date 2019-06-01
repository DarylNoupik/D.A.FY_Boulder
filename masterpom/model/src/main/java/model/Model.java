package model;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Observable;

import contract.IModel;
import entity.HelloWorld;
import entity.IMap;
import entity.IMobile;
import entity.Sprite;
import model.Element.Mobile.Rockford;

/**
 * The Class Model.
 *
 * @author Jean-Aymeric Diet
 */
public final class Model extends Observable implements IModel {

	/** The helloWorld. */
	private HelloWorld helloWorld;

	/**
	 * Instantiates a new model.
	 */
	public Model() {
		this.helloWorld = new HelloWorld();
	}

	/**
     * Gets the hello world.
     *
     * @return the hello world
     */
	/*
	 * (non-Javadoc)
	 *
	 * @see contract.IModel#getMessage()
	 */
	public HelloWorld getHelloWorld() {
		return this.helloWorld;
	}

	/**
     * Sets the hello world.
     *
     * @param helloWorld
     *            the new hello world
     */
	private void setHelloWorld(final HelloWorld helloWorld) {
		this.helloWorld = helloWorld;
		this.setChanged();
		this.notifyObservers();
	}

	/**
     * Load hello world.
     *
     * @param code
     *            the code
     */
	/*
	 * (non-Javadoc)
	 *
	 * @see contract.IModel#getMessage(java.lang.String)
	 */
	public void loadHelloWorld(final String code) {
		try {
			final DAOHelloWorld daoHelloWorld = new DAOHelloWorld(DBConnection.getInstance().getConnection());
			this.setHelloWorld(daoHelloWorld.find(code));
		} catch (final SQLException e) {
			e.printStackTrace();
		}
	}

	/**
     * Gets the observable.
     *
     * @return the observable
     */
	/*
	 * (non-Javadoc)
	 *
	 * @see contract.IModel#getObservable()
	 */
	public Observable getObservable() {
		return this;
	}

	
	private IMap map ;
	/**              */
	private IMobile rockford ;

	public Model( int mapID) throws IOException, SQLException {
	super();
	Sprite.loadBuffers();
	this.setMap(MapDao.getMapById(mapID));
	this.setRockford(new Rockford (1,1,this.getMap()));
	}
	public IMap getMap() {
	return map;
	}

	
	public void setMap(IMap map) {
	this.map = map;
	}

	/**
	 * Moves pawns (boulders, diamonds, ...).
	 * Their movement is related to their strategy.
	 */
	
	public IMobile getRockford() {
	return rockford;
	}

	public void setRockford(IMobile rockford) {
	this.rockford = rockford;
	}

	}

