package improve.your.kotlin// свое исключение можно создать, когда нужно какой-то кастомный message кидать


fun main(args: Array<String>) {
    try {
        trowExceptionOn5()
    } catch (e: Exception) {
        print("Exception caught\n")
    } finally {
        print("Exception processed\n")
    }

    throwCustomException()

}


fun trowExceptionOn5() {
    for (i in 0..10) {
        if (i == 6) {
            throw Exception("Exception occurred")
        }
        println(i)
    }
}

fun throwCustomException() {
    (0..5).reduce { sum, element ->
        print("$sum\n")
        if (sum > 6) {
            throw CustomException()
        }
        sum + element
    }
}


class CustomException : Exception() {

    override val message: String
        get() = "super.message override"

    override fun getLocalizedMessage(): String {
        return super.getLocalizedMessage()
    }

    override fun printStackTrace() {
        super.printStackTrace()
    }


}