package zanagram

import org.junit.Test
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class SetTest {
    @Test
    fun `empty tree should not contain 1`() {
        val set = Set<Int>()

        assertFalse(set.contains(1))
    }

    @Test
    fun `after add(1) contains(1) returns true`() {
        val set = Set<Int>()

        set.add(1)

        assertTrue(set.contains(1))
    }

    @Test
    fun `contains after add always returns true`() {
        val set = Set<Int>()

        set.add(1)
        set.add(2)
        set.add(3)

        assertTrue(set.contains(1))
        assertTrue(set.contains(2))
        assertTrue(set.contains(3))
    }
}