package payment.core.entity

import java.math.BigDecimal.ONE
import java.math.BigDecimal.TEN
import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import payment.core.usecase.stub.personIndividualStub
import payment.core.usecase.stub.transactionStub

class TransactionTest{

    @Test
    fun `when transaction value exceed payer wallet value shouldn't valid`(){
       assertFalse(
           transactionStub.copy(
               value = TEN,
               payer = personIndividualStub.copy(wallet = Wallet(ONE))
           ).isValid
       )
    }

    @Test
    fun `when transaction value is less then payer wallet value should is valid`(){
        assertTrue(
            transactionStub.copy(
                value = ONE,
                payer = personIndividualStub.copy(wallet = Wallet(TEN))
            ).isValid
        )
    }

    @Test
    fun `when transaction value is same then payer wallet value should is valid`(){
        assertTrue(
            transactionStub.copy(
                value = ONE,
                payer = personIndividualStub.copy(wallet = Wallet(ONE))
            ).isValid
        )
    }
}