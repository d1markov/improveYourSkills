package testsFinder

import org.junit.jupiter.api.Test
import kotlin.system.measureTimeMillis

class ChangedTestsFinderTest {

    // 1 file
    // 1 test: changed one line
    // 1 test: added ful test
    @Test
    fun `one file changed - added one test - changed one line`() {
        checkDiff(
            expectedAllureIds = listOf(3000529, 2222222),
            targetBranch = "test/MVNO-22140-added-1-test-changed-1-line"
        )
    }

    //2 files
    //1 test: added line to one steptest
    //2 test: added last step to multistep test
    //3 test: added first step to multistep test, changed allureId
    //
    @Test
    fun `two files changed - added one line in test - added steps in tests`() {
        checkDiff(
            expectedAllureIds = listOf(2938751, 4444444, 3028987), // не должно быть 3000516
            targetBranch = "test/MVNO-22140-changed-addedStep"
        )
    }

    //2 files
    //1 file: deleted
    //1 file: 1 test deleted
    @Test
    fun `deleted tests`() {
        checkDiff(
            expectedAllureIds = listOf(), // не должно быть 3000516
            targetBranch = "test/MVNO-22140-deleted-tests"
        )
    }

    @Test
    fun `very big diff - all tests changed`() {
        var actualAllureIds: List<Int>
        val time = measureTimeMillis {
             actualAllureIds = ChangedTestsFinder().find(targetBranch = "test/MVNO-22140-all-tests-changed")
        }
        assert(actualAllureIds.size == 933) { "actualAllureIds.size : $actualAllureIds.size " }
        assert(time < 500) { "$time its to long" }
    }



    private fun checkDiff(
        expectedAllureIds: List<Int>,
        targetBranch: String
    ) {
        val actualAllureIds = ChangedTestsFinder().find(targetBranch = targetBranch)
        assert(expectedAllureIds == actualAllureIds) { "actualAllureIds: $actualAllureIds" }
    }
}