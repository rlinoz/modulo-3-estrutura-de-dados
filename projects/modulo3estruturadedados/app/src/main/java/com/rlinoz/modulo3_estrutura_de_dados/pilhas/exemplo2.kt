package com.rlinoz.modulo3_estrutura_de_dados.pilhas

import java.util.*

enum class ActionType {
    INSERT, DELETE, REPLACE
}

data class Action(
    val value: String,
    val type: ActionType
)

data class CtrlZManager(
    private val previousActions: Stack<Action> = Stack(),
    private val nextActions: Stack<Action> = Stack()
) {
    fun addAction(action: Action) {
        previousActions.push(action)
    }

    fun ctrlZ(): Action? {
        if (previousActions.isEmpty())
            return null

        val action = previousActions.pop()
        nextActions.push(action)
        return action
    }

    fun ctrlY(): Action? {
        if (nextActions.isEmpty())
            return null

        val action = nextActions.pop()
        previousActions.push(action)
        return action
    }

}

fun main() {
    val ctrlZManager = CtrlZManager()

    ctrlZManager.ctrlZ()
    ctrlZManager.addAction(Action("ctrlZManager", ActionType.INSERT))
    ctrlZManager.addAction(Action(" = CtrlZManager()", ActionType.INSERT))
    println(ctrlZManager)
    println(ctrlZManager.ctrlZ())
    println(ctrlZManager)
    println("-----------")
    println(ctrlZManager.ctrlY())
    println(ctrlZManager)
}