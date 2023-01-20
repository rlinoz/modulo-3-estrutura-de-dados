package com.rlinoz.modulo3_estrutura_de_dados.revisao


data class Statement(
    val value: Double,
    val type: String, // DEPOSITO ou SAQUE
    val date: String
)

// Uso de Map por conveniencia
fun main() {

    // 30 dias
    val statements = listOf(
        Statement(10.0, "DEPOSITO", "2022-01-20"),
        Statement(10.0, "DEPOSITO", "2022-01-19"),
        Statement(10.0, "DEPOSITO", "2022-01-19"),
        Statement(10.0, "DEPOSITO", "2022-01-15"),
        Statement(10.0, "DEPOSITO", "2022-01-10")
    ).sortedByDescending { it.date }

    val statementsPerDate = mutableMapOf<String, List<Statement>>()

    /**
     * listOf, mapOf, setOf
     * mutableListOf, mutableMapOf, mutableSetOf
     */

    statements.forEach {
        val statementForDate = statementsPerDate[it.date]
        if (statementForDate == null) {
            statementsPerDate[it.date] = listOf(it)
        } else {
            statementsPerDate[it.date] = statementForDate + listOf(it)
        }
    }

    println(statementsPerDate)

    statementsPerDate.forEach {
        println(it.key)
        it.value.forEach { statement ->
            println(statement)
        }
        println()
        println()
        println()
    }

    // As operações agrupadas por data de forma decrescente
    /**
     * Data
     * Op1
     * Op2
     *
     * Data 2
     * Op3
     *
     * Data 3
     * Op 4
     * Op 5
     */

}