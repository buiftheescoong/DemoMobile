import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.Assert.*
import org.junit.runners.JUnit4

// Calculator class definition in Kotlin
class Calculator {
    fun add(a: Double, b: Double): Double {
        return a + b
    }
    fun sub(a: Double, b: Double): Double {
        return a - b
    }
}

// Specify the test runner as JUnit4
@RunWith(JUnit4::class)
class CalculatorTest {

    private lateinit var mCalculator: Calculator

    // Set up the environment for testing
    @Before
    fun setUp() {
        mCalculator = Calculator()
    }

    // Test for simple addition
    @Test
    fun addTwoNumbers() {
        val resultAdd = mCalculator.add(1.10000001, 1.2)
        println("Result of addition: $resultAdd")
        assertEquals(2.30000001, resultAdd, 0.0005)  // Using assertEquals with tolerance for floating point
    }
    @Test
    fun subTwoNumbers() {
        val resultSub = mCalculator.sub(5.0, 1.0)
        assertEquals(4.0, resultSub, 0.0)  // Using assertEquals with tolerance for floating point
    }

    // Clean up resources (if needed)
    @After
    fun tearDown() {
        // Clean-up code goes here if necessary
    }
}
