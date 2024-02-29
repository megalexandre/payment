package payment.steps

import io.cucumber.java.en.Then
import io.cucumber.java.en.When
import io.restassured.module.kotlin.extensions.Given
import io.restassured.module.kotlin.extensions.When
import io.restassured.response.Response
import org.junit.jupiter.api.Assertions.assertEquals
import payment.ApplicationIT

class TransactionStepdefs: ApplicationIT() {

    var response: Response? = null

    @When("I send a POST with body")
    fun iSendAPOSTWithBody(body: String) {
        response = Given {
            body(body)
        } When {
            post("http://localhost:$serverPort/transaction")
        }
    }

    @Then("status code should be {int}")
    fun statusCodeShouldBe(status: Int) {
        assertEquals(200, status)
    }
}