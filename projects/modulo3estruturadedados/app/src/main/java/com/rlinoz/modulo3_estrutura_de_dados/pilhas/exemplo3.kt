package com.rlinoz.modulo3_estrutura_de_dados.pilhas

fun recursion() {
    println("recursao")
    recursion()
}

fun main() {
// StackOverflowException
    recursion()
}