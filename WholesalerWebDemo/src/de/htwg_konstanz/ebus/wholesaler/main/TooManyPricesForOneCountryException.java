package de.htwg_konstanz.ebus.wholesaler.main;

/**
 * Needed in case of more than one price for one country.
 */
public class TooManyPricesForOneCountryException extends Exception {

	/**
	 * Default serialVersionUID.
	 */
	private static final long serialVersionUID = -8336552305248298816L;

	/**
	 * Parameterless Constructor.
	 */
    public TooManyPricesForOneCountryException() { }

    /**
     * Constructor that accepts a message.
     * @param message Message
     */
    public TooManyPricesForOneCountryException(String message) {
       super(message);
    }
}
