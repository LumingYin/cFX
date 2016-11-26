package model;

import java.util.Random;

/**
 * Represents a custom Set data structure.
 *
 * @author Ryan Voor
 * @version 1.0
 */
class MySet<E> implements SimpleSet<E> {

    private E[] data;
    private int numElements;
    private final int startingSize = 5;

    /**
     * Public constructor.
     */
    @SuppressWarnings("unchecked")
    public MySet() {
        this.data = (E[]) new Object[startingSize];
        this.numElements = 0;
    }

    @Override
    public boolean add(E e) {
        if (this.contains(e)) {
            return false;
        }
        if (numElements >= data.length) {
            this.doubleBackingArray();
        }
        data[numElements++] = e;
        return true;
    }

    @Override
    public boolean contains(E e) {
        for (int i = 0; i < numElements; i++) {
            if (data[i].equals(e)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public E remove(E e) throws ElementDoesNotExistException {
        for (int i = 0; i < numElements; i++) {
            if (data[i].equals(e)) {
                E toBeReturned = data[i];
                data[i] = null;
                for (int j = i; j < numElements; j++) {
                    data[j] = data[j + 1];
                }
                numElements--;
                return toBeReturned;
            }
        }
        throw new ElementDoesNotExistException(
            "Cannot remove an element that isn't in the set!", e);
    }

    @Override
    @SuppressWarnings("unchecked")
    public E[] removeAll(E[] elements) throws ElementDoesNotExistException {
        for (E element: elements) {
            if (!this.contains(element)) {
                throw new ElementDoesNotExistException("Attempted to remove "
                    + element + " from set but it wasn't in the set!");
            }
        }
        E[] results = (E[]) new Object[elements.length];
        int counter = 0;
        for (E element: elements) {
            // hypothetically a ElementDoesNotExistException should never
            // get thrown from this call since we checked above
            results[counter++] = this.remove(element);
        }
        return results;
    }

    @Override
    @SuppressWarnings("unchecked")
    public void clear() {
        this.data = (E[]) new Object[startingSize];
        this.numElements = 0;
    }

    @Override
    public int size() {
        return numElements;
    }

    @Override
    public boolean isEmpty() {
        return numElements == 0;
    }

    @Override
    public E getRandomElement() throws ElementDoesNotExistException {
        if (this.isEmpty()) {
            throw new ElementDoesNotExistException(
                "Cannot get an element from a empty set!");
        }
        Random rand = new Random();
        return data[rand.nextInt(numElements)];
    }

    @Override
    @SuppressWarnings("unchecked")
    public E[] toArray() {
        E[] result = (E[]) new Object[numElements];
        for (int i = 0; i < numElements; i++) {
            result[i] = data[i];
        }
        return result;
    }

    @Override
    public String toString() {
        String result = "[";
        for (int i = 0; i < numElements; i++) {
            if (i == numElements - 1) {
                result += "" + data[i];
            } else {
                result += "" + data[i] + ", ";
            }
        }
        result += "]";
        return result;
    }

    /**
     * Doubles the size of the backing array while maintaining all of the
     * elements in the SimpleSet.
     */
    @SuppressWarnings("unchecked")
    private void doubleBackingArray() {
        E[] newArray = (E[]) new Object[data.length * 2];
        for (int i = 0; i < numElements; i++) {
            newArray[i] = data[i];
        }
        data = newArray;
    }
}
