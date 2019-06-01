package controller;

import contract.ControllerOrder;
import contract.IController;
import contract.IModel;
import contract.IOderPerformer;
import contract.IView;

/**
 * The Class Controller.
 */
public final class Controller implements IController,IOderPerformer {
	 private static final int speed = 200;
	/** The view. */
	private IView		view;

	/** The model. */
	private IModel model;
	
	private ControllerOrder stackOrder ;

	/**
	 * Instantiates a new controller.
	 *
	 * @param view
	 *          the view
	 * @param model
	 *          the model
	 */
	public Controller(final IView view, final IModel model) {
		this.setView(view);
		this.setModel(model);
		this.clearStackOrder();
	}

	/**
     * Control.
     */
	/*
	 * (non-Javadoc)
	 *
	 * @see contract.IController#control()
	 */
	public void control() {
		this.view.printMessage("Appuyer sur les touches 'E', 'F', 'D' ou 'I', pour afficher Hello world dans la langue d votre choix.");
	}

	/**
     * Sets the view.
     *
     * @param pview
     *            the new view
     */
	private void setView(final IView pview) {
		this.view = pview;
	}

	/**
	 * Sets the model.
	 *
	 * @param model
	 *          the new model
	 */
	private void setModel(final IModel model) {
		this.model = model;
	} 
	
	public IModel getModel() {
		return model ;
	}

	/**
     * Order perform.
     *
     * @param controllerOrder
     *            the controller order
     */
	/*
	 * (non-Javadoc)
	 *
	 * @see contract.IController#orderPerform(contract.ControllerOrder)
	 */
	public void orderPerform(final ControllerOrder controllerOrder) {
		switch (controllerOrder) {
			case English:
				this.model.loadHelloWorld("GB");
				break;
			case Francais:
				this.model.loadHelloWorld("FR");
				break;
			case Deutsch:
				this.model.loadHelloWorld("DE");
				break;
			case Indonesia:
				this.model.loadHelloWorld("ID");
				break;
			default:
				break;
		}
	}

	@Override
	public void play() throws InterruptedException {
		// TODO Auto-generated method stub
		while (this.getModel().getRockford().isAlive()) {
            Thread.sleep(speed);
            switch (this.getStackOrder()) {
                case RIGHT:
                    this.getModel().getRockford().moveRight();
                    break;
                case LEFT:
                    this.getModel().getRockford().moveLeft();
                    break;
                case UP :
                	this.getModel().getRockford().moveUp();
                	break;
                case DOWN :
                	this.getModel().getRockford().moveDown();
                case NOP:
                default:
                    this.getModel().getRockford().doNothing();
                    break;
            }
           
            this.clearStackOrder();
            
            this.getView().followRockford();
        }
		this.getView().updateBoardFrame();

	      if (this.getModel().getMap().getDiamondCount() == 0) {
	        this.getView().displayMessage("You won !! Congratulations ;) ");
	        System.exit(0);
	      }
	    
	    this.getView().displayMessage("You are dead, GAME OVER. ");
	    System.exit(0);
	}

	private IView getView() {
		// TODO Auto-generated method stub
		return view;
	}

	@Override
	public IOderPerformer getOrderPeformer() {
		// TODO Auto-generated method stub
		return this;
	}

	public ControllerOrder getStackOrder() {
		return stackOrder;
	}

	public void setStackOrder(ControllerOrder stackOrder) {
		this.stackOrder = stackOrder;
	}
	 
	private void clearStackOrder() {
        this.stackOrder = ControllerOrder.NOP;
    }
}
