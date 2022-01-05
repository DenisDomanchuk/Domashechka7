import java.util.NoSuchElementException;

public class DynamicIntArray {
    /**
     * Array for storing numbers
     */
    private int[] array = new int[10];


    /**
     * Current size of the array
     */
    private int size = 0;

    /**
     * Method for adding element to the array
     *
     * @param element represents number need to add
     */
    public void add(int element) {
        if (size == array.length) {
            resize();
        }
        array[size] = element;
        size++;
    }

    /**
     * Method for removing first element from array
     *
     * @param element represents number need to remove
     * @return true if successfully removed and false if the array doesn't contain such an element
     */
    public boolean remove(int element) {
        int index = 0;
        boolean isRemoved = false;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == element) {
                array[i] = 0;
                index = i;
                isRemoved = true;
                size--;
                break;
            }
        }
        if (isRemoved) {
            for (int i = index; i < array.length - 1; i++) {
                array[i] = array[i + 1];
            }
        }
        return isRemoved;
    }


    /**
     * Method for updating element by index
     *
     * @param element represents new value of the element with appropriate index
     * @param index   represents the position of the element which need to update
     * @return true if successfully updated and false if the array doesn't contain such an element
     */
    public boolean update(int element, int index) {
        if (index > size - 1) {
            return false;
        } else {
            array[index] = element;
        }
        return true;
    }

    /**
     * Method for retrieving an element by index. If the array doesn't contain an element at the position then throw NoSuchElementException
     *
     * @param index represents the position of the element which need to retrieve
     * @return an element at the position with appropriate index
     */
    public int getElement(int index) {
        if (index > size - 1) {
            throw new NoSuchElementException();
        }
        return array[index];
    }

    /**
     * Method for retrieving size of the array.
     *
     * @return size of the array
     */
    public int getSize() {
        return size;
    }


    /**
     * Method for creating new array if previous is full and copying all element from an old array to a new
     */
    private void resize() {
        int[] temp = new int[array.length * 2];
        System.arraycopy(array, 0, temp, 0, array.length);
        array = temp;
    }

}

