package zanagram

class SinglyLinkedList<E> : List<E> {
    inner class Node<E>(val data: E, var next: Node<E>? = null)

    private var node: Node<E>? = null
    private var size = 0

    override fun add(e: E) {
        if (node == null) {
            node = Node(e)
        } else {
            var p = node
            while (p!!.next != null) {
                p = p.next
            }
            p.next = Node(e)
        }
        size++
    }

    override fun toString(): String {
        if (size == 0) return "[]"

        val result = StringBuilder()
        var p = node
        result.append("[")
        while (p!!.next != null) {
            result.append(p.data)
            result.append(",")
            p = p.next
        }
        result.append(p.data)
        result.append("]")
        return result.toString()
    }

    override fun size(): Int = size

    override fun contains(e: E): Boolean {
        var p = node
        while (p != null) {
            if (p.data == e) return true
            p = p.next
        }

        return false
    }

    fun addFirst(e: E) {
        node = Node(e, node)
        size++
    }

    override fun get(index: Int): E {
        var p = node
        for (i in 0 until index) {
            p = p!!.next
        }
        return p!!.data
    }
}
