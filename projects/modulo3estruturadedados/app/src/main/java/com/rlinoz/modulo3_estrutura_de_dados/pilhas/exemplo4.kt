package com.rlinoz.modulo3_estrutura_de_dados.pilhas

import java.util.*

class ExpressionValidator() {

    // apenas validar parenteses
    // utilizando pilha
    fun isValid(expression: String): Boolean {
        val stack = Stack<Char>()

        expression.forEach {
            if (it == '(') {
                stack.push(it)
            } else if (it == ')') {
                if (stack.isEmpty())
                    return false

                val previous = stack.pop()
//                if (it != '(') {
//                    return false
//                }
            }

        }

        return stack.isEmpty()
    }
}

fun main() {
    val expressionValidator = ExpressionValidator()

    println(expressionValidator.isValid("((1 + 2))"))

    val random = Random(1000)
    println(random.nextBoolean())
    println(random.nextBoolean())
    println(random.nextBoolean())
    println(random.nextBoolean())
}