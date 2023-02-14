fun main() {
    val amound = 100_000
    val paymentSystem = "VK Pay"
    var previousTranslationsVK = 0
    var previousTranslations = 0
    val minComission = 35
    val maxComission = 0.0075
    val limit = 75_000
    val mComission = 0.006

    var commission1 = commission(paymentSystem, amound, maxComission, minComission, limit, mComission)

    println("Сумма комиссии состаяляет $commission1 рублей")
    println()
    if (paymentSystem == "VK Pay") limitsVK(previousTranslationsVK, amound) else limits(previousTranslations, amound)
}

fun commission(paymentSystem: String, amound: Int, maxComission: Double, minComission: Int, limit: Int, mComission: Double) = when (paymentSystem) {
    "Visa", "Мир" -> if (amound * maxComission < minComission) minComission else amound * maxComission
    "MasterCard", "Maestro" -> if (amound < limit) 0 else amound * mComission + 20
    else -> 0
}

fun limitsVK(previousTranslationsVK: Int, amound: Int) {
        if (amound > 15_000 || previousTranslationsVK > 40_000 || previousTranslationsVK + amound > 40_000) println("Превышена сумма лимита перевода")
        else println("Перевод успешно выполнен"); previousTranslationsVK + amound
}

fun limits(previousTranslations: Int, amound: Int) {
    if (amound > 150_000 || previousTranslations > 600_000 || previousTranslations + amound > 600_000) println("Превышена сумма лимита перевода")
    else println("Перевод успешно выполнен"); previousTranslations + amound
}