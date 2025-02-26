package leetCode

fun main() {

}

class ValidAnagram {
    fun isAnagram(s: String, t: String): Boolean {
        val first = s.toMutableList() // method 1
        if(s.length != t.length){
            return false
        } else {
            for(tchar in t) {
                if(first.contains(tchar)) {
                    first.remove(tchar) // method 1
                    continue
                }
                else {
                    return false
                }
            }
        }
        return true
    }
}