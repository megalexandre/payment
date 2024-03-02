package payment.steps

import com.google.gson.JsonObject
import com.google.gson.JsonParser
import io.azam.ulidj.ULID.random
import io.cucumber.java.en.And
import io.cucumber.java.en.Then
import io.cucumber.java.en.When
import io.restassured.module.kotlin.extensions.Given
import io.restassured.module.kotlin.extensions.When
import io.restassured.response.Response
import java.math.BigDecimal
import junit.framework.TestCase.assertTrue
import org.junit.jupiter.api.Assertions.assertEquals
import payment.ApplicationIT
import payment.application.request.TransactionAttemptRequest
import payment.commons.PersonType
import payment.core.entity.Person
import payment.core.entity.Wallet
import payment.core.usecase.stub.transactionAttemptRequestStub

class TransactionStepdefs: ApplicationIT() {

    var response: Response? = null

    @When("I send a POST with body")
    fun iSendAPOSTWithBody(body: String) {
        val header = mutableMapOf<String,String>()
        header["Content-Type"] = "application/json"

        response = Given {
            headers(header)
            body(body)
        } When {
            post("http://localhost:$serverPort/transaction")
        }
    }

    @Then("status code should be {int}")
    fun statusCodeShouldBe(status: Int) {
        assertEquals(status, response?.statusCode)
    }

    @When("quando eu faco uma solicitacao valida")
    fun quandoEuFacoUmaSolicitacaoValida() {
    }

    @When("quando eu faco uma solicitacao onde o payer é uma loja")
    fun quandoEuFacoUmaSolicitacaoOndeOPayerEUmaLoja() {
    }

    @When("try {string} do a transaction to a {string}")
    fun tryDoATransactionToA(personPayer: String, personPayee: String, ) {

        val payer = savedPersons().first { it.personType.name ==  personPayer.uppercase()}
        val payee = savedPersons().first { it.personType.name ==  personPayee.uppercase()}

        val request = gson.toJson(
            TransactionAttemptRequest(
                payerId = payer.id,
                payeeId = payee.id,
                value = BigDecimal.ONE
            )
        )

        val header = mutableMapOf<String,String>()
        header["Content-Type"] = "application/json"

        response = Given {
            headers(header)
            body( request )
        } When {
            post("http://localhost:$serverPort/transaction")
        }
    }


    private fun savedPersons(): List<Person> =  listOf(
        Person(
            id = "01HQ34HPVK0RRA7CA2E2MNK37H",
            name = "legal",
            email = "fulano@mail.com",
            document = "1q231231",
            password = "",
            personType = PersonType.LEGAL,
            wallet = Wallet(BigDecimal.TEN)
        ),

        Person(
            id = "01HQ34HPVKXYCGG8MYE2QCZ98G",
            name = "individual",
            email = "fulano@mail.com",
            document = "1q231231",
            password = "",
            personType = PersonType.INDIVIDUAL,
            wallet = Wallet(BigDecimal.TEN)
        )
    )

    @When("try do a transaction where value exceed wallet")
    fun tryDoATransactionWhereValueExceedWallet() {
        val request = gson.toJson(
            transactionAttemptRequestStub.copy(
                value = BigDecimal(11)
            )
        )

        val header = mutableMapOf<String,String>()
        header["Content-Type"] = "application/json"

        response = Given {
            headers(header)
            body( request )
        } When {
            post("http://localhost:$serverPort/transaction")
        }
    }

    @And("message should be {string}")
    fun messageShouldBe(message: String) {
        val jsonObject: JsonObject = JsonParser.parseString(response?.body?.asString()).asJsonObject
        val messageResponse: String = jsonObject.getAsJsonPrimitive("message").asString

        assertEquals(message, messageResponse)
    }

    @When("transaction attempt person is not found")
    fun transactionAttemptPersonIsNotFound() {
        val request = gson.toJson(
            TransactionAttemptRequest(
                payerId = random(),
                payeeId = random(),
                value = BigDecimal.ONE
            )
        )

        val header = mutableMapOf<String,String>()
        header["Content-Type"] = "application/json"

        response = Given {
            headers(header)
            body( request )
        } When {
            post("http://localhost:$serverPort/transaction")
        }
    }

    @And("message should content {string}")
    fun messageShouldContent(message: String) {
        val messageResponse = getProperty("message")
        assertTrue(messageResponse.contains(message))
    }


    private fun getProperty(property: String): String {
        val jsonObject: JsonObject = JsonParser.parseString(response?.body?.asString()).asJsonObject
        return jsonObject.getAsJsonPrimitive(property).asString
    }

}