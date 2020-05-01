package zanagram

import kotlin.test.Test
import kotlin.test.assertEquals

class AppTest {
    @Test
    fun `single letter has just one permutation`() {
        val s = "a"

        val permutations: List<String> = permutations(s)

        assertEquals("a", permutations.get(0))
        assertEquals(1, permutations.size())
    }

    @Test
    fun `ab has two permutations`() {
        val s = "ab"

        val permutations: List<String> = permutations(s)

        assertEquals("ab", permutations.get(0))
        assertEquals("ba", permutations.get(1))
        assertEquals(2, permutations.size())
    }
}
