package payment

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import io.cucumber.spring.CucumberContextConfiguration
import io.restassured.builder.RequestSpecBuilder
import io.restassured.specification.RequestSpecification
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT
import org.springframework.boot.test.web.server.LocalServerPort
import org.springframework.test.context.junit.jupiter.SpringExtension

@SpringBootTest(webEnvironment = RANDOM_PORT, classes = [Application::class])
@CucumberContextConfiguration
@ExtendWith(SpringExtension::class)
class ApplicationIT {

    @LocalServerPort
    var serverPort = -1;

    lateinit var restAssured: RequestSpecification
    @BeforeEach
    fun setup(){
        restAssured = buildRequestSpec()
    }

    private fun buildRequestSpec(): RequestSpecification {
        return RequestSpecBuilder()
            .setPort(serverPort)
            .addHeader("Content-Type", "application/json")
            .build()
    }

    val gson: Gson = GsonBuilder()
        .create()

}
