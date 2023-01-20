package com.rlinoz.modulo3_estrutura_de_dados.revisao

import java.util.*
import kotlin.collections.HashMap

data class BookLocation(
    val title: String,
    val section: String
)

data class Book(val title: String)

class Library {

    // Preciso buscar parcialmente por uma chave o mais rápido possível
    private val bookLocations = TreeMap<String, BookLocation>()

    // Primeira utilidade: acesso rápido a informação
    private val books = HashMap<BookLocation, Book>()

    init {
        bookLocations["Harry Potter"] = BookLocation("Harry Potter", "J")
        bookLocations["Harry Potter 1"] = BookLocation("Harry Potter 2", "J")
        bookLocations["Harry Potter 2"] = BookLocation("Harry Potter 2", "J")
        bookLocations["Harry Potter 3"] = BookLocation("Harry Potter 3", "J")
        bookLocations["Harry"] = BookLocation("Harry", "J")
        bookLocations["POO"] = BookLocation("POO", "J")

        books[BookLocation("Harry Potter", "J")] = Book("Harry Potter")
    }

    fun getLocationByTitle(title: String): BookLocation? {
        return bookLocations[title]
    }

    fun searchByTitle(title: String): SortedMap<String, BookLocation> {
        return bookLocations.subMap(title, title + Character.MAX_VALUE)
    }

    fun getBook(location: BookLocation): Book? {
        return books[location]
    }
}

fun main() {
    val library = Library()

    val location = library.getLocationByTitle("Harry Potter")
    println(location)
    if (location != null)
        println(library.getBook(location))

    val locations = library.searchByTitle("POO")
    println(locations)
}