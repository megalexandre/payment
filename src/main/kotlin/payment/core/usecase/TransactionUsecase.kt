package payment.core.usecase

import org.springframework.stereotype.Service
import payment.core.entity.Transaction
import payment.core.entity.TransactionAttempt
import payment.core.exeception.InvalidUsecaseException
import payment.infrastructure.Sl4jLogger
import payment.infrastructure.info

@Service
class TransactionUsecase(
    val findPerson : FindPersonByIdUsecase
): Sl4jLogger(){
    fun execute(transactionAttempt: TransactionAttempt): Transaction {

        val transaction = transactionAttempt.toTransaction(
            payer = findPerson.execute(transactionAttempt.payerId),
            payee = findPerson.execute(transactionAttempt.payeeId)
        )

        isValidUsecase(transaction)

        return transaction
    }

    private fun isValidUsecase(transaction: Transaction){
        with(transaction){

            if(!payer.canSendMoney) {
                logger.info { "this payer ${payer.id} is not authorized to do a transaction" }
                throw InvalidUsecaseException("this payer is not authorized to do a transaction")
            }

            if(!isValid) {
                logger.info {
                    "this transaction is not valid, because the value: " +
                    "$value exceed payer ${payer.id} wallet ${payer.wallet.value}"
                }
                throw InvalidUsecaseException("this transactions is not valid")
            }
        }
    }

}