package test.rice;

import main.rice.LinkedList;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Test cases for the LinkedList class.
 */
public class LinkedListTest {

    /**
     * Appends several elements to a list and then checks that they can be accessed at the
     * expected indices; also checks that the size gets incremented appropriately.
     */
    @Test
    void testAppendGet() {
        // Create a list and append several elements
        LinkedList<Integer> list = new LinkedList<>();
        list.append(5);
        list.append(-8);
        list.append(17);
        list.append(4);

        // Check that the elements got added in the right order
        assertEquals(5, list.get(0));
        assertEquals(-8, list.get(1));
        assertEquals(17, list.get(2));
        assertEquals(4, list.get(3));

        // Check that the size got updated properly
        assertEquals(4, list.size());
    }

    /**
     * Prepends several elements to a list and then checks that they can be accessed at
     * the expected indices; also checks that the size gets incremented appropriately.
     */
    @Test
    void testPrependGet() {
        // Create a list and prepend several elements
        LinkedList<Integer> list = new LinkedList<>();
        list.prepend(5);
        list.prepend(-8);
        list.prepend(17);
        list.prepend(4);

        // Check that the elements got added in the right order
        assertEquals(4, list.get(0));
        assertEquals(17, list.get(1));
        assertEquals(-8, list.get(2));
        assertEquals(5, list.get(3));

        // Check that the size got updated properly
        assertEquals(4, list.size());
    }

    /**
     * Checks that calling get() with an invalid index throws an
     * IndexOutOfBoundsException.
     */
    @Test
    void testGetInvalidIndexNegative() {
        // Create a list and append several elements
        LinkedList<Integer> list = new LinkedList<>();
        list.append(5);
        list.append(-8);

        // Try to get at an invalid index, and check for an IndexOutOfBounds exception
        try {
            list.get(-1);
        } catch (IndexOutOfBoundsException e) {
            return;
        }
        fail();
    }

    /**
     * Checks that calling get() with an invalid index throws an
     * IndexOutOfBoundsException.
     */
    @Test
    void testGetInvalidIndexTooLarge() {
        // Create a list and append several elements
        LinkedList<Integer> list = new LinkedList<>();
        list.append(5);
        list.append(-8);

        // Try to get at an invalid indiex, and check for an IndexOutOfBounds exception
        try {
            list.get(2);
        } catch (IndexOutOfBoundsException e) {
            return;
        }
        fail();
    }

    /**
     * Inserts several elements at the beginning of a list and then checks that they can
     * be accessed at the expected indices; also checks that the size gets incremented
     * appropriately.
     */
    @Test
    void testInsertBeginning() {
        // Create a list and insert several elements at the beginning
        LinkedList<Integer> list = new LinkedList<>();
        list.insert(0, 5);
        list.insert(0, -8);
        list.insert(0, 17);
        list.insert(0, 4);

        // Check that the elements got added in the right order
        assertEquals(4, list.get(0));
        assertEquals(17, list.get(1));
        assertEquals(-8, list.get(2));
        assertEquals(5, list.get(3));

        // Check that the size got updated properly
        assertEquals(4, list.size());
    }

    /**
     * Inserts several elements at the end of a list and then checks that they can be
     * accessed at the expected indices; also checks that the size gets incremented
     * appropriately.
     */
    @Test
    void testInsertEnd() {
        // Create a list and insert several elements at the beginning
        LinkedList<Integer> list = new LinkedList<>();
        list.insert(0, 5);
        list.insert(1, -8);
        list.insert(2, 17);
        list.insert(3, 4);

        // Check that the elements got added in the right order
        assertEquals(5, list.get(0));
        assertEquals(-8, list.get(1));
        assertEquals(17, list.get(2));
        assertEquals(4, list.get(3));

        // Check that the size got updated properly
        assertEquals(4, list.size());
    }

    /**
     * Inserts several elements in the middle of a list and then checks that they can be
     * accessed at the expected indices; also checks that the size gets incremented
     * appropriately.
     */
    @Test
    void testInsertMiddle() {
        // Create a list and insert several elements at various positions
        LinkedList<Integer> list = new LinkedList<>();
        list.append(5);
        list.append(-8);
        list.append(17);
        list.append(4);
        list.insert(3, 3);
        list.insert(1, 100);
        list.insert(3, -12);

        // Check that the elements got added in the right order
        assertEquals(5, list.get(0));
        assertEquals(100, list.get(1));
        assertEquals(-8, list.get(2));
        assertEquals(-12, list.get(3));
        assertEquals(17, list.get(4));
        assertEquals(3, list.get(5));
        assertEquals(4, list.get(6));

        // Check that the size got updated properly
        assertEquals(7, list.size());
    }

