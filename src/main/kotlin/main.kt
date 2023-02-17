import kotlin.math.max

const val TYPE_VISA = "VISA"
const val TYPE_MIR = "Мир"
const val TYPE_MASTERCARD = "MasterCard"
const val TYPE_MAESTRO = "Maestro"
const val TYPE_VK = "VK Pay"
const val ERROR_TYPE = -1
const val ERROR_LIMIT = -2


fun main() {

    val comission = comission(TYPE_VK, 100_000, 0)

    println(comission)
}

fun comission(paymentSystem: String, amound: Int, previousTranslations: Int) = when (paymentSystem) {
    TYPE_VISA, TYPE_MIR -> if (amound < 150_000 && amound + previousTranslations <= 600_000) max(35, (amound * 0.0075f).toInt()) else ERROR_LIMIT
    TYPE_MAESTRO, TYPE_MASTERCARD -> if (amound < 150_000 && amound + previousTranslations <= 600_000 && amound <= 75_000) 0 else if (amound < 150_000 && amound + previousTranslations <= 600_000) (amound * 0.006f).toInt() + 20 else ERROR_LIMIT
    TYPE_VK -> if (amound <= 15_000 && amound + previousTranslations <= 40_000) 0 else ERROR_LIMIT
    else -> ERROR_TYPE
}
