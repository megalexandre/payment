package payment.application.request

import java.math.BigDecimal
import payment.core.entity.TransactionAttempt

class TransactionAttemptRequest(
    val payerId: String,
    val payeeId: String,
    val value: BigDecimal,
){
    fun toEntity(): TransactionAttempt = TransactionAttempt(
        payerId = payerId,
        payeeId = payeeId,
        value = value,
    )
}
