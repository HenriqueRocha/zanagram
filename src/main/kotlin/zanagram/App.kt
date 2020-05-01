package zanagram

import java.io.File
import kotlin.system.measureTimeMillis

fun permutations(s: String): List<String> {
    val result = DynamicArray<String>()
    permutations(s.toCharArray(), 0, s.length - 1, result)
    return result
}

fun permutations(s: CharArray, lowerBound: Int, upperBound: Int, result: List<String>) {
    if (lowerBound == upperBound) result.add(String(s))
    else {
        for (i in lowerBound..upperBound) {
            s.swap(lowerBound, i)
            permutations(s, lowerBound + 1, upperBound, result)
            s.swap(lowerBound, i)
        }
    }
}

fun CharArray.swap(i: Int, j: Int) {
    val t = this[i]
    this[i] = this[j]
    this[j] = t
}

fun main(args: Array<String>) {
    val dictionary: List<String> = DynamicArray()
    val timeToLoad = measureTimeMillis {
        File("words_alpha.txt").forEachLine { dictionary.add(it) }
    }
    println("Time to load: $timeToLoad")

    val word = "listen"
    val listOfPermutations = permutations(word)
    val timeToFindPermutations = measureTimeMillis {
        for (i in 0..listOfPermutations.size()) {
            val word = listOfPermutations[i]
            if (dictionary.contains(word)) {
                println(word)
            }
        }
    }

    println("Time to find permutations: $timeToFindPermutations")
}
