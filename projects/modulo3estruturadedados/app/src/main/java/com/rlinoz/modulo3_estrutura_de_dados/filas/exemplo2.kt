package com.rlinoz.modulo3_estrutura_de_dados.filas

import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import java.util.*

class Radio {
    private val queue: Queue<String> = LinkedList()
    private var currentSong: String? = null

    fun addNewSong(song: String) {
        queue.offer(song)
    }

    suspend fun play() {
        while(queue.isNotEmpty()) {
            currentSong = queue.poll()
            println("Musica: " + currentSong)
            println("Proxima musica: " + getNextSong())
            delay(1000)
        }
    }

    fun getNextSong(): String? {
        return queue.peek()
    }
}

fun main(): Unit = runBlocking {
    val radio = Radio()
    radio.addNewSong("Primeira musica")
    launch {
        radio.play()
    }

    launch {
        radio.addNewSong("Segunda música")
        radio.addNewSong("Terceira música")
        radio.addNewSong("Quarta música")
        radio.addNewSong("Quinta música")
        delay(500)
        radio.addNewSong("Sexta música")
    }
}

/*
* Criar uma estrutura para tratar um ticket de suporte, tratar apenas com waiting time
* menor que 10
* */