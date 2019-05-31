package view;

import java.awt.Dimension;
import java.awt.Rectangle;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;

import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

import contract.ControllerOrder;
/*import contract.IController;
import contract.IModel;*/
import contract.IOderPerformer;
import contract.IView;
import entity.*;
import fr.exia.showboard.BoardFrame;

/**
 * The Class View.
 *
 * @author Jean-Aymeric Diet
 */
public final class View implements IView, Runnable,KeyListener {

	
	
	
	private static final int  mapView = 10 ;
	
	private static final int squareSize = 50;
	
	private Rectangle closeView;
	
	private IMap map ;
	
	private IMobile rockford ;
	
	private  int View;
	
	private IOderPerformer orderPerformer;
	
	
	/** The frame. */
	//private final ViewFrame viewFrame;

	/**
	 * Instantiates a new view.
	 *
	 * @param iMobile
	 *          the model
	 * @throws IOException 
	 */
	public View( IMap map , IMobile rockford) throws IOException {
		this.setView(mapView);
		this.setMap(map);
		this.setRockford(rockford);
		this.getRockford().getSprite().loadImage();
		this.setCloseView(new Rectangle(0,this.getRockford().getY(),this.getMap().getWidth(),mapView));
		
		SwingUtilities.invokeLater(this);
	}

	/**
	 * Key code to controller order.
	 *
	 * @param keyCode
	 *          the key code
	 * @return the controller order
	 */
	protected static ControllerOrder keyCodeToControllerOrder(final int keyCode) {
		switch (keyCode) {
			case KeyEvent.VK_RIGHT:
				return ControllerOrder.RIGHT;
			case KeyEvent.VK_LEFT:
				return ControllerOrder.LEFT;
			case KeyEvent.VK_DOWN:
				return ControllerOrder.DOWN;
			case KeyEvent.VK_UP:
				return ControllerOrder.UP;
			default:
				return ControllerOrder.NOP;
		}
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see contract.IView#printMessage(java.lang.String)
	 */
	/*public void printMessage(final String message) {
		this.viewFrame.printMessage(message);
	}*/

	/*
	 * (non-Javadoc)
	 *
	 * @see java.lang.Runnable#run()
	 */
	public void run() {
		final BoardFrame board = new BoardFrame("Close view");
		board.setDimension(new Dimension(this.getMap().getWidth(),this.getMap().getHeight()) );
	    board.setDisplayFrame(this.closeView);
	    board.setSize(this.closeView.width*squareSize, this.closeView.height*squareSize);
	    board.setHeightLooped(true);
        board.addKeyListener(this);
        board.setFocusable(true);
        board.setFocusTraversalKeysEnabled(false);
        for (int x = 0; x < this.getMap().getWidth(); x++) {
            for (int y = 0; y < this.getMap().getHeight(); y++) {
                board.addSquare(this.map.getOnTheMapXY(x, y), x, y);
            }
        }
        board.addPawn(this.getRockford());

        this.getMap().getObservable().addObserver(board.getObserver());
        this.followRockford();

        board.setVisible(true);
	}

	/**
	 * Sets the controller.
	 *
	 * @param controller
	 *          the new controller
	 */
/*	public void setController(final IController controller) {
		this.viewFrame.setController(controller);
	}
*/
	@Override
	public void displayMessage(String message) {
		JOptionPane.showMessageDialog(null, message);
		
	}

	@Override
	public void followRockford() {
		// TODO Auto-generated method stub
	this.getCloseView().y = this.getRockford().getY()-1;	
	}

	public Rectangle getCloseView() {
		return closeView;
	}

	public void setCloseView(Rectangle closeView) {
		this.closeView = closeView;
	}

	public IMap getMap() {
		return map;
	}

	public void setMap(IMap map) {
		this.map = map;
	}

	public IMobile getRockford() {
		return rockford;
	}

	public void setRockford(IMobile rockford) {
		this.rockford = rockford;
	}

	public int getView() {
		return View;
	}

	public void setView(int view) {
		View = view;
	}

	public IOderPerformer getOrderPerformer() {
		return orderPerformer;
	}

	public void setOrderPerformer(IOderPerformer orderPerformer) {
		this.orderPerformer = orderPerformer;
	}

	@Override
	public void keyPressed(KeyEvent d) {
		// TODO Auto-generated method stub
		try {
			this.getOrderPerformer().orderPerform(keyCodeToControllerOrder(d.getKeyCode()));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	public final void show(final int yStart) {
        int y = yStart % this.getMap().getHeight();
        for (int view = 0; view < this.getView(); view++) {
            for (int x = 0; x < this.getMap().getWidth(); x++) {
                if ((x == this.getRockford().getX()) && (y == yStart)) {
                    System.out.print(this.getRockford().getSprite().getConsoleImage());
                } else {
                    System.out.print(this.getMap().getOnTheMapXY(x, y).getSprite().getConsoleImage());
                }
            }
            y = (y + 1) % this.getMap().getHeight();
            System.out.print("\n");
        }
    }

	@Override
	public void printMessage(String message) {
		// TODO Auto-generated method stub
		
	}

}
