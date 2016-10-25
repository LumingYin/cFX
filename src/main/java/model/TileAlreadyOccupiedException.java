package model;

/**
 * Represents an Exception that will be thrown when some Tile is already
 * occupied and is needed to be empty.
 *
 * @version 1.0
 * @author Ryan Voor
 */
class TileAlreadyOccupiedException extends Exception {

    /**
     * Public constructor.
     *
     * @param message the message carried by this Exception.
     */
    public TileAlreadyOccupiedException(String message) {
        super(message);
    }
}
