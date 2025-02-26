package testsFinder

private const val ALLURE_ID_PATTERN = """@AllureId(""""
private const val START_OF_ADDED_LINE = "+ "
private const val START_OF_DELETED_LINE = "- "

class ChangedTestsFinder {

    fun find(targetBranch: String): List<Int> {
        val lines = getGitDiff(targetBranch).lines()
        var line = ""
        val allureIds = mutableSetOf<Int>()
        var isFunctionChanged = false
        for (index in lines.lastIndex downTo 0) {
            line = lines[index]
            if (line.startsWith(START_OF_ADDED_LINE) || line.startsWith(START_OF_DELETED_LINE)) {
                isFunctionChanged = true //
            }
            if (
                line.contains(ALLURE_ID_PATTERN)
                && isFunctionChanged
                && !line.startsWith(START_OF_DELETED_LINE) // брать allureID только из плюс строки либо из строки без плюса
            ) {
                allureIds.add(getAllureId(line))
            }
            if (line.isBlank()) {
                isFunctionChanged = false // перешли к следующему блоку кода
            }
        }
        return allureIds.toList()
    }

    private fun getGitDiff(targetBranch: String): String {
        val process = Runtime.getRuntime()
            .exec("git -C /Users/d.markov/StudioProjects/mvno-android-features diff -W  master $targetBranch")
        return process.inputStream.bufferedReader().readText()
    }

    private fun getAllureId(line: String): Int = line.substringAfter(ALLURE_ID_PATTERN).substringBefore("\"").toInt()
}