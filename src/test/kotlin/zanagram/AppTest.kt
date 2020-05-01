package zanagram

import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertNotNull

class AppTest {
    @Test
    fun `add makes list not empty`() {
        var list: Node<Int>? = null

        list = add(1, list)

        assertNotNull(list, "list should not be empty")
        assertEquals(1, list.data)
    }

    @Test
    fun `add twice makes size equal 2`() {
        var list: Node<Int>? = null
        list = add(1, list)
        list = add(2, list)

        val size = size(list)

        assertEquals(2, size)
    }

    @Test
    fun `add adds to the end`() {
        var list: Node<Int>? = null

        list = add(1, list)
        list = add(2, list)

        val first = list!!.data
        val second = list.next!!.data

        assertEquals(1, first)
        assertEquals(2, second)
    }

    @Test
    fun `size of empty list is zero`() {
        var list: Node<Int>? = null

        assertEquals(0, size(list))
    }

    @Test
    fun `add 1 should make size equal 1`() {
        var list: Node<Int>? = null

        list = add(1, list)

        assertEquals(1, size(list))
    }
}
