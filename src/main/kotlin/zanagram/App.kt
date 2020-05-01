package zanagram

import java.io.File

class Node<T>(val data: T, val next: Node<T>?)

fun <T> add(data: T, node: Node<T>?): Node<T> =
    if (node == null) Node(data, null)
    else Node(node.data, add(data, node.next))

fun <T> size(node: Node<T>?): Int =
    if (node == null) 0 else 1 + size(node.next)

fun main(args: Array<String>) {
    var list: Node<String>? = null
    File("words_alpha.txt").forEachLine { list = add(it, list) }
    println("Number of words: ${size(list)}")
}
