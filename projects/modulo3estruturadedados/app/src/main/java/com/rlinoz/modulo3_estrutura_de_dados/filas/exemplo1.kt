package com.rlinoz.modulo3_estrutura_de_dados.filas

import java.util.*

class QueueManager<T> {
    private val queue: ArrayList<T> = ArrayList<T>()

    fun pop(): T? {
        if (queue.isEmpty())
            return null

        return queue.removeAt(0)
    }

    fun peek(): T? {
        if (queue.isEmpty())
            return null

        return queue[0]
    }

    fun push(value: T) {
        queue.add(value)

        println(queue)
    }

}


fun main() {
    val queue: Queue<String> = LinkedList()
    queue.poll()
    queue.offer("pessoa 1")
    println(queue)
    queue.offer("pessoa 2")
    println(queue)

    val person = queue.poll()
    println(person)
    println(queue)
    queue.offer("pessoa 3")
    println(queue)
}