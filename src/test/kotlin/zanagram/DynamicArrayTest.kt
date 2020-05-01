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
}
