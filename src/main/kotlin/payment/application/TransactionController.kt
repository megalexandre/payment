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

@RestController
@RequestMapping("transaction",
    consumes = [APPLICATION_JSON_VALUE],
    produces = [APPLICATION_JSON_VALUE]
)
class TransactionController(
    private val transaction: TransactionUsecase
){
    @PostMapping
    fun transaction(@Valid @RequestBody request: TransactionAttemptRequest): ResponseEntity<TransactionResponse> = created(
        TransactionResponse(transaction.execute(request.toEntity()))
    )

}