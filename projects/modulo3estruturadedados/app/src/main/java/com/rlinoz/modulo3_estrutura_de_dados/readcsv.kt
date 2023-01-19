package com.rlinoz.modulo3_estrutura_de_dados

import java.io.File

fun readCsv(fileName: String): List<List<String>> {
    val reader = File(fileName).bufferedReader()
//    val header = reader.readLine() // caso queira evitar o header descomentar
    return reader.lineSequence()
        .filter { it.isNotBlank() }
        .map {
            it.split(',', ignoreCase = false)
        }.toList()
}

fun main() {
    println(readCsv("operacoes.csv"))
}
