package payment.core.usecase

import payment.core.entity.Payment

class SendMoneyUsecase {

    fun execute(payment: Payment) {

        if(!isValidUsecase(payment)){
            throw RuntimeException("esse cara não pode fazer o pagamento")
        }

    }

    private fun isValidUsecase(payment: Payment): Boolean =
        (payment.payer.canSendMoney && payment.isValid)

}