package payment

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import io.cucumber.spring.CucumberContextConfiguration
import io.restassured.builder.RequestSpecBuilder
import io.restassured.config.LogConfig
import io.restassured.config.RestAssuredConfig
import io.restassured.filter.log.LogDetail
import io.restassured.http.ContentType.JSON
import io.restassured.specification.RequestSpecification
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT
import org.springframework.boot.test.web.server.LocalServerPort
import org.springframework.test.context.junit.jupiter.SpringExtension

@SpringBootTest(webEnvironment = RANDOM_PORT,
    classes = [Application::class]
)
@CucumberContextConfiguration
@ExtendWith(SpringExtension::class)
class ApplicationIT {
    lateinit var restAssured: RequestSpecification

    @LocalServerPort
    var serverPort = -1;

    @BeforeEach
    fun beforeEach(){
        setup()
    }

    private fun setup() {
        restAssured = RequestSpecBuilder()
            .setContentType(JSON)
            .setBaseUri("http:localhost")
            .setPort(serverPort)
            .setRelaxedHTTPSValidation()
            .setConfig(
                RestAssuredConfig.config().logConfig(
                    LogConfig.logConfig().enableLoggingOfRequestAndResponseIfValidationFails(LogDetail.ALL)
                )
            ).build()
    }


    val gson: Gson = GsonBuilder().create()
}
