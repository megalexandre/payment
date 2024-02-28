package payment.core.entity

import payment.comomns.PersonType

data class Person(
    val name: String,
    val email: String,
    val document: String,
    val password: String,
    val personType: PersonType,
    val wallet: Wallet,
) {
}