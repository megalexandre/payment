package payment.application

import jakarta.validation.Valid
import org.springframework.http.MediaType.APPLICATION_JSON_VALUE
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import payment.application.reponse.TransactionResponse
import payment.application.request.TransactionAttemptRequest
import payment.commons.util.created
import payment.core.usecase.TransactionUsecase
import payment.infrastructure.Sl4jLogger
import payment.infrastructure.info

@RestController
@RequestMapping("transaction",
    consumes = [APPLICATION_JSON_VALUE],
    produces = [APPLICATION_JSON_VALUE]
)
class TransactionController(
    private val transaction: TransactionUsecase
): Sl4jLogger(){
    @PostMapping
    fun transaction(@Valid @RequestBody request: TransactionAttemptRequest): ResponseEntity<TransactionResponse> {
        with(request){
            logger.info {
                "starting transacting attempt: payer:$payerId send $value to payee payeeId"
            }

            return created(
                TransactionResponse(transaction.execute(toEntity()))
                    .also {
                        logger.info { "finish transaction ${it.id}" }
                    }
            )
        }
    }

}