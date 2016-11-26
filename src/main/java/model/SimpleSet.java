package model;

/**
 * Any class implementing this interface is a set
 * In other words it is a data structure that has
 * no particular ordering and only unique elements
 * @author Ryan Voor
 * @version 1.0
 */
interface SimpleSet<E> {

    /**
     * Adds the passed in element to the set.
     * @param e the element to be added to the set
     */
    boolean add(E e);

    /**
     * Removes the passed in element from the set if it is
     * contained in the set, then returns the removed element
     * otherwise throws as ElementDoesNotExistException
     * @param e the element to be removed
     * @return E the element that was removed
     */
    E remove(E e) throws ElementDoesNotExistException;

    /**
     * Returns true if the passed in element is contained in
     * the set.
     * Returns false if the passed in element is not contained
     * in the set.
     * @param e the element to be checked
     * @return whether the passed in element is contained
     * in the set
     */
    boolean contains(E e);

    /**
     * Removes all the passed in elements from the set then returns them.
     * Throws a ElementDoesNotExistException if one of the passed in elements
     * is not in the set.
     * NOTE: This method should not remove ANY elements from the set
     * if it throws a NoSuchElementException.
     * @param e the elements to be removed from the set
     * @return E[] the elements that were removed from the set
     */
    E[] removeAll(E[] e) throws ElementDoesNotExistException;

    /**
     * Removes all elements from the set.
     */
    void clear();

    /**
     * Returns the number of elements contained in the set.
     * @return int the number of elements in the set
     */
    int size();

    /**
     * Returns false if the set contains 1 or more elements and
     * returns true if the set contains no elements.
     * @return boolean whether the set contains any elements
     */
    boolean isEmpty();

    /**
     * Returns a random element from the set.
     * NOTE: because the set has no ordering returning any element in the
     * set is effectively returning a "random" element
     * throws a ElementDoesNotExistException if there are no elements
     * in the set
     * HINT: you may import java.util.Random to help with this if
     * you want
     * @return E a random element from the set
     */
    E getRandomElement() throws ElementDoesNotExistException;

    /**
     * Returns an array of all the elements contained within the SimpleSet.
     * There should be no nulls in the array.
     * @return an array containing all the elements contained
     * within the set
     */
    E[] toArray();

    /**
     * Calculates and returns a String representation of this object.
     * Any String that shows each individual element's toString
     * is acceptable.
     * @return String the String representation of this object
     */
    @Override
    String toString();

}
