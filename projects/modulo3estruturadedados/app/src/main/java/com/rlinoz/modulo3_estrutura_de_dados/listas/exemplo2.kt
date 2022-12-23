package com.rlinoz.aula1_demo.listas

import java.util.LinkedList

data class Node<T>(
    var value: T,
    var next: Node<T>?
)

data class LinkedList2<T>(
    var head: Node<T>? = null
) {
    fun add(value: T) {
        val newNode = Node(value = value, null)

        if (head == null) {
            head = newNode
            return
        } else {
            var current = head
            while (current?.next != null) {
                current = current.next
            }
            current?.next = newNode
        }
    }

    fun remove(value: T): Boolean {
        if (head?.value == value) {
            head = head?.next
            return true
        }
        var current = head?.next
        var previous = head

        while(current != null && current.value != value) {
            previous = current
            current = current.next
        }

        if (current != null) {
            previous?.next = current.next
            return true
        }

        return false
    }

    fun show() {
        var current = head
        if (current == null) {
            println("Lista vazia")
            return
        }

        while(current != null) {
            println(current.value)
            current = current.next
        }
    }

    fun isEmpty(): Boolean {
        return head == null
    }
}

fun main() {
    val list = LinkedList2<String>()

    println(list.isEmpty())

    list.add("primeiro valor")
    list.add("segundo valor")
    list.add("terceiro valor")

    println("nao removeu " + list.remove("nao existe"))
    println(list.remove("segundo valor"))
    list.remove("primeiro valor")

    list.show()

    val list3 = ArrayList<String>()
    val list2: List<String> = LinkedList<String>()//listOf("123")
}
