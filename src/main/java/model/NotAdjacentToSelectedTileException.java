package model;

/**
 * Represents an Exception that will be thrown when some tile is not adjacent to
 * the selected Tile and it needs to be.
 *
 * @version 1.0
 * @author Ryan Voor
 */
class NotAdjacentToSelectedTileException extends Exception {

    /**
     * Public constructor.
     *
     * @param message the message carried by this Exception.
     */
    public NotAdjacentToSelectedTileException(String message) {
        super(message);
    }
}
