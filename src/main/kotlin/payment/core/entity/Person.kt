package payment.core.entity

import payment.commons.PersonType
import payment.commons.PersonType.INDIVIDUAL

data class Person(
    val id: String,
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