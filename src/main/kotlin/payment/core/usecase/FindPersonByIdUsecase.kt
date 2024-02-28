package payment.core.usecase

import org.springframework.stereotype.Service
import payment.core.datasource.PersonDatasource
import payment.core.entity.Person
import payment.core.exeception.PersonNotFoundException

@Service
class FindPersonByIdUsecase (
    private val personDatasource: PersonDatasource
) {
    fun execute(id: String): Person =
        personDatasource.findById(id) ?: throw PersonNotFoundException("does not exists person with id: $id")

}