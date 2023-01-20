package com.rlinoz.modulo3_estrutura_de_dados.revisao

import java.util.*

data class Product(val name: String, val brand: String)

class Store {
    private val products = TreeMap<String, Product>()

    init {
        products["Camiseta Azul-Renner"] = Product("Camiseta Azul", "Renner")
        products["Camiseta Vermelha-Renner"] = Product("Camiseta Vermelha", "Renner")
        products["Camiseta Amarela-Renner"] = Product("Camiseta Amarela", "Renner")
        products["Camiseta Azul-Hering"] = Product("Camiseta Azul", "Hering")
        products["Camiseta Azul-asdf"] = Product("Camiseta Azul", "asdf")
        products["Camisa Azul-Zara"] = Product("Camiseta Azul", "Zara")
    }

    fun searchProductByName(name: String): SortedMap<String, Product> {
        return products.subMap(name, name + Character.MAX_VALUE)
    }

    // Conveniencia de usar o Set
    fun availableFiltersForResult(map: SortedMap<String, Product>): Set<String> {
        return map.map { it.value }
            .map { it.brand }
            .toHashSet()
    }

}

fun main() {
    val store = Store()

    val result = store.searchProductByName("Camiseta")
    println(result)
    println(store.availableFiltersForResult(result))
}