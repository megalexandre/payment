package payment.resource

import java.math.BigDecimal.TEN
import org.springframework.stereotype.Repository
import payment.commons.PersonType.INDIVIDUAL
import payment.commons.PersonType.LEGAL
import payment.core.datasource.PersonDatasource
import payment.core.entity.Person
import payment.core.entity.Wallet

@Repository
class PersonDatasourceImp: PersonDatasource {
    override fun findById(id: String): Person? =
        savedPersons().firstOrNull{ it.id == id}

    private fun savedPersons(): List<Person> =  listOf(
        Person(
            id = "01HQ34HPVK0RRA7CA2E2MNK37H",
            name = "legal",
            email = "fulano@mail.com",
            document = "1q231231",
            password = "",
            personType = LEGAL,
            wallet = Wallet(TEN)
        ),

        Person(
            id = "01HQ34HPVKXYCGG8MYE2QCZ98G",
            name = "individual",
            email = "fulano@mail.com",
            document = "1q231231",
            password = "",
            personType = INDIVIDUAL,
            wallet = Wallet(TEN)
        )
    )

}