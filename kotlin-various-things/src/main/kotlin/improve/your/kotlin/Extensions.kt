package improve.your.kotlin

class SomeClass {

    fun doSomething(someText: String)  = someText.getLastCharacterInUpperCase()
    fun String.getLastCharacterInUpperCase() = last().uppercase()

}

fun main() {
    val sc = SomeClass()
    val text = "automobile"
    val lastChar = sc.doSomething(text)
   // sc.getLastCharacterInUpperCase() //it doesn't work. function not available from this point
    val firstChar = text.getFirstCharacterInUpperCase()
    println("text is $text")
    println("firstChar is $firstChar")
    println("lastChar is $lastChar")
}

fun String.getFirstCharacterInUpperCase() = first().uppercase()