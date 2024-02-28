package payment.core.usecase

import io.mockk.mockk
import payment.core.datasource.PersonDatasource


class TransactionUsecaseTest{

    private val personDatasource: PersonDatasource = mockk()

    private val usecase = TransactionUsecase(
        personDatasource = personDatasource
    )


    /*
    @Test
    fun `when a legal do a transaction should throw runtimeException`(){
        assertThrows<RuntimeException> {
            usecase.execute(
                transactionStub.copy(
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
                transactionStub.copy(
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
                transactionStub.copy(
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
                transactionStub.copy(
                    payer = personIndividualStub,
                    payee = personLegalStub,
                    value = ONE
                )
            )
        }
    }
    */
}