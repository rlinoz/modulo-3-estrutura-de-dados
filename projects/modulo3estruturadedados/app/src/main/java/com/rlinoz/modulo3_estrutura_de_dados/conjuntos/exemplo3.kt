package com.rlinoz.modulo3_estrutura_de_dados.conjuntos

// Todo evento dura 1h
data class Event(
    val name: String,
    val time: Int // 8, 9, 10, 11, ....18
)

data class Calendar(
    val events: MutableSet<Event>
) {
    // O inserir deve garantir que o evento pode ser adicionado
    // Encontrar os eventos iguais em duas agendas (quando tem o mesmo nome e horário)
    // Encontrar horários vazios nas duas agendas (das 8 as 18)
    val eventTimes
        get() = events.map { it.time }.toSet()

    fun addEvent(event: Event): Boolean {
        return if (events.map { it.time }.toSet().contains(event.time)) {
            println("Já exite um evento no mesmo horário")
            false
        } else {
            events.add(event)
        }
    }

    fun matchEvents(calendar: Calendar): Set<Event> {
        return this.events intersect calendar.events
    }

    fun findEmptySlots(calendars: List<Calendar>): Set<Int> {
        // map, filter, reduce(fold)
        val usedSlots = mutableSetOf<Int>()
        for (cal in calendars) {
            usedSlots += cal.eventTimes
        }

//        val usedSlots = calendars
//            .fold(emptySet()) { result: Set<Int>, item: Calendar ->
//                result + item.eventTimes
//            }

//        val usedSlots: Set<Int> = eventTimes + calendar.eventTimes
        return (8..18).toSet() - usedSlots
    }
}

fun main() {
    val c1 = Calendar(
        mutableSetOf(
            Event("Daily", 9),
            Event("Daily 2", 11),
            Event("Daily 3", 15),
        )
    )

    c1.addEvent(Event("Retro", 9))

    val c2 = Calendar(
        mutableSetOf(
            Event("Daily", 9),
            Event("Planning", 10),
            Event("Planning 2", 12),
            Event("Planning 3", 17),
        )
    )

    val c3 = Calendar(
        mutableSetOf(
            Event("Daily", 9),
            Event("Planning", 10),
            Event("Planning 2", 12),
            Event("Planning 3", 15),
        )
    )

    println(c1.matchEvents(c2))

    println(c1.findEmptySlots(listOf(c2, c3)))
}