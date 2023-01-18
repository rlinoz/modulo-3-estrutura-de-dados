package com.rlinoz.modulo3_estrutura_de_dados.ordenacao

fun main() {
    val list = mutableListOf(1, 5, 3, 4, 2)
    // bubblesort
    /**
     * 1 5 3 4 2
     * 1 3 5 4 2 (troca 3 com 5)
     * 1 3 4 5 2 (troca 4 com 5)
     * 1 3 4 2 5 (troca 2 com 5)
     * 1 3 2 4 5 (troca 2 com 4)
     * 1 2 3 4 5 (troca 2 com 3)
     */
    for (i in 0 until list.lastIndex) {
        for (j in 0 until list.lastIndex) {
            if (list[j] > list[j + 1]) {
                // swap entre j e j+1
                val tmp = list[j]
                list[j] = list[j + 1]
                list[j + 1] = tmp
            }
            println(list)
        }
    }
}