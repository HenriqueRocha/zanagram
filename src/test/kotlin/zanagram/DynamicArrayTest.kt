package zanagram

import org.junit.Before
import org.junit.Test
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class DynamicArrayTest {

    private lateinit var container: DynamicArray<Int>

    @Before
    fun setUp() {
        container = DynamicArray()
    }

    @Test
    fun `add to empty works`() {
        container.add(1)

        assertEquals("[1]", container.toString())
    }

    @Test
    fun `append three elements works`() {
        container.add(1)
        container.add(2)
        container.add(3)

        assertEquals("[1,2,3]", container.toString())
    }

    @Test
    fun `empty list should not contain 1`() {
        assertFalse(container.contains(1))
    }

    @Test
    fun `list with 1 2 3 should contain 3`() {
        container.apply {
            add(1)
            add(2)
            add(3)
        }

        assertTrue(container.contains(3))
    }

    @Test
    fun `get should return correct element`() {
        container.apply {
            add(1)
            add(2)
            add(3)
        }

        assertTrue(container[0] == 1)
        assertTrue(container[1] == 2)
        assertTrue(container[2] == 3)
    }

    @Test
    fun `set should set correct element`() {
        container.apply {
            add(1)
            add(2)
            add(3)
        }

        container[0] = 4
        container[1] = 5
        container[2] = 6

        assertTrue(container[0] == 4)
        assertTrue(container[1] == 5)
        assertTrue(container[2] == 6)
    }

    @Test
    fun `5 4 3 2 1 bubblesort should be 1 2 3 4 5`() {
        container.apply {
            add(5)
            add(4)
            add(3)
            add(2)
            add(1)
        }

        container.bubbleSort()

        assertEquals("[1,2,3,4,5]", container.toString())
    }

    @Test
    fun `5 4 3 2 1 selectionsort should be 1 2 3 4 5`() {
        container.apply {
            add(5)
            add(4)
            add(3)
            add(2)
            add(1)
        }

        container.selectionSort()

        assertEquals("[1,2,3,4,5]", container.toString())
    }

    @Test
    fun `5 4 3 2 1 insertionsort should be 1 2 3 4 5`() {
        container.apply {
            add(5)
            add(4)
            add(3)
            add(2)
            add(1)
        }

        container.insertionSort()

        assertEquals("[1,2,3,4,5]", container.toString())
    }

    @Test
    fun `5 4 3 2 1 quicksort should be 1 2 3 4 5`() {
        container.apply {
            add(5)
            add(4)
            add(3)
            add(2)
            add(1)
        }

        container.quickSort()

        assertEquals("[1,2,3,4,5]", container.toString())
    }

    @Test
    fun `binarySearch on empty array should return -1`() {
        assertEquals(-1, container.binarySearch(5))
    }

    @Test
    fun `binarySearch on array with one element should find it`() {
        container.add(5)

        assertEquals(0, container.binarySearch(5))
    }

    @Test
    fun `binarySearch on two values should find them`() {
        container.add(1)
        container.add(2)

        assertEquals(0, container.binarySearch(1))
        assertEquals(1, container.binarySearch(2))
    }

    @Test
    fun `binarySearch on odd number of values should find them`() {
        container.add(1)
        container.add(2)
        container.add(3)

        assertEquals(0, container.binarySearch(1))
        assertEquals(1, container.binarySearch(2))
        assertEquals(2, container.binarySearch(3))
    }

    @Test
    fun `binarySearch on even values should find them`() {
        container.add(1)
        container.add(2)
        container.add(3)
        container.add(4)

        assertEquals(0, container.binarySearch(1))
        assertEquals(1, container.binarySearch(2))
        assertEquals(2, container.binarySearch(3))
        assertEquals(3, container.binarySearch(4))
    }
}