    /**
     * Checks that calling insert() with an invalid index neither causes an error nor
     * affects the size of the list.
     */
    @Test
    void testInsertInvalidIndexNegative() {
        // Create a list and append several elements
        LinkedList<Integer> list = new LinkedList<>();
        list.append(5);
        list.append(-8);

        // Try to insert at an invalid index, and check for an IndexOutOfBounds exception
        try {
            list.insert(-1, 17);
        } catch (IndexOutOfBoundsException e) {
            // Make sure the invalid insert didn't affect the list's size
            assertEquals(2, list.size());
            return;
        }
        fail();
    }

    /**
     * Checks that calling insert() with an invalid index neither causes an error nor
     * affects the size of the list.
     */
    @Test
    void testInsertInvalidIndexTooLarge() {
        // Create a list and append several elements
        LinkedList<Integer> list = new LinkedList<>();
        list.append(5);
        list.append(-8);

        // Try to insert at an invalid index, and check for an IndexOutOfBounds exception
        try {
            list.insert(3, 4);
        } catch (IndexOutOfBoundsException e) {
            // Make sure the invalid insert didn't affect the list's size
            assertEquals(2, list.size());
            return;
        }
        fail();
    }

    /**
     * Appends several elements to a list and then checks that they can be removed at the
     * expected indices; also checks that the size gets decremented appropriately.
     */
    @Test
    void testAppendRemove() {
        // Create a list and append several elements
        LinkedList<Integer> list = new LinkedList<>();
        list.append(5);
        list.append(-8);
        list.append(17);
        list.append(4);

        // Remove the elements one at a time
        assertEquals(-8, list.remove(1));
        assertEquals(4, list.remove(2));
        assertEquals(5, list.remove(0));
        assertEquals(17, list.remove(0));

        // Check that the size got updated properly
        assertEquals(0, list.size());
    }

    /**
     * Checks that calling remove() with an invalid index neither causes an error nor
     * affects the size of the list.
     */
    @Test
    void testRemoveInvalidIndexNegative() {
        // Create a list and append several elements
        LinkedList<Integer> list = new LinkedList<>();
        list.append(5);
        list.append(-8);

        // Try to remove at an invalid index, and check for an IndexOutOfBounds exception
        try {
            list.remove(-1);
        } catch (IndexOutOfBoundsException e) {
            // Make sure the invalid remove didn't affect the list's size
            assertEquals(2, list.size());
            return;
        }
        fail();
    }

    /**
     * Checks that calling remove() with an invalid index neither causes an error nor
     * affects the size of the list.
     */
    @Test
    void testRemoveInvalidIndexTooLarge() {
        // Create a list and append several elements
        LinkedList<Integer> list = new LinkedList<>();
        list.append(5);
        list.append(-8);

        // Try to remove at an invalid index, and check for an IndexOutOfBounds exception
        try {
            list.remove(2);
        } catch (IndexOutOfBoundsException e) {
            // Make sure the invalid remove didn't affect the list's size
            assertEquals(2, list.size());
            return;
        }
        fail();
    }

    /**
     * Tests that contains() returns true when the requested element is in the list.
     */
    @Test
    void testContainsTrue() {
        // Create a list and append several elements
        LinkedList<Integer> list = new LinkedList<>();
        list.append(5);
        list.append(-8);
        list.append(17);
        list.append(4);

        // Check that the size got updated properly
        assertTrue(list.contains(-8));
    }

    /**
     * Tests that contains() returns false when the requested element is not in the list.
     */
    @Test
    void testContainsFalse() {
        // Create a list and append several elements
        LinkedList<Integer> list = new LinkedList<>();
        list.append(5);
        list.append(-8);
        list.append(17);
        list.append(4);

        // Check that the size got updated properly
        assertFalse(list.contains(30));
    }

    /**
     * Tests that count() returns the correct count when the requested element occurs in
     * the list multiple times.
     */
    @Test
    void testCountMultiple() {
        // Create a list and append several elements
        LinkedList<Integer> list = new LinkedList<>();
        list.append(5);
        list.append(-8);
        list.append(-8);
        list.append(4);
        list.append(-8);

        // Count the instances of an element that isn't there
        assertEquals(3, list.count(-8));
    }

    /**
     * Tests that count() returns the zero when the requested element is not in the list.
     */
    @Test
    void testCountZero() {
        // Create a list and append several elements
        LinkedList<Integer> list = new LinkedList<>();
        list.append(5);
        list.append(-8);
        list.append(17);
        list.append(4);

        // Count the instances of an element that isn't there
        assertEquals(0, list.count(30));
    }
}
