package zanagram

import java.io.File
import kotlin.system.measureTimeMillis

class Node<T>(val data: T, val next: Node<T>?)

fun <T> add(data: T, node: Node<T>?): Node<T>? =
    add(data, node, null)

tailrec fun <T> add(
    data: T, node: Node<T>?, acc: Node<T>?
): Node<T>? =
    if (node == null) reverse(Node(data, acc))
    else add(data, node.next, Node(node.data, acc))

fun <T> reverse(node: Node<T>?): Node<T>? =
    reverse(node, null)

tailrec fun <T> reverse(
    node: Node<T>?, acc: Node<T>?
): Node<T>? =
    if (node == null) acc
    else reverse(node.next, Node(node.data, acc))

fun <T> size(node: Node<T>?): Int = size(node, 0)

tailrec fun <T> size(node: Node<T>?, acc: Int): Int =
    if (node == null) acc else size(node.next, 1 + acc)

fun main(args: Array<String>) {
    var list: Node<String>? = null
    val timeToLoad = measureTimeMillis {
        File("words_alpha.txt").forEachLine { list = add(it, list) }
    }
    var size = 0
    val timeToSize = measureTimeMillis { size = size(list) }

    println("Time to load: $timeToLoad")
    println("Time to size: $timeToSize")
    println("Number of words: $size")
}
