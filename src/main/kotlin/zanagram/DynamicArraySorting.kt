package zanagram

fun <T : Comparable<T>> DynamicArray<out T>.bubbleSort() {
    val size = size()
    var swapped: Boolean
    do {
        swapped = false
        for (i in 0 until size - 1) {
            if (this[i] > this[i + 1]) {
                swap(this, i, i + 1)
                swapped = true
            }
        }
    } while (swapped)
}

internal fun <T> swap(array: DynamicArray<T>, i: Int, j: Int) {
    val t = array[i]
    array[i] = array[j]
    array[j] = t
}

fun <T : Comparable<T>> DynamicArray<out T>.binarySearch(e: T): Int {
    var min = 0
    var max = size() - 1
    while (min <= max) {
        var mid = (min + max) / 2
        if (e < this[mid]) max = mid - 1
        else if (e > this[mid]) min = mid + 1
        else return mid
    }
    return -1
}
