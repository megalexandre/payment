package payment.core.entity

import java.math.BigDecimal
data class Transaction(
    val id: String,
    val payer: Person,
    val payee: Person,
    val value: BigDecimal,
){
    val isValid: Boolean
        get() = payer.wallet.value >= value

}

