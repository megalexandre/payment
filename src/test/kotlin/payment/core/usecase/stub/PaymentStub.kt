package payment.core.usecase.stub

import io.azam.ulidj.ULID.random
import java.math.BigDecimal.TEN
import payment.core.entity.Transaction


val transactionStub = Transaction(
    id = random(),
    payer = personLegalStub,
    payee = personIndividualStub,
    value = TEN,
)