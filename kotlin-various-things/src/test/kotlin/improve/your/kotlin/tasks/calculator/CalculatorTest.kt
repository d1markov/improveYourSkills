package improve.your.kotlin.tasks.calculator

import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import java.math.BigDecimal

class CalculatorTest {
    @BeforeEach
    fun setUp() {
    }

    @AfterEach
    fun tearDown() {
    }

    val calculatorImpl = CalculatorImpl()

    @Test
    fun regularlyAddition() {
        val result = calculatorImpl.plus(1.0, 2.0, 3.0 )
        assert(result == 6.0)
    }

    @Test
    fun plusZero() {
        val result = calculatorImpl.plus(2.0, 0.0 )
        assert(result == 2.0)
    }

    @Test
    fun regularlySubtraction() {
        val result = calculatorImpl.minus(5.4, 2.1 )
        assert(result == 3.3) { result }
    }

    @Test
    fun times() {
    }

    @Test
    fun div() {
        val result = calculatorImpl.div(5.4, 2.0 )
        assert(result == 3.3) { result }
    }


}