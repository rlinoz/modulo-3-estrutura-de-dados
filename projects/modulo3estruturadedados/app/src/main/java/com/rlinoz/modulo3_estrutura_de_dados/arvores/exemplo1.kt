package com.rlinoz.modulo3_estrutura_de_dados.arvores

data class NodeArray<T>(val value: T)

class TreeArray<T : Comparable<T>> {
    private val container = arrayOfNulls<NodeArray<T>>(100)

    fun add(value: T, index: Int = 0) {
        val node = container[index]

        if (node == null) {
            container[index] = NodeArray(value)
        } else if (node.value >= value) {
            // ir para esquerda
            add(
                value,
                (2 * index) + 1
            )
        } else {
            // ir para direita
            add(
                value,
                (2 * index) + 2
            )
        }
    }

    override fun toString(): String {
        return container.contentToString()
    }
}

fun main() {
    val tree = TreeArray<Int>()
    tree.add(8)
    tree.add(5)
    tree.add(4)
    tree.add(7)
    tree.add(9)

    println(tree)
}