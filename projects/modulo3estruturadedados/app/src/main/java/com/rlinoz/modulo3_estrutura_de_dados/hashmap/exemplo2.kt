package com.rlinoz.modulo3_estrutura_de_dados.hashmap

import java.util.LinkedList
import kotlin.random.Random
import kotlin.system.measureNanoTime

val charPool: List<Char> = ('a'..'z') + ('A'..'Z') + ('0'..'9')
fun randomString() = (1..10)
    .map { Random.nextInt(0, charPool.size).let { charPool[it] } }
    .joinToString("")

fun buildRandomUser(): User {
    val name = randomString()
    val phone = randomString()
    return User(name, phone)
}

data class User(
    val name: String,
    val phone: String
)

fun main() {
    val userHashMap = HashMap<String, User>()
    val userArrayList = LinkedList<User>()

    repeat(10_000_000) {
        val user = buildRandomUser()
        userHashMap.put(user.phone, user)
        userArrayList.add(user)
    }

    val user = userArrayList[9_000_000]

    val hashTime = measureNanoTime { userHashMap.get(user.phone) }
    val listTime = measureNanoTime {
        userArrayList.firstOrNull { it.phone == user.phone }
    }

    println(hashTime)
    println(listTime)
}

//5250
//55167
//233953833
//393137792