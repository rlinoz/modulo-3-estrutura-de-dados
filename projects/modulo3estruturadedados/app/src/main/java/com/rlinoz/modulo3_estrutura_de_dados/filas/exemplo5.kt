package com.rlinoz.modulo3_estrutura_de_dados.filas

import java.util.*

class TicketManager2 {

    private val queue: Queue<TicketRequest> = PriorityQueue { new, inQueue ->
        if (new.waitingTime in 7..9) -1
        else if (new.waitingTime >= 10) 1
        else if (inQueue.waitingTime in 7..9) 1 // Caso o ticket que já esta na fila tenha waiting time entre 7 e 9 o ticket novo perde prioridade
        else 0
    }

    fun add(ticket: TicketRequest) {
        queue.offer(ticket)
        println("Estado atual da fila: $queue")
    }

    fun execute() {
        var currentTicketRequest = queue.poll()
        while (currentTicketRequest != null) {
            if (currentTicketRequest.waitingTime < 10) {
                println("Resolvendo: " + currentTicketRequest.name)
            } else {
                println("Cancelado: " + currentTicketRequest.name)
            }
            currentTicketRequest = queue.poll()
        }
    }
}

fun main() {
    val ticketManager = TicketManager2()

    ticketManager.add(ticket = TicketRequest("Ticket 1", 5))
    ticketManager.add(ticket = TicketRequest("Ticket 2", 11))
    ticketManager.add(ticket = TicketRequest("Ticket 3", 8))
    ticketManager.add(ticket = TicketRequest("Ticket 4", 7))
    ticketManager.add(ticket = TicketRequest("Ticket 5", 9))
    ticketManager.add(ticket = TicketRequest("Ticket 6", 5))

    ticketManager.execute()
}