package payment.core.entity

import payment.comomns.PersonType
import payment.comomns.PersonType.INDIVIDUAL

data class Person(
    val name: String,
    val email: String,
    val document: String,
    val password: String,
    val personType: PersonType,
    val wallet: Wallet,
) {

    val canSendMoney: Boolean
        get() = personType == INDIVIDUAL
}