package zanagram

/**
 * A generic unordered collection of elements that does not support duplicate elements.
 */
class Set<E : Comparable<E>> {

    private var root: TreeNode<E>? = null

    /**
     * Checks if the specified element is contained in this set.
     */
    fun contains(element: E): Boolean = contains(element, root)

    private fun contains(element: E, treeNode: TreeNode<E>?): Boolean {
        when {
            treeNode == null -> return false
            element == treeNode.data -> return true
            element < treeNode.data -> return contains(element, treeNode.left)
            element > treeNode.data -> return contains(element, treeNode.right)
            else -> return false // can't happen
        }
    }

    /**
     * Adds the specified element to the set.
     */
    fun add(element: E) {
        root = add(element, root)
    }

    private fun add(element: E, treeNode: TreeNode<E>?): TreeNode<E> {
        when {
            treeNode == null -> return TreeNode(element)
            element < treeNode.data -> treeNode.left = add(element, treeNode.left)
            element > treeNode.data -> treeNode.right = add(element, treeNode.right)
        }
        return treeNode as TreeNode<E>
    }

    private class TreeNode<E>(
        val data: E,
        var left: TreeNode<E>? = null,
        var right: TreeNode<E>? = null
    )
}
