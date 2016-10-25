package model;

/**
 * Represents an Exception that gets thrown when a Unit is unable to move.
 *
 * @version 1.0
 * @author Ryan Voor
 */
class UnitCannotMoveException extends Exception {

    /**
     * Public constructor.
     *
     * @param message the message carried by this Exception.
     */
    public UnitCannotMoveException(String message) {
        super(message);
    }
}
