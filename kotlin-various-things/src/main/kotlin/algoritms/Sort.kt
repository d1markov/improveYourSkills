package algoritms

fun main() {
    val word1 = "abc"
    val word2 = "pqr"
    println(    mergeAlternately(word1, word2)
    )


}

fun mergeAlternately(word1: String, word2: String): String {
    val merged = StringBuilder()
    val minLength = minOf(word1.length, word2.length)

    // Добавляем символы поочередно из обеих строк
    for (i in 0 until minLength) {
        merged.append(word1[i])
        merged.append(word2[i])
    }

    // Добавляем оставшиеся символы из более длинной строки
    if (word1.length > minLength) {
        merged.append(word1.substring(minLength))
    } else if (word2.length > minLength) {
        merged.append(word2.substring(minLength))
    }

    return merged.toString()
}


class Solution {
    fun mergeTwoLists(list1: List<Int>?, list2: List<Int>?): List<Int>? {
        val result = mutableListOf<Int>()
        if (list1 != null) {
            for (number in list1) {
                result.add(number)
            }
        }
        if (list2 != null) {
            for (number in list2) {
                result.add(number)
            }
        }
        result.sort()
        return result
    }
}