package com.rlinoz.modulo3_estrutura_de_dados.arvores

import java.util.*

fun main() {
    val treeMap: MutableMap<Int, String> = TreeMap<Int, String>()
    val treeSet = TreeSet<Int>()

    treeMap.put(1, "asdf")
    treeMap.containsKey(1)

    println(treeMap)
}