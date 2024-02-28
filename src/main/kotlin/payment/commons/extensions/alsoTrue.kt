package payment.commons.extensions

inline fun Boolean.alsoTrue(block:() -> Unit): Boolean {

    if(this){
        block()
    }

    return this
}
