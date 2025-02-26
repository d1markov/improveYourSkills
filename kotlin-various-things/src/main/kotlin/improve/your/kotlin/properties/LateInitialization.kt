package improve.your.kotlin.properties

/**
 * Отложенная инициализация
 *
 * Расскажите про отложенную инициализацию. Как проверить была ли проинициализирована переменная
 *
 * Для нее используется ключевое слово lateinit. Использовать его можно только на var полях внутри класса.
 * Так же у переменной не должно быть кастомных геттеров и сеттеров. Проверить можно с помощью метода .isInitialized
 */

class PersonalData(val firstName: String) {

    lateinit var additionalInfo: List<String>
    //get() = listOf()  //not allowed

    fun requestAdditionalInfo() {
        additionalInfo = listOf("Данные с госуслуг")
    }

    fun isAdditionalInfoInitialized() = ::additionalInfo.isInitialized

}

fun main() {
    val valeriyPersonalData = PersonalData(firstName = "Valeriy")
    valeriyPersonalData.apply {
        //println(additionalInfo)  will be failed with Exception: lateinit property additionalInfo has not been initialized
        requestAdditionalInfo()
        if(isAdditionalInfoInitialized()) {
            println(additionalInfo)
        }
    }
}