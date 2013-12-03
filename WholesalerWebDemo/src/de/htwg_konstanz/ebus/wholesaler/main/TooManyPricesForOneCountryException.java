package de.htwg_konstanz.ebus.wholesaler.main;

public class TooManyPricesForOneCountryException extends Exception{
	 /**
	 * 
	 */
	private static final long serialVersionUID = -8336552305248298816L;

	//Parameterless Constructor
    public TooManyPricesForOneCountryException() {}

    //Constructor that accepts a message
    public TooManyPricesForOneCountryException(String message)
    {
       super(message);
    }
}
