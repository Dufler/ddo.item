package ddo.item.wiki;

/**
 * Exception thrown only for some items that can't be parsed from wiki because the format is really bad or because many different versions exists.
 */
public class SkipItemException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	public SkipItemException(String itemName) {
		super(itemName);
	}

}
