package payment.core.datasource

import payment.core.entity.Person

interface PersonDatasource {
    fun findById(id: String): Person ?

}