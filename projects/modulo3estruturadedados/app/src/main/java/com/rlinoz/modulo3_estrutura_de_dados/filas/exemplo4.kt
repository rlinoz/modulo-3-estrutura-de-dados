package com.rlinoz.aula1_demo.filas

import android.os.Build
import androidx.annotation.RequiresApi
import java.util.PriorityQueue


@RequiresApi(Build.VERSION_CODES.N)
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