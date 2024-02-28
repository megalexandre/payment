package payment.core.exeception

class InvalidUsecaseException(private val error: String) : RuntimeException(error)