package com.rlinoz.aula1_demo.filas

import android.os.Build
import androidx.annotation.RequiresApi
import java.util.*

/*
* Definir classe de pessoa (nome e idade)
* Criar a estrutura de banco (fila, novas pessoas entram no banco, atende)
* Caso a pessoa tenha mais de 60 anos ela te prioridade na fila
* */

data class Person(val name: String, val age: Int)

data class Node(val person: Person, val timestamp: Long) // Node com timestamp permite que matenhamos a ordem de chegada

@RequiresApi(Build.VERSION_CODES.N)
class Bank {
    private val queue: PriorityQueue<Node> = PriorityQueue<Node> { o1, o2 ->
        if (o1.person.age > 60 && o2.person.age > 60) {
            if (o1.timestamp > o2.timestamp) -1 // se chegou antes tem maior prioridade caso as duas pessoas tenham mais de 60 anos
            else 1
        } else if (o1.person.age > 60) { // caso só uma das pessoas tenha mais de 60 anos ela tem prioridade
            -1
        } else {
            if (o1.timestamp > o2.timestamp) -1 // caso nenhuma das duas tenha mais de 60 anos tem mais prioridade quem chegou primeiro
            else 1
        }
    }

    fun add(person: Person) {
        queue.offer(Node(person, System.currentTimeMillis()))
    }

    fun execute() {
        var current = queue.poll()
        while(current != null) {
            println(current)
            current = queue.poll()
        }
    }
}

@RequiresApi(Build.VERSION_CODES.N)
fun main() {
    val bank = Bank()
    bank.add(Person(name = "Clarice", 15))
    bank.add(Person(name = "Paulo", 68))
    bank.add(Person(name = "Joao", 45))
    bank.add(Person(name = "Rafael", 70))
    bank.add(Person(name = "Jonas", 52))
    bank.add(Person(name = "Larissa", 48))
    bank.add(Person(name = "Rafaela", 89))
    bank.add(Person(name = "Pedro", 90))

    bank.execute()
}

