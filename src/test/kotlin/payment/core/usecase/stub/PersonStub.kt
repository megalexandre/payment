package payment.core.usecase.stub

import java.math.BigDecimal
import java.math.BigDecimal.ZERO
import payment.comomns.PersonType.INDIVIDUAL
import payment.comomns.PersonType.LEGAL
import payment.core.entity.Person
import payment.core.entity.Wallet

val walletStub = Wallet(
    value = BigDecimal.TEN
)

val walletZeroValueStub = Wallet(
    value = ZERO
)

val personLegalStub = Person(
    name ="fulano",
    email = "fulano@mail.com",
    document = "1q231231",
    password = "",
    personType = LEGAL,
    wallet = walletStub
)

val personIndividualStub = Person(
    name ="fulano",
    email = "fulano@mail.com",
    document = "1q231231",
    password = "",
    personType = INDIVIDUAL,
    wallet = walletStub
)