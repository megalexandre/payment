package payment.core.usecase

import java.math.BigDecimal
import java.math.BigDecimal.ONE
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import payment.core.entity.Wallet
import payment.core.usecase.stub.paymentStub
import payment.core.usecase.stub.personIndividualStub
import payment.core.usecase.stub.personLegalStub


class SendMoneyUsecaseTest{

    private val usecase = SendMoneyUsecase()

    @Test
    fun `when a legal do a transaction should throw runtimeException`(){
        assertThrows<RuntimeException> {
            usecase.execute(
                paymentStub.copy(
                    payer = personLegalStub
                )
            )
        }
    }

    @Test
    fun `when transaction value exceed user money should throw runtimeException`(){
        val valueFromPersonWallet = BigDecimal(11)
        val valueFromTransaction = BigDecimal(10)

        assertThrows<RuntimeException> {
            usecase.execute(
                paymentStub.copy(
                    value = valueFromPersonWallet,
                    payer = personIndividualStub.copy(
                        wallet = Wallet(valueFromTransaction)
                    )
                )
            )
        }
    }

    @Test
    fun `when payed is Individual and has money to individual should do it`(){
        Assertions.assertDoesNotThrow {
            usecase.execute(
                paymentStub.copy(
                    payer = personIndividualStub,
                    payee = personIndividualStub,
                    value = ONE
                )
            )
        }
    }

    @Test
    fun `when payed is individual and has money to legal should do it`(){
        Assertions.assertDoesNotThrow {
            usecase.execute(
                paymentStub.copy(
                    payer = personIndividualStub,
                    payee = personLegalStub,
                    value = ONE
                )
            )
        }
    }
}