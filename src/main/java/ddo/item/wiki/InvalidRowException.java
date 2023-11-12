package ddo.item.wiki;

/**
 * Exception thrown when the row has info different from what excepted and then can't be parsed correctly.
 */
public class InvalidRowException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	public InvalidRowException(String message) {
		super(message);
	}

}
