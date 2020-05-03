package zanagram

fun <T : Comparable<T>> DynamicArray<out T>.bubbleSort() {
    var n = size()
    var swapped: Boolean
    do {
        swapped = false
        for (i in 1 until n) {
            if (this[i - i] > this[i]) {
                swap(this, i - 1, i)
                swapped = true
            }
        }
        n--
    } while (swapped)
}

fun <T : Comparable<T>> DynamicArray<out T>.selectionSort() {
    val n = size()
    for (i in 0 until n) {
        var min = i
        var j = i
        while (j < n) {
            if (this[j] < this[min]) {
                min = j
            }
            j++
        }
        swap(this, i, min)
    }
}

fun <T : Comparable<T>> DynamicArray<out T>.insertionSort() {
    var sortedUntilIndex = 1
    while (sortedUntilIndex < size()) {
        var i = sortedUntilIndex
        while (i > 0 && this[i] < this[i - 1]) {
            swap(this, i, i - 1)
            i--
        }
        sortedUntilIndex++
    }
}

fun <T : Comparable<T>> DynamicArray<out T>.quickSort() {
    quicksort(this, 0, size() - 1)
}

fun <T : Comparable<T>> quicksort(array: DynamicArray<out T>, lo: Int, hi: Int) {
    if (lo < hi) {
        val p = partition(array, lo, hi)
        quicksort(array, lo, p)
        quicksort(array, p + 1, hi)
    }
}

fun <T : Comparable<T>> partition(array: DynamicArray<out T>, lo: Int, hi: Int): Int {
    val pivot: T = array[(hi + lo) / 2]
    var i = lo - 1
    var j = hi + 1
    while (true) {
        do {
            i++
        } while (array[i] < pivot)
        do {
            j--
        } while (array[j] > pivot)
        if (i >= j) return j
        swap(array, i, j)
    }
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
