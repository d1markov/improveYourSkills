package testsFinder


private const val ALLURE_ID_PATTERN = """@AllureId(""""

/*
class ChangedTestsReporter() {
     fun report(request: ChangedReportRequest): ImpactedTestsReport {
        val allureTestsMetadata = mutableSetOf<AllureTestMetadata>()
        val gitAddedLinePrefixRegexp = Regex("""^\+[^+].*$""") // в начале строки один +
        val gitDeletedLinePrefixRegexp = Regex("""^-[^-].*$""") // в начале строки один -
        getSplittedDiff(
            currentDir = repository.directory.path,
            mrBranch = request.gitInfo.mrBranch,
            targetBranch = request.gitInfo.targetBranch,
            shouldFetchBranch = request.shouldFetchBranch
        ).forEach { testClassDiff ->
            var isCurrentCodeBlockChanged = false
            val lines = testClassDiff.diffLines
            for (index in lines.lastIndex downTo 0) { // проходим гит дифф каждого файла снизу вверх
                val line = lines[index]
                if (
                    gitAddedLinePrefixRegexp.matches(line) ||
                    gitDeletedLinePrefixRegexp.matches(line)
                ) {
                    isCurrentCodeBlockChanged = true
                }
                if (
                    line.contains(ALLURE_ID_PATTERN) &&
                    isCurrentCodeBlockChanged &&
                    !gitDeletedLinePrefixRegexp.matches(line)
                ) {
                    // Если это тело измененной функции - взять allureId и имя класса
                    allureTestsMetadata.add(
                        AllureTestMetadata(
                            className = testClassDiff.fileName,
                            allureId = line.substringAfter(ALLURE_ID_PATTERN).substringBefore("\"")
                        )
                    )
                }
                if (line.isBlank()) {
                    isCurrentCodeBlockChanged = false // перешли к следующему блоку кода
                }
            }
        }
        return ImpactedTestsReport(emptySet(), allureTestsMetadata.toSet())
    }

    private fun getSplittedDiff(
        currentDir: String,
        mrBranch: String,
        targetBranch: String,
        shouldFetchBranch: Boolean,
    ): List<TestFileDiff> {
        val filesDiffs =
            gitDiff.get(currentDir, mrBranch, targetBranch, shouldFetchBranch)
                .split("diff --git")
        val testFilesDiffs = mutableListOf<TestFileDiff>()
        val gitChangedFilePathPrefixRegex = Regex("""^\+\+\+[^-].*$""") // в начале строки три +
        filesDiffs.forEach { fileDiff ->
            val fileDiffLines = fileDiff.lines()
            val path = fileDiffLines.find { gitChangedFilePathPrefixRegex.matches(it) }
            if (path != null && path.contains("androidTest")) { // берем только дифы из androidTest
                testFilesDiffs.add(
                    TestFileDiff(
                        fileName = path.substringAfterLast("/").substringBefore(".kt"),
                        diffLines = fileDiffLines
                    )
                )
            }
        }
        return testFilesDiffs.toList()
    }
}

data class ChangedReportRequest(
    val gitInfo: GitInfo,
    override val shouldFetchBranch: Boolean,
) : ReportRequest()
*/
