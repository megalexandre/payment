package payment.commons.util


import org.springframework.http.HttpStatus.CREATED
import org.springframework.http.ResponseEntity
import org.springframework.lang.Nullable

inline fun <reified T> created(@Nullable body: T): ResponseEntity<T> {
    return ResponseEntity(body, CREATED)
}
