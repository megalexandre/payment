package payment.core.exeception

class PersonNotFoundException(private val error: String) : RuntimeException(error)