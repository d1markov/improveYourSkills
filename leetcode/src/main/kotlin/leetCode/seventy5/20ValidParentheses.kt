package leetCode.seventy5

fun main() {

    println(isValid2("([])"))
}

fun isValid(s: String): Boolean {
    val round = "()"
    val braces = "{}"
    val square = "[]"
    var stack = ""
    s.forEach { bracket ->
        if (bracket == round.first() || bracket == braces.first() || bracket == square.first()) {
            stack = "$bracket$stack"
        } else if (stack.isNotBlank()) {
            if (
                (bracket == round.last() && stack.first() == round.first()) ||
                (bracket == braces.last() && stack.first() == braces.first()) ||
                (bracket == square.last() && stack.first() == square.first())
            ) {
                stack = stack.drop(1)
                // || bracket == braces.last() ||bracket == square.last(
            } else {
                return false
            }
        } else {
            return false
        }
    }
    return stack.isBlank()
}

fun isValid2(s: String): Boolean {
    val round = "()"
    val braces = "{}"
    val square = "[]"
    val opened = listOf(round.first(), braces.first(), square.first())
    val closed = listOf(round.last(), braces.last(), square.last())
    var stack = ""
    s.forEach { bracket ->
        if (opened.contains(bracket)) {
            stack = "$bracket$stack"
        } else if (closed.contains(bracket) && stack.isNotBlank()) {
            if (
                round.contains(bracket) && stack.first() == round.first() ||
                braces.contains(bracket) && stack.first() == braces.first() ||
                square.contains(bracket) && stack.first() == square.first()
            ) {
                stack = stack.drop(1)
            }
        } else {
            return false
        }
    }
    return stack.isBlank()
}


fun isValidWithoutStack(s: String): Boolean {
    val round = "()"
    val braces = "{}"
    val square = "[]"
    var openedCount = 0
    var closedCount = 0
    var isValid = false
    val listOfBrackets = listOf(round, braces, square)
    listOfBrackets.forEach { brackets ->
        if (s.contains(brackets.first()) && s.contains(brackets.last()).not()) {
            return false
        }
        for (bracket in s) {
            if (bracket == brackets.first()) {
                openedCount++
            } else if (bracket == brackets.last()) {
                closedCount++
            }
        }
        if (openedCount == closedCount) {
            isValid = true
        }
    }
    return isValid
}