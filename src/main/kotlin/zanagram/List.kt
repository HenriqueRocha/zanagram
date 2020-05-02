package zanagram

/**
 * A generic ordered collection of elements that supports adding and removing elements.
 */
interface List<E> {

    /**
     * Adds the specified element to the end of this list.
     * @param e element to be appended to this list
     */
    fun add(e: E)

    /**
     * Returns the size of this list.
     */
    fun size(): Int

    fun contains(e: E): Boolean

    /**
     * Returns the element at the specified index in the list.
     */
    operator fun get(index: Int): E

    /**
     * Replaces the element at the specified position in this list with the specified element.
     */
    operator fun set(index: Int, element: E)
}
