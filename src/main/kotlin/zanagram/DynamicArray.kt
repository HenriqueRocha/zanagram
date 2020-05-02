package zanagram

class DynamicArray<E> : List<E> {
    private var elements: Array<Any?> = emptyArray()
    private var size: Int = 0

    override fun add(e: E) {
        ensureCapacity(size + 1)
        elements[size++] = e as Any
    }

    private fun ensureCapacity(capacity: Int) {
        if (elements.size < capacity) {
            grow(capacity)
        }
    }

    private fun grow(capacity: Int) {
        val newElements: Array<Any?> = if (size == 0) {
            Array(2) { null }
        } else {
            Array((capacity * 1.5).toInt()) { null }
        }

        for (i in 0 until size) {
            newElements[i] = elements[i]
        }

        elements = newElements
    }

    override fun toString(): String {
        if (size == 0) return "[]"

        val result = StringBuilder()
        result.append("[")
        for (i in 0 until size - 1) {
            result.append(elements[i])
            result.append(",")
        }
        result.append(elements[size - 1])
        result.append("]")
        return result.toString()
    }

    override fun size(): Int = size

    override fun contains(e: E): Boolean {
        for (i in elements) {
            if (i == e) return true
        }
        return false
    }

    override fun get(index: Int): E {
        return elements[index] as E
    }

    override fun set(index: Int, element: E) {
        elements[index] = element
    }
}
