package contract;

/**
 * The Interface IView.
 *
 * @author Jean-Aymeric Diet
 */
public interface IView {

	/**
	 * Prints the message.
	 *
	 * @param message
	 *          the message
	 */
	void printMessage(final String message);
	/**
     * Display message.
     *
     * @param message
     *            the message
     */
    void displayMessage(String message);

    /**
     * Follow myVehicle.
     */
    void followRockford();

}
