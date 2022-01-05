import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class DynamicArrayTest {
    private DynamicIntArray dynamicIntArray;
    private static final int[] TEST_ARRAY = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19};
    private static final int[] TEST_ARRAY_2 = {10, 11, 12, 13, 14, 15, 16, 17, 18, 19};

    @Before
    public void cleanUp() {
        dynamicIntArray = new DynamicIntArray();
    }

    @Test
    public void addAndGetElementTest() {
        for (int i : TEST_ARRAY) {
            dynamicIntArray.add(i);
        }

        for (int i = 0; i < TEST_ARRAY.length; i++) {
            assertEquals(TEST_ARRAY[i], dynamicIntArray.getElement(i));
        }
    }

    @Test
    public void removeElementTest() {
        for (int i : TEST_ARRAY) {
            dynamicIntArray.add(i);
        }

        for (int i = 0; i < 10; i++) {
            dynamicIntArray.remove(i);
        }

        for (int i = 0; i < TEST_ARRAY_2.length; i++) {
            assertEquals(TEST_ARRAY_2[i], dynamicIntArray.getElement(i));
        }
    }

    @Test
    public void getSizeTest() {
        for (int i : TEST_ARRAY) {
            dynamicIntArray.add(i);
        }

        assertEquals(TEST_ARRAY.length, dynamicIntArray.getSize());

        for (int i = 0; i < 10; i++) {
            dynamicIntArray.remove(i);
        }

        assertEquals(TEST_ARRAY.length -10 , dynamicIntArray.getSize());
    }

    @Test
    public void updateTest() {
        for (int i : TEST_ARRAY) {
            dynamicIntArray.add(i);
        }

        boolean resultTrue = dynamicIntArray.update(100, 5);
        boolean resultFalse = dynamicIntArray.update(100, 100);

        assertEquals(dynamicIntArray.getElement(5), 100);
        assertEquals(dynamicIntArray.getSize(), TEST_ARRAY.length);
        assertTrue(resultTrue);
        assertFalse(resultFalse);
    }
}
