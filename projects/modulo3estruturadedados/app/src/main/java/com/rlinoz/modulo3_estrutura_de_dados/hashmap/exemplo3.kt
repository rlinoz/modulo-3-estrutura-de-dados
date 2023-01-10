package com.rlinoz.modulo3_estrutura_de_dados.hashmap

data class Event(
    val title: String,
    val time: Long,
    val day: Int
)

data class Calendar(
    private val hashmap: HashMap<Int, MutableList<Event>> = HashMap()
) {

    fun newEvent(event: Event) {
        if (hashmap.containsKey(event.day)) {
            hashmap[event.day]?.add(event)
        } else {
            hashmap[event.day] = mutableListOf(event)
        }
    }

    fun getEventsForTheDay(day: Int): List<Event> {
        return hashmap[day] ?: emptyList()
    }
}