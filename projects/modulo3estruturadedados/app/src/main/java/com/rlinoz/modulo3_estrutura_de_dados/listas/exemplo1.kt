package com.rlinoz.modulo3_estrutura_de_dados.listas

data class Sticker(
    val number: Int,
    val name: String,
    val team: String
)

// Lista ligada - Array

data class WorldCupStickerDeck(
    private val stickers: MutableList<Sticker>
) {

    fun addSticker(sticker: Sticker) {
        stickers.add(sticker)
    }

    fun searchStickerByName(name: String): Sticker? { // O(n)
        for (sticker in stickers) { // O(n)
            if (sticker.name == name) { // O(1)
                return sticker
            }
        }
        return null
    }

    fun removeSticker(sticker: Sticker) {
        for (index in stickers.indices) { // O(n)
            if (stickers[index] == sticker) { // O(1)
                stickers.removeAt(index)
                break
            }
        }
    }

    fun showAllStickers() {
        for (sticker in stickers) {
            println(sticker)
        }
    }

    fun sortStickers() {
        stickers.sortBy { it.number }
    }
}

fun main() {
    val deck = WorldCupStickerDeck(mutableListOf())

    val sticker = Sticker(52, "Messi", "Argentina")
    val sticker2 = Sticker(54, "Mbape", "Franca")

    deck.addSticker(sticker)
    deck.addSticker(sticker2)

    println(deck.searchStickerByName("Messi"))

    deck.showAllStickers()
    deck.removeSticker(sticker)

    println(deck)
}

/*
* Big O notation (notação grande o)
* O(1)
* O(n)
* O(2n)
* */