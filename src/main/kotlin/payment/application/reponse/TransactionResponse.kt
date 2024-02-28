package payment.application.reponse

import payment.core.entity.Transaction

class TransactionResponse(
    val id: String,
) {
    constructor(transaction: Transaction): this (
        id = transaction.id
    )
}