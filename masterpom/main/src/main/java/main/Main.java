/**
 * @author Jean-Aymeric DIET jadiet@cesi.fr
 * @version 1.0
 */
package main;

import java.io.IOException;
import java.sql.SQLException;

import javax.swing.JOptionPane;

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
     * @throws SQLException 
     */
	
	 
	    
	    
    public static void main(final String[] args) throws IOException, InterruptedException, SQLException {
        
    	String idToAsk= JOptionPane.showInputDialog("Hello ! Please input id of the map : ", 1);
        int idAsked = Integer.parseInt(idToAsk);
        
    	final Model model = new Model(idAsked);
        final View view = new View( model.getMap(),model.getRockford(),model.getMap().getPawns());
        final Controller controller = new Controller(view, model);
        view.setOrderPerformer(controller.getOrderPeformer());
        try {
        controller.play();
        } catch (InterruptedException e) {
        	System.out.println(e.getMessage());
			e.printStackTrace();
		}
    }
}
