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

fun <T> contains(e: T, list: Node<T>?): Boolean {
    var p = list
    while (p != null) {
        if (p.data == e) return true
        p = p.next
    }
    return false
}

fun permutations(s: String): Node<String>? {
    permutations(s.toCharArray(), 0, s.length - 1)
    return permutations
}

var permutations: Node<String>? = null

fun permutations(s: CharArray, lowerBound: Int, upperBound: Int) {
    if (lowerBound == upperBound) permutations = Node(String(s), permutations)
    else {
        for (i in lowerBound..upperBound) {
            s.swap(lowerBound, i)
            permutations(s, lowerBound + 1, upperBound)
            s.swap(lowerBound, i)
        }
    }
}

fun CharArray.swap(i: Int, j: Int) {
    val t = this[i]
    this[i] = this[j]
    this[j] = t
}

fun printPermutations(s: String) {
    printPermutations(s.toCharArray(), 0, s.length - 1)
}

fun printPermutations(s: CharArray, lowerBound: Int, upperBound: Int) {
    if (lowerBound == upperBound) println(String(s))
    else {
        for (i in lowerBound..upperBound) {
            s.swap(lowerBound, i)
            printPermutations(s, lowerBound + 1, upperBound)
            s.swap(lowerBound, i)
        }
    }
}

fun main(args: Array<String>) {
    var dictionary: Node<String>? = null
    val timeToLoad = measureTimeMillis {
        File("words_alpha.txt").forEachLine { dictionary = add(it, dictionary) }
    }
    var size = 0
    val timeToSize = measureTimeMillis { size = size(dictionary) }

    println("Time to load: $timeToLoad")
    println("Time to size: $timeToSize")

    val word = "listen"
    val listOfPermutations = permutations(word)
    val timeToFindPermutations = measureTimeMillis {
        var p = listOfPermutations
        while (p != null) {
            if (contains(p.data, dictionary)) {
                println(p.data)
            }
            p = p.next
        }
    }

    println("Time to find permutations: $timeToFindPermutations")
}
