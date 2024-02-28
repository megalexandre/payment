package payment.core.entity

import io.azam.ulidj.ULID.random
import java.math.BigDecimal

data class TransactionAttempt(
    val payerId: String,
    val payeeId: String,
    val value: BigDecimal,
) {

    fun toTransaction(payer: Person, payee: Person) = Transaction(
        id = random(),
        payer = payer,
        payee = payee,
        value = value,
    )
}