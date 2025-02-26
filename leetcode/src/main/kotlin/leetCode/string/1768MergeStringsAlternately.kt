package leetCode.string

fun main() {
    System.out.println(mergeAlternately("zzx", "pplsq"))
}

fun mergeAlternately(word1: String, word2: String): String {
    val word1Chars = word1.toList()
    val word2Chars = word2.toList()
    val mergedStrings = mutableListOf<Char>()
    for (i in 0 until maxOf1(word1.length, word2.length)) {
        if (i <= word1Chars.lastIndex) {
            mergedStrings.add(word1Chars.get(i))
        }
        if (i <= word2Chars.lastIndex) {
            mergedStrings.add(word2Chars.get(i))
        }
    }
    return mergedStrings.joinToString("")
}

private fun maxOf1(a: Int, b: Int): Int {
    println("трек количества вызовово")
    return maxOf(a, b)
}

