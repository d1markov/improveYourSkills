package improve.your.kotlin

/**
 * Основной и дополнительный конструктор
 * Основной конструктор является частью заголовка класса, его объявление идёт сразу после имени класса (и необязательных параметров):
 * class Person constructor(firstName: String)
 */
class Constructors(private val primaryConstructorValue: String?) {

    private var secondaryConstructorValue: Int? = null

    constructor(secondaryConstructorValue: Int) : this(null) {
        println("its secondaryConstructor block")
        this.secondaryConstructorValue = secondaryConstructorValue
    }

    init {
        println("its init block")
    }

    fun printValueFromPrimaryConstructor() {
        println("primaryConstructorValue is:\n $primaryConstructorValue")
    }

    fun printValueFromSecondaryConstructor() {
        println("secondaryConstructorValue is:\n $secondaryConstructorValue")
    }

}


fun main() {

    val pConstructor = Constructors("new value")
    val sConstructor = Constructors(100)

    pConstructor.apply {
        printValueFromPrimaryConstructor()
        printValueFromSecondaryConstructor()
    }

    sConstructor.apply {
        printValueFromPrimaryConstructor()
        printValueFromSecondaryConstructor()
    }

}

class Person(val name: String) {
    private var children: MutableList<Person> = mutableListOf()

    constructor(name: String, parent: Person) : this(name) {
        parent.children.add(this)
    }
}