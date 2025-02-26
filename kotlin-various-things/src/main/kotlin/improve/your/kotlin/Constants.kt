package improve.your.kotlin

interface Constants {

    /// val pi: String = "3.14" is not allowed

    val pi: String
        get() = "3.14"

    fun printPi() {
        print(pi)
    }

}