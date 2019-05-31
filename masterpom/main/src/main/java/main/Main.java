/**
 * @author Jean-Aymeric DIET jadiet@cesi.fr
 * @version 1.0
 */
package main;

import java.io.IOException;


 
import controller.Controller;
import model.Model;
import view.View;

/**
 * The Class Main.
 *
 * @author Jean-Aymeric Diet
 */
public abstract class Main {

    /**
     * The main method.
     *
     * @param args
     *            the arguments
     */
	
	 private static final int X = 5;

	    /** The Constant startY. */
	    private static final int Y = 0;
	    
	    
    public static void main(final String[] args) throws IOException, InterruptedException {
        final Model model = new Model("level.txt",X,Y);
        final View view = new View( model.getMap(),model.getRockford());
        final Controller controller = new Controller(view, model);
        view.setOrderPerformer(controller.getOrderPeformer());

        controller.play();
        
    }
}
