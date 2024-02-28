package payment.core.usecase

import java.math.BigDecimal.TEN
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import payment.core.entity.Payment
import payment.core.usecase.stub.personIndividualStub
import payment.core.usecase.stub.personLegalStub
import payment.core.usecase.stub.walletZeroValueStub


class SendMoneyUsecaseTest{


    @Test
    fun `when a legal do a transaction should throw runtimeException`(){
        assertThrows<RuntimeException> {
            SendMoneyUsecase().execute(
                Payment(
                    payer = personLegalStub,
                    payee = personIndividualStub,
                    value = TEN,
                )
            )
        }
    }

    @Test
    fun `when payed has no money should throw runtimeException`(){
        assertThrows<RuntimeException> {
            SendMoneyUsecase().execute(
                Payment(
                    payer = personIndividualStub.copy(wallet = walletZeroValueStub),
                    payee = personIndividualStub,
                    value = TEN,
                )
            )
        }
    }

    @Test
    fun `when payed is Individual and has money should do it`(){
        Assertions.assertDoesNotThrow {
            SendMoneyUsecase().execute(
                Payment(
                    payer = personIndividualStub,
                    payee = personIndividualStub,
                    value = TEN,
                )
            )
        }
    }
}