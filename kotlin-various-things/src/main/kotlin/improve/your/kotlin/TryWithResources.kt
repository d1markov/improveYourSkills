package improve.your.kotlin

import java.io.BufferedReader
import java.io.FileReader

/** Как реализовать try-with-resources в Котлин
 *
 * Использовать метод use, относительно объекта, класс которого реализует AutoCloseable
 * https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.io/use.html
 *  0_o ?!??!?!?!
 *
 *  Доп инфо(моя проработка):
 *  try-with-resources это паттерн, который нужно использовать когда
 *  Русурс - что угодно файл, блокировка , транзакция в БД итп
 *  Идея в том, чтобы закхватить ресурс и освободить его посл операции.
 *
 *  В стандартной бибилиотеке котлин есть функция use() котора я применяется к закрываемым ресурсам
 *  т.е. обьектам которые реализованы классом, который наследуется от AutoCloseable
 *  Как пример можно взять работу с файлми. См код ниже
 */


class TryWithResources {

    /**
     * В данном примере Функция use принимает лямбду в reader.readLine(), выполняет ее и освобождаеи (закрывает) ресурс
     */
    fun readFirstLine(): String {
        BufferedReader(FileReader("build.gradle")).use { reader ->
            return reader.readLine()
        }
    }

}

fun main() {
    val firstLine = TryWithResources().readFirstLine()
    println(firstLine)
}