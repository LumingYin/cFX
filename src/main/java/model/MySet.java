package model;
import java.util.Random;
@SuppressWarnings("unchecked")

class MySet<E> implements SimpleSet<E> {


    private E[] array;
    private int size;
    private boolean hasNullInSet;

    // Constructor
    public MySet() {
        hasNullInSet = false;
        array = (E[]) new Object[1];
        this.size = 0;
    }

    // These are private methods to help with the expansion and sorting of array
    private void expandArray() {
        E[] tempArray = (E[]) new Object[array.length * 2];
        for (int i = 0; i < array.length; i++) {
            tempArray[i] = array[i];
        }
        array = tempArray;
    }

    private void sortArray() {
        if (size >= array.length) {
            expandArray();
        }
        for (int i = 0; i < array.length - 1; i++) {
            if (array[i] == null) {
                array[i] = array[i + 1];
                array[i + 1] = null;
            }
        }
        int tempActualElementInArray = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] != null) {
                tempActualElementInArray++;
            }
        }
        size = tempActualElementInArray;
    }

    // These are public methods to manipulate the set
    public boolean add(E e) {
        if (e == null && !hasNullInSet) {
            hasNullInSet = true;
            return true;
        } else if (e == null && hasNullInSet) {
            return false;
        } else {
            if (contains(e)) {
                return false;
            }
            sortArray();
            array[size++] = e;
            return true;
        }
    }

    public E remove(E e) throws ElementDoesNotExistException {
        E passedInElement = e;
        if (passedInElement == null) {
            if (hasNullInSet) {
                hasNullInSet = false;
                return passedInElement;
            } else {
                throw new ElementDoesNotExistException("Element "
                    + "does not exist in set!");
            }
        }
        boolean doesNotExist = true;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == passedInElement) {
                array[i] = null;
                doesNotExist = false;
                sortArray();
            }
        }
        if (doesNotExist) {
            throw new ElementDoesNotExistException("Element "
                + "does not exist in set!");
        }
        return passedInElement;
    }

    public boolean contains(E e) {
        if (e == null) {
            if (hasNullInSet) {
                return true;
            }
            return false;
        }
        for (E item:array) {
            if (item != null && item.equals(e)) {
                return true;
            }
        }
        return false;
    }

    public E[] removeAll(E[] e) throws ElementDoesNotExistException {
        for (E content:e) {
            if (!contains(content)) {
                throw new ElementDoesNotExistException("Because "
                + "one of the elements passed in by the array do "
                + "not exist in the set, none of the passed in "
                + "elements will be removed.", content);
            }
        }
        for (E content:e) {
            this.remove(content);
        }
        return e;
    }

    public void clear() {
        for (int i = 0; i < array.length; i++) {
            array[i] = null;
        }
        hasNullInSet = false;
        size = 0;
    }

    public int size() {
        sortArray();
        if (hasNullInSet) {
            return size + 1;
        }
        return size;
    }

    public boolean isEmpty() {
        if (hasNullInSet) {
            return false;
        }
        boolean isEmpty = true;
        for (E item:array) {
            if (item != null) {
                isEmpty = false;
                break;
            }
        }
        return isEmpty;
    }

    public E getRandomElement() throws ElementDoesNotExistException {
        // sortArray();
        if (isEmpty()) {
            throw new ElementDoesNotExistException("There is no"
                + "element to return, since the set is empty.");
        }
        Random rn = new Random();
        int randomNumber;
        if (hasNullInSet) {
            randomNumber = rn.nextInt(size + 1);
        } else {
            randomNumber = rn.nextInt(size);
        }
        if (randomNumber == size + 1) {
            return null;
        }
        return array[randomNumber];
    }

    public E[] toArray() {
        sortArray();
        E[] toBeReturned;
        if (hasNullInSet) {
            toBeReturned = (E[]) new Object[size + 1];
        } else {
            toBeReturned = (E[]) new Object[size];
        }
        for (int i = 0; i < size; i++) {
            toBeReturned[i] = array[i];
        }
        return toBeReturned;
    }

    @Override
    public String toString() {
        String compositedString = "";
        for (int i = 0; i < size; i++) {
            if (i < size - 1) {
                compositedString += (array[i].toString() + ", ");
            } else {
                compositedString += array[i].toString();
            }
        }
        if (hasNullInSet) {
            if (!compositedString.equals("")) {
                compositedString += ", null";
            } else {
                compositedString += "null";
            }
        }
        return compositedString;
    }
}