package payment.core.entity

import java.math.BigDecimal

class Payment(
    val payer: Person,
    val payee: Person,
    val value: BigDecimal,
)