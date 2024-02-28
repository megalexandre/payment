package payment.core.usecase

import org.springframework.stereotype.Service
import payment.core.entity.Transaction
import payment.core.entity.TransactionAttempt
import payment.core.exeception.InvalidUsecaseException

@Service
class TransactionUsecase(
    val findPerson : FindPersonByIdUsecase
) {

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
                throw InvalidUsecaseException("this person ${payer.id} is not authorized to do a transaction")
            }

            if(!isValid) {
                throw InvalidUsecaseException("this transactions is not valid")
            }

        }
    }

}