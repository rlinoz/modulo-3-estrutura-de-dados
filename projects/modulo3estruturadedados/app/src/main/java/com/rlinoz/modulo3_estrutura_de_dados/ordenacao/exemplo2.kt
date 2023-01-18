package com.rlinoz.modulo3_estrutura_de_dados.ordenacao


// HeapSort
/*
Heap é uma árvore binária, completa
Heap pode ser de máximo ou de mínimo
 */
fun printArray(list: IntArray) {
    list.forEach { print("$it ") }
    println()
}

fun main() {
    val list = intArrayOf(1, 5, 3, 4, 2)
    heapSort(list)
}

/**
 * Complexidade garantida de tempo O (n * log n)
 * Complexidade espacial de O(1)
 */
fun heapSort(list: IntArray) {
    makeIntoHeap(list)
    printArray(list)

    for (i in list.lastIndex downTo 0) {
        printArray(list)
        val highestValue = list[0]
        list[0] = list[i]
        list[i] = highestValue
        heapify(list, 0, i - 1)
    }

    printArray(list)
}

fun makeIntoHeap(list: IntArray) {
    val lastNodeWithLeaf = (list.size / 2) - 1
    for (i in lastNodeWithLeaf downTo 0) {
        heapify(list, i, list.lastIndex)
    }
}

fun heapify(list: IntArray, rootIndex: Int, heapSize: Int) {
    val leftIndex = (rootIndex * 2) + 1
    val rightIndex = (rootIndex * 2) + 2

    var highestValueIndex = rootIndex

    if (heapSize >= leftIndex && list[leftIndex] > list[highestValueIndex]) {
        highestValueIndex = leftIndex
    }

    if (heapSize >= rightIndex && list[rightIndex] > list[highestValueIndex]) {
        highestValueIndex = rightIndex
    }

    if (highestValueIndex != rootIndex) {
        val tmp = list[rootIndex]
        list[rootIndex] = list[highestValueIndex]
        list[highestValueIndex] = tmp
        heapify(list, highestValueIndex, heapSize)
    }
}