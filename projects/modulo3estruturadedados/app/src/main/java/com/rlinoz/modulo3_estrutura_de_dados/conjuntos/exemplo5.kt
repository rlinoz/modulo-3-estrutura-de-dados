package com.rlinoz.modulo3_estrutura_de_dados.conjuntos

import java.util.*

data class User(val name: String, val id: Int = 0)

fun main() {
    val users = TreeSet<User> { u1, u2 ->
        u1.name.lowercase().compareTo(u2.name.lowercase())
    }

    users.add(User("Ana"))
    users.add(User("Beatriz"))
    users.add(User("Fernando"))
    users.add(User("Fabio"))
    users.add(User("Edgar"))
    users.add(User("Mauricio"))

//    users.add("Ana")
//    users.add("Beatriz")
//    users.add("Fernando")
//    users.add("Fabio")
//    users.add("Edgar")
//    users.add("Mauricio")

    // F
//    println(users.filter {
//        it.startsWith("F")
//    })

    println(users.subSet(User("FAAAAAAAA"), User("Fzzzzzzzzzzzz")))
}