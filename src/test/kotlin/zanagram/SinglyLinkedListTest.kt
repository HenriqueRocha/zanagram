package zanagram

import org.junit.Before
import org.junit.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class SinglyLinkedListTest {
    private lateinit var container: SinglyLinkedList<Int>

    @Before
    fun setUp() {
        container = SinglyLinkedList()
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
    fun `addFirst increases size of list`() {
        container.apply {
            addFirst(1)
            addFirst(2)
            addFirst(3)
        }

        assertEquals(3, container.size())
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
}