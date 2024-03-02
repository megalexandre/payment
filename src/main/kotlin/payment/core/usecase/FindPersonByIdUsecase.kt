package payment.core.usecase

import org.springframework.stereotype.Service
import payment.core.datasource.PersonDatasource
import payment.core.entity.Person
import payment.core.exeception.PersonNotFoundException
import payment.infrastructure.Sl4jLogger
import payment.infrastructure.info

@Service
class FindPersonByIdUsecase (
    private val personDatasource: PersonDatasource
): Sl4jLogger() {
    fun execute(id: String): Person =
        personDatasource.findById(id) ?: throw PersonNotFoundException("there is no person with id: $id").also {
            logger.info { "there is no person with id: $id" }
        }

}