package com.rlinoz.modulo3_estrutura_de_dados.conjuntos

import java.util.*


fun main() {
    val set: Set<Int> = setOf(1, 2, 3, 4, 5 ,9, 8, 11, 7) // LinkedHashSet
    val set2 = HashSet<Int>()
    set2.add(1)
    set2.add(9)
    set2.add(8)
    set2.add(11)
    set2.add(38)
    set2.add(33)
    set2.add(5)

    val set3 = TreeSet<Int>()
    set3.add(5)
    set3.add(33)
    set3.add(31)
    set3.add(11)
    set3.add(38)
    set3.add(9)
    set3.add(0)

//    set.forEach { print("$it ") }
//    println()
//    set2.forEach { print("$it ") }
//    println()
    set3.forEach { print("$it ") }
    println()
    println()

    println(set3.lower(32))
    println(set3.higher(32))

    println(set3.subSet(11, true, 38, true))
    println(set3.headSet(33, true))
    println(set3.tailSet(33, true))
}