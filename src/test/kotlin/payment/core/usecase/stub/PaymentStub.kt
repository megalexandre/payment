package payment.core.usecase.stub

import java.math.BigDecimal
import payment.core.entity.Payment


val paymentStub = Payment(
    payer = personLegalStub,
    payee = personIndividualStub,
    value = BigDecimal.TEN,
)