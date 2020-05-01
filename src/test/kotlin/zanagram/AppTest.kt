package zanagram

import kotlin.test.*

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
    fun `add adds to the beginning`() {
        var list: Node<Int>? = null

        list = add(1, list)
        list = add(2, list)

        val first = list!!.data
        val second = list.next!!.data

        assertEquals(2, first)
        assertEquals(1, second)
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

    @Test
    fun `contains on empty list returns false`() {
        var list: Node<Int>? = null

        assertFalse(contains(1, list))
    }

    @Test
    fun `list with 1 contains 1`() {
        var list: Node<Int>? = null
        list = add(1, list)

        assertTrue(contains(1, list))
    }

    @Test
    fun `list with 1 does not contain 2`() {
        var list: Node<Int>? = null
        list = add(1, list)

        assertFalse(contains(2, list))
    }

    @Test
    fun `single letter has just one permutation`() {
        val s = "a"
        permutations = null
        val permutations: Node<String>? = permutations(s)

        assertEquals("a", permutations!!.data)
        assertEquals(1, size(permutations))
    }

    @Test
    fun `ab has two permutations`() {
        val s = "ab"
        permutations = null
        val permutations: Node<String>? = permutations(s)

        assertEquals("ba", permutations!!.data)
        assertEquals("ab", permutations.next!!.data)
        assertEquals(2, size(permutations))
    }

}
