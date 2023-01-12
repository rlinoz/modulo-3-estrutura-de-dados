package com.rlinoz.modulo3_estrutura_de_dados.arvores

data class Node<T>(val value: T, var left: Node<T>? = null, var right: Node<T>? = null) {

    fun isLeaf(): Boolean {
        return left == null && right == null
    }

    fun removeLeaf(current: Node<T>) {
        if (current == left) left = null
        else if (current == right) right = null
    }

    fun hasSingleNode(): Boolean {
        return when {
            left == null && right != null -> true
            left != null && right == null -> true
            else -> false
        }
    }

    fun removeSingleChildNode(current: Node<T>) {
        if (left == current) {
            left = when {
                current.left != null -> current.left
                current.right != null -> current.right
                else -> null
            }
        } else if (right == current) {
            right = when {
                current.left != null -> current.left
                current.right != null -> current.right
                else -> null
            }
        }
    }
}

class Tree<T : Comparable<T>> {

    private var root: Node<T>? = null

    fun add(value: T) {

        if (root == null) {
            root = Node(value)
        } else {
            add(root!!, value)
        }
    }

    private fun add(node: Node<T>, value: T) {
        if (node.value >= value) {
            if (node.left == null) {
                println("add esquerda ${node.value}")
                node.left = Node(value)
            } else {
                println("esquerda")
                add(node.left!!, value)
            }
        } else {
            if (node.right == null) {
                println("add direita ${node.value}")
                node.right = Node(value)
            } else {
                println("direita")
                add(node.right!!, value)
            }
        }
    }

    fun search(value: T): Boolean {
        var node = root

        while (node != null) {
            when {
                node.value == value -> return true
                node.value > value -> node = node.left
                node.value < value -> node = node.right
            }
        }
        return false
    }

    fun remove(value: T) {
        if (root == null) return

        if (root!!.value > value) {
            remove(root!!, root?.left, value)
        } else if (root!!.value < value) {
            remove(root!!, root?.right, value)
        }
    }

    private fun remove(parent: Node<T>, current: Node<T>?, value: T) {
        if (current == null) return

        if (current.value == value) {
            when {
                current.isLeaf() -> { parent.removeLeaf(current) }
                current.hasSingleNode() -> {
                    parent.removeSingleChildNode(current)
                }
                // TODO remover nós com dois filhos
            }
        } else if (current.value > value) {
            remove(current, current.left, value)
        } else {
            remove(current, current.right, value)
        }
    }

    override fun toString(): String {
        return toString(root)
    }

    private fun toString(node: Node<T>?): String {
        if (node == null) return ""

        return node.value.toString() + " " + toString(node.left) + " " + toString(node.right)
    }
}

fun main() {
    val tree = Tree<Int>()
    tree.add(8)
    tree.add(5)
    tree.add(4)
    tree.add(7)
    tree.add(9)
    tree.add(10)

    println(tree.toString())

    println(tree.search(4)) // true
    println(tree.search(6)) // false
    println(tree.search(9))
    println(tree.search(8))
    println(tree.search(10))

    tree.remove(7)
    tree.remove(9)
    println(tree)
}