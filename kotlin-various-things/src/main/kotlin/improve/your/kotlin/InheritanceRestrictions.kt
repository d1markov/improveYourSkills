package improve.your.kotlin

/**
 * Ограничения наследования в Kotlin
 * Какие существуют ограничения при наследовании в Kotlin. Могу ли я унаследоваться от любого класса, от которого захочу?
 * По умолчанию все классы в котлине final. Нужно использоваться ключевое слово open для возможности отнаследоваться
 * Можно ли сделать все классы по умолчанию open - плагин для gradle/maven allopen
 */

class InheritanceIsImpossible

//class TryToInheritPt1: InheritanceIsImpossible()



open class InheritanceIsPossible

class TryToInheritPt2: InheritanceIsPossible()



