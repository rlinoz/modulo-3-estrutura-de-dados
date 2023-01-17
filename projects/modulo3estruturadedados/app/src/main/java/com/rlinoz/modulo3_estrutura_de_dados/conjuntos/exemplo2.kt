package com.rlinoz.modulo3_estrutura_de_dados.conjuntos

import java.util.*

fun main() {
    val set: Set<Int> = setOf(1, 2, 3, 4, 5 ,9, 8, 11, 7)
    val set2 = HashSet<Int>()
    set2.add(1)
    set2.add(9)
    set2.add(8)
    set2.add(11)
    set2.add(38)
    set2.add(33)
    set2.add(5)

    set.forEach { print("$it ") }
    println()
    set2.forEach { print("$it ") }
}