package leetCode

fun main() {
    val s =  " "

    println(s.isBlank())
}

fun isPalindrome(s: String): Boolean {
    if(s.isEmpty()) {
        return true
    } else {
        var reversed = ""
        var normal = ""
        s.lowercase().forEach { char->
            if(char.isDigit()) {
                reversed = "$char$reversed"
                normal = "$normal$char"
            }
        }
        return reversed == normal && reversed.length>1
    }
}