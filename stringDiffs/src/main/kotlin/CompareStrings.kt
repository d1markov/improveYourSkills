import com.github.difflib.DiffUtils
import com.github.difflib.text.DiffRowGenerator

// потестил на наших ТК. Возникают проблемы с формированием маркдауна, некоторые символы воспринимаются как регулярки
// и текст размечается криво не всегда так как нужно для маркдауна
// соотв нужно экранирование спец символов и переписывание oldTag newTag и других функций
fun main() {
    val result = FailedComparisonResult(
        allureID = 2768630,
        autotestName = "2768630 Открытие. Подключено оо мин + оо гб, Раздача, Запланировано оо мин + 25 гб, Мессенждеры > В MVNO_Tariff_Change_Plan_Shown параметр changeType = mixedDowngrade",
        testCaseName = "2768630 Открытие. Подключено оо мин + оо гб, Раздача, Запланировано оо мин + 25 гб, Мессенждеры > В MVNO_Tariff_Change_Planned_Shown параметр changeType = mixedDowngrade"
    )
    createDiffReportMd(
        AnalyzeResult(
            listOf(result)
        )
    )
}

private fun createDiffReportMd(analyzeResult: AnalyzeResult) = buildString {
    val generator = DiffRowGenerator.create()
        .showInlineDiffs(true)
        .inlineDiffByWord(true)
        .oldTag { _ -> " ~ " }
        .newTag { _ -> " ** " }
        .build()
    appendLine("|original|new|")
    appendLine("|--------|---|")
    analyzeResult.failedComparisonResults.forEach { result ->
        appendLine(result.allureID)
        val rows = generator.generateDiffRows(
            listOf(result.autotestName),
            listOf(result.testCaseName)
        )
        rows.forEach { row ->
            appendLine("|" + row.oldLine + "|" + row.newLine + "|")
        }
    }
}


data class AnalyzeResult(
    val failedComparisonResults: List<FailedComparisonResult> = listOf(),
    val additionalInfo: List<String> = listOf(),
)

data class FailedComparisonResult(
    val allureID: Int,
    val autotestName: String?,
    val testCaseName: String,
)

