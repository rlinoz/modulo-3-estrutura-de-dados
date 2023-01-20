package com.rlinoz.modulo3_estrutura_de_dados.revisao

// Set é só uma interface que garante que não existira elementos duplicados
// Garantir eficiencia de uma coleção de elementos não duplicados
data class Payment(val id: String, val value: Double)

class PaymentSystem {

    // Cache do sistema de pagamentos
    private val payedBoletos = HashSet<Payment>()
    private val payedBoletos2 = mutableListOf<Payment>()

    fun pay2(payment: Payment) {
        if (payedBoletos2.contains(payment)) { // O(n)
            println("boleto já foi pago")
            println(payedBoletos2)
            false
        } else {
            payedBoletos2.add(payment)
            println(payedBoletos2)
            true
        }
    }

    fun pay(payment: Payment): Boolean {
//        return if (payedBoletos.contains(payment)) { // O(1)
//            println("boleto já foi pago")
//            println(payedBoletos)
//            false
//        } else {
//            payedBoletos.add(payment)
//            println(payedBoletos)
//            true
//        }
        if (!payedBoletos.add(payment)) {
            println("boleto já foi pago")
            return false
        }

        println(payedBoletos)
        return true
    }

    fun hasBeenPayed(payment: Payment): Boolean {
        return payedBoletos.contains(payment)
    }
}

fun main() {
    // Hash, LinkedHash, Tree
    // HashSet, LinkedHashSet, TreeSet

    val paymentSystem = PaymentSystem()
    paymentSystem.pay2(Payment("1", 10.0))
    paymentSystem.pay2(Payment("1", 10.0))
    paymentSystem.pay2(Payment("1", 10.0))
    paymentSystem.pay2(Payment("2", 10.0))
}