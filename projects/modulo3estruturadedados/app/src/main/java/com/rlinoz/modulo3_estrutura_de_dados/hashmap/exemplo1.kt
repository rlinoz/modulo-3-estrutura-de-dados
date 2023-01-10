package com.rlinoz.modulo3_estrutura_de_dados.hashmap

import java.util.*
import kotlin.collections.LinkedHashMap
import kotlin.math.abs


data class HashMap2<K, V>(
    private val buckets: Array<LinkedList<Pair<K, V>>?> = arrayOfNulls(16)
) {

    fun put(key: K, value: V) {
        val index = abs(key.hashCode() % buckets.size)

        var bucket = buckets[index]
        if (bucket == null) {
            bucket = LinkedList()
            buckets[index] = bucket
            bucket.add(Pair(key, value))
        } else {
            for (index in bucket.indices) {
                if (bucket[index].first == key) {
                    bucket[index] = key to value
                    return
                }
            }
            bucket.add(Pair(key, value))
        }
    }

    fun get(key: K): Pair<K, V>? {
        val index = abs(key.hashCode() % buckets.size)
        val bucket = buckets[index]

        if (bucket == null) {
            return null
        }

        return bucket.firstOrNull { it.first == key }
    }

    fun remove(key: K): Boolean {
        val index = abs(key.hashCode() % buckets.size)
        val bucket = buckets[index]

        if (bucket == null)
            return false

        return bucket.removeIf { it.first == key }
    }
}

data class Person(
    val name: String
)
// h1 × 31n−1 + h2 × 31n−2 + … + hn
fun main() {
    val hashmap = LinkedHashMap<Person, String>()
    hashmap.put(Person("a"), "b")
    hashmap.put(Person("a"), "c")
    hashmap.put(Person("b"), "c")
    hashmap.put(Person("bc"), "c")
    hashmap.put(Person("bd"), "c")
    hashmap.put(Person("bea"), "c")
    hashmap.put(Person("easdf"), "c")
    hashmap.put(Person("easdf3"), "c")
    println(hashmap)

    hashmap.forEach { entry ->
        println(entry.key)
    }
}