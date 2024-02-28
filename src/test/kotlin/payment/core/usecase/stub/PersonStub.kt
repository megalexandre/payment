package payment.core.usecase.stub

import io.azam.ulidj.ULID
import java.math.BigDecimal
import java.math.BigDecimal.ZERO
import payment.commons.PersonType.INDIVIDUAL
import payment.commons.PersonType.LEGAL
import payment.core.entity.Person
import payment.core.entity.Wallet

val walletStub = Wallet(
    value = BigDecimal.TEN
)

val walletZeroValueStub = Wallet(
    value = ZERO
)

val personLegalStub = Person(
    id = ULID.random(),
    name ="fulano",
    email = "fulano@mail.com",
    document = "1q231231",
    password = "",
    personType = LEGAL,
    wallet = walletStub
)

val personIndividualStub = Person(
    id = ULID.random(),
    name ="fulano",
    email = "fulano@mail.com",
    document = "1q231231",
    password = "",
    personType = INDIVIDUAL,
    wallet = walletStub
)