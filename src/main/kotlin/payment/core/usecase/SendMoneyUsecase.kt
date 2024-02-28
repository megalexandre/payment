package payment.core.usecase

import payment.comomns.PersonType.LEGAL
import payment.core.entity.Payment

class SendMoneyUsecase {

    fun execute(payment: Payment) {

        if(canNotDO(payment)){
            throw RuntimeException("esse cara não pode fazer o pagamento")
        }

    }

    private fun canNotDO(payment: Payment): Boolean = with(payment){
        (payer.personType === LEGAL || value > payer.wallet.value)
    }


}