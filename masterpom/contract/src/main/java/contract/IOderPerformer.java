package contract;

import java.io.IOException;

public interface IOderPerformer {
	 /**
     * Order perform.
     *
     * @param userOrder
     *            the user order
     * @throws IOException
     *             Signals that an I/O exception has occurred.
     */
    void orderPerform(ControllerOrder userOrder) throws IOException;
}
