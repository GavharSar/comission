import org.junit.Assert.*
import org.junit.Test

class MainKtTest {

    @Test
    fun comissionLimitNotExceededVKday() {
        val type = TYPE_VK
        val amound = 15_000
        val previousTranslations = 0

        val result = comission(paymentSystem = type, amound = amound, previousTranslations = previousTranslations)

        assertEquals(0, result)
    }

    @Test
    fun comissionLimitExceededVKday() {
        val type = TYPE_VK
        val amound = 21_000
        val previousTranslations = 0

        val result = comission(paymentSystem = type, amound = amound, previousTranslations = previousTranslations)

        assertEquals(ERROR_LIMIT, result)
    }

    @Test
    fun comissionLimitExceededVKmonth() {
        val type = TYPE_VK
        val amound = 21_000
        val previousTranslations = 20_000

        val result = comission(paymentSystem = type, amound = amound, previousTranslations = previousTranslations)

        assertEquals(ERROR_LIMIT, result)
    }

    @Test
    fun comissionLimitNotExceededVKmonth() {
        val type = TYPE_VK
        val amound = 10_000
        val previousTranslations = 15_000

        val result = comission(paymentSystem = type, amound = amound, previousTranslations = previousTranslations)

        assertEquals(0, result)
    }

    @Test
    fun comissionUnknownType() {
        val type = "1111"
        val amound = 10_000
        val previousTranslations = 15_000

        val result = comission(paymentSystem = type, amound = amound, previousTranslations = previousTranslations)

        assertEquals(ERROR_TYPE, result)
    }

    @Test
    fun comissionLimitNotExceededMDay() {
        val type = TYPE_MASTERCARD
        val amound = 100_000
        val previousTranslations = 15_000

        val result = comission(paymentSystem = type, amound = amound, previousTranslations = previousTranslations)

        assertEquals(620, result)
    }

    @Test
    fun comissionLimitExceededMDay() {
        val type = TYPE_MASTERCARD
        val amound = 200_000
        val previousTranslations = 0

        val result = comission(paymentSystem = type, amound = amound, previousTranslations = previousTranslations)

        assertEquals(ERROR_LIMIT, result)
    }

    @Test
    fun comissionLimitExceededMMonth() {
        val type = TYPE_MASTERCARD
        val amound = 150_000
        val previousTranslations = 500_000

        val result = comission(paymentSystem = type, amound = amound, previousTranslations = previousTranslations)

        assertEquals(ERROR_LIMIT, result)
    }

    @Test
    fun comissionNotLimitNotExceededMDay() {
        val type = TYPE_MASTERCARD
        val amound = 70_000
        val previousTranslations = 500_000

        val result = comission(paymentSystem = type, amound = amound, previousTranslations = previousTranslations)

        assertEquals(0, result)
    }

    @Test
    fun comissionLimitNotExceededVisaDay() {
        val type = TYPE_VISA
        val amound = 100_000
        val previousTranslations = 15_000

        val result = comission(paymentSystem = type, amound = amound, previousTranslations = previousTranslations)

        assertEquals(750, result)
    }

    @Test
    fun comissionLimitExceededVisaDay() {
        val type = TYPE_VISA
        val amound = 200_000
        val previousTranslations = 0

        val result = comission(paymentSystem = type, amound = amound, previousTranslations = previousTranslations)

        assertEquals(ERROR_LIMIT, result)
    }

    @Test
    fun comissionLimitExceededVisaMonth() {
        val type = TYPE_VISA
        val amound = 150_000
        val previousTranslations = 500_000

        val result = comission(paymentSystem = type, amound = amound, previousTranslations = previousTranslations)

        assertEquals(ERROR_LIMIT, result)
    }
}