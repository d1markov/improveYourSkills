package leetCode.string

fun main() {
    // println(gcdOfStringsV2("ABCZQPAJW","ABCEIBEBVUEJZQPABOBCZQ" ))
    //println(gcdOfStringsV2("ABCDEF","ABC"))
    var short = "dwf"
    var sliced = short.substringAfter(short).substringAfter(short)
    println(short.indices)
    println("sliced$sliced")
    println("".isEmpty())

    println(short.substring(0, short.lastIndex))
}

fun getCommonChars(str1: String, str2: String): String {
    val commonSymbols = mutableSetOf<Char>()
    str1.forEach { char ->
        if (str2.contains(char)) {
            commonSymbols += char
        }
    }
    return commonSymbols.joinToString("")
}

fun gcdOfStrings(str1: String, str2: String): String {
    val commonChars = getCommonChars(str1, str2)
    if (str1.startsWith(commonChars) && str2.startsWith(commonChars)) {
        return commonChars
    } else {
        return ""
    }
}

fun gcd(x: Int, y: Int): Int {
    return if (y == 0) {
        x
    } else {
        gcd(y, x % y)
    }
}

fun gcdOfStringsV2(str1: String, str2: String): String {
    // Check if they have non-zero GCD string.
    if (str1 + str2 != str2 + str1) {
        return ""
    }
    // Get the GCD of the two lengths.
    val gcdLength = gcd(str1.length, str2.length)
    return str1.substring(0, gcdLength)
}


class SolutionFirst {
    fun gcdOfStrings(str1: String, str2: String): String {
        var devisor: String = ""
        var prefix: String = ""
        var long = ""
        var short = ""
        var remainder = ""
        if (str1.length >= str2.length) {
            long = str1
            short = str2
        } else {
            long = str2
            short = str1
        }
        if (long.substringAfter(short) == short) {
            return short
        }
        var slicedShort = short
        for (i in 0..short.lastIndex - 1) {
            print("slicedShort: $slicedShort\n")
            if (long.startsWith(slicedShort)) {
                if (long.length % slicedShort.length == 0) {
                    var dividedLong = long
                    for (longI in 0..(long.length / slicedShort.length)) { // 0, 1, 2, 3
                        dividedLong = dividedLong.substringAfter(slicedShort)
                        if (dividedLong.startsWith(slicedShort)) {
                            continue
                        } else if (dividedLong.isEmpty()) {
                            var dividedShort = short
                            for (j in 0..(short.length / slicedShort.length)) {
                                if (dividedShort.startsWith(slicedShort)) {
                                    dividedShort = dividedShort.substringAfter(slicedShort)
                                } else {
                                    break
                                }
                                print("$j dividedShort: $dividedShort\n")
                            }
                            if (dividedShort.isEmpty()) {
                                devisor = slicedShort
                                break
                            } else {
                                slicedShort = slicedShort.substring(0, slicedShort.lastIndex)
                                break
                            }
                        } else {
                            slicedShort = slicedShort.substring(0, slicedShort.lastIndex)
                            break
                        }
                    }
                    if (devisor.isNotEmpty()) break
                } else {
                    slicedShort = slicedShort.substring(0, slicedShort.lastIndex)
                }
            } else {
                slicedShort = slicedShort.substring(0, slicedShort.lastIndex)
            }
        }
        return devisor

    }

    public fun String.substringAfterFirst(delimiter: Char, missingDelimiterValue: String = this): String {
        val index = lastIndexOf(delimiter)
        return if (index == -1) missingDelimiterValue else substring(index + 1, length)
    }
}

class SolutionRefactoring {
    fun gcdOfStrings(str1: String, str2: String): String {
        var devisor: String = ""
        var long = ""
        var short = ""
        if (str1.length >= str2.length) {
            long = str1
            short = str2
        } else {
            long = str2
            short = str1
        }
        if (long.substringAfter(short) == short) {
            return short
        }
        var slicedShort = short
        for (i in 0 until short.lastIndex) {
            print("slicedShort: $slicedShort\n")
            if (long.startsWith(slicedShort) && long.length % slicedShort.length == 0) {
                var dividedLong = long
                for (longI in 0..(long.length / slicedShort.length)) { // 0, 1, 2, 3
                    dividedLong = dividedLong.substringAfter(slicedShort)
                    if (dividedLong.startsWith(slicedShort)) {
                        continue
                    } else if (dividedLong.isEmpty()) {
                        var dividedShort = short
                        for (j in 0..(short.length / slicedShort.length)) {
                            if (dividedShort.startsWith(slicedShort)) {
                                dividedShort = dividedShort.substringAfter(slicedShort)
                            } else {
                                break
                            }
                            print("$j dividedShort: $dividedShort\n")
                        }
                        if (dividedShort.isEmpty()) {
                            devisor = slicedShort
                            break
                        } else {
                            slicedShort = slicedShort.substring(0, slicedShort.lastIndex)
                            break
                        }
                    } else {
                        slicedShort = slicedShort.substring(0, slicedShort.lastIndex)
                        break
                    }
                }
                if (devisor.isNotEmpty()) break

            } else {
                slicedShort = slicedShort.substring(0, slicedShort.lastIndex)
            }
        }
        return devisor
    }
}


// "ABABAB", str2 = "AB"
// Output: "AB"

// "ABABABAB", str2 = "ABAB"
// Output: "ABAB"


// long начинается с short ?
// нет - уменьшить short на один
// да длина long делится без остатка на длину short?

// да убрать префикс с long ( повторять количество делений, но нужно чтою соталось три символа в конце )
// нет  - уменьшить short на один
