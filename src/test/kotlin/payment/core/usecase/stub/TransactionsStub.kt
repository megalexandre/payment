package payment.core.usecase.stub

import io.azam.ulidj.ULID.random
import java.math.BigDecimal.TEN
import payment.application.request.TransactionAttemptRequest
import payment.core.entity.Transaction

val legalId = "01HQ34HPVK0RRA7CA2E2MNK37H"
val individualId = "01HQ34HPVKXYCGG8MYE2QCZ98G"


val transactionStub = Transaction(
    id = random(),
    payer = personLegalStub,
    payee = personIndividualStub,
    value = TEN,
)

val transactionAttemptRequestStub = TransactionAttemptRequest(
    payerId = individualId,
    payeeId = legalId,
    value = TEN,
)