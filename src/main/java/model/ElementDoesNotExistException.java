package model;

/**
 * Represents an Exception that will be thrown if an Element does not exist at a
 * particular tile.
 *
 * @version 1.0
 * @author Ryan Voor
 */
public class ElementDoesNotExistException extends Exception {
    private Object object;

    /**
     * Public constructor.
     *
     * @param message the message carried by this Exception.
     */
    public ElementDoesNotExistException(String message) {
        this(message, null);
    }

    /**
     * Public construcotr.
     *
     * @param message the message carried by this Exception.
     * @param object the Object that caused this Exception.
     */
    public ElementDoesNotExistException(String message, Object object) {
        super(message);
        this.object = object;
    }

    /**
     * @return the Object that caused this Exception.
     */
    public Object getObject() {
        return this.object;
    }
}
