package payment.core.entity

import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import payment.commons.PersonType.INDIVIDUAL
import payment.commons.PersonType.LEGAL
import payment.core.usecase.stub.personLegalStub

class PersonTest {

    @Test
    fun `when person is legal shouldn't able send money`(){
        assertFalse(personLegalStub.copy(personType = LEGAL).canSendMoney)
    }
    @Test
    fun `when person is individual should able send money`(){
        assertTrue(personLegalStub.copy(personType = INDIVIDUAL).canSendMoney)
    }
}