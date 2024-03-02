package payment.core.usecase.stub

import java.math.BigDecimal.TEN
import payment.commons.PersonType.INDIVIDUAL
import payment.commons.PersonType.LEGAL
import payment.core.entity.Person
import payment.core.entity.Wallet

val walletStub = Wallet(
    value = TEN
)

val personLegalStub = Person(
    id = legalId,
    name ="fulano",
    email = "fulano@mail.com",
    document = "1q231231",
    password = "",
    personType = LEGAL,
    wallet = walletStub
)

val personIndividualStub = Person(
    id = individualId,
    name ="fulano",
    email = "fulano@mail.com",
    document = "1q231231",
    password = "",
    personType = INDIVIDUAL,
    wallet = walletStub
)