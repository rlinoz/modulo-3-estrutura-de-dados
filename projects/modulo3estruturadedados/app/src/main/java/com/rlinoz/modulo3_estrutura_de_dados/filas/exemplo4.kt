package com.rlinoz.modulo3_estrutura_de_dados.filas

import java.util.*


fun main() {
     val queue: PriorityQueue<Int> = PriorityQueue { new, inQueue ->
          // > 0, < 0, == 0
          if (new > inQueue) 1
          else 0
     }

     queue.offer(1)
     queue.offer(1)
     queue.offer(3)
     queue.offer(2)

     println(queue)
     println(queue.poll())
     println(queue.poll())
     println(queue.poll())
     println(queue.poll())
}