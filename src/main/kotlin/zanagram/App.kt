package zanagram

import java.io.File
import kotlin.system.measureTimeMillis

class Node<T>(val data: T, var next: Node<T>?)

fun <T> add(data: T, node: Node<T>?): Node<T> = Node(data, node)

fun <T> size(node: Node<T>?): Int {
    if (node == null) return 0
    var size = 0
    var n = node
    while (n != null) {
        size++
        n = n.next
    }
    return size
}

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
