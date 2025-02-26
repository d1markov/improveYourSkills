package improve.your.kotlin.inline

import kotlinx.serialization.Serializable
import kotlinx.serialization.json.Json
import kotlinx.serialization.serializer
import javax.swing.tree.TreeNode
import kotlin.reflect.typeOf



fun main() {
    printTypeName<CocaCola>()
    println("\n")
    printTypeName(CocaCola::class.java)
}


/**  function without reified
 * В теле этой функции, вы не можете получить доступ к типу, поскольку он доступен только во время компиляции, но удален во время выполнения.
 * Поэтому, если вы хотите использовать универсальный тип в качестве обычного класса в теле функции, необходимо явно передать класс в качестве параметра
 *
 */
fun <T> printTypeName(clazz: Class<T>) {
    val type = clazz.typeName
    //val type1 = typeOf<T>() Cannot use 'T' as reified type parameter. Use a class instead.
    println("function without Reified type parameter")
    println("Name is: $type")
}

/** function with reified
 * Если вы создаете функцию с reified, то к типу можно получить доступ даже во время выполнения, и поэтому вам не нужно передавать его дополнительно.
 * Вы можете работать с ним так, как если бы это был обычный класс - например, вы можете проверить, является ли переменная экземпляром ,
 * что вы можете легко сделать тогда:
 *
 */

inline fun <reified T> printTypeName() {
    val type = typeOf<T>()
    println("function with Reified type parameter")
    println("Name is: $type")
}

data class Cocktail<T>(
    val isSparkling: Boolean,
    val secretIngredient: T
)

data class CocaCola(val isZero: Boolean = false)