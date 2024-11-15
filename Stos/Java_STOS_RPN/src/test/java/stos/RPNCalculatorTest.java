package stos;

import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

public class RPNCalculatorTest {

    private RPNCalculator calculator;

    @Before
    public void setUp() {
        calculator = new RPNCalculator(); // Inicjalizacja przed każdym testem
    }

    @Test
    public void testEvaluate_SingleNumber() {
        assertEquals(5, calculator.evaluate("5"));
    }

    @Test
    public void testEvaluate_SimpleAddition() {
        assertEquals(8, calculator.evaluate("5 3 +"));
    }

    @Test
    public void testEvaluate_SimpleSubtraction() {
        assertEquals(2, calculator.evaluate("5 3 -"));
    }

    @Test
    public void testEvaluate_SimpleMultiplication() {
        assertEquals(15, calculator.evaluate("5 3 *"));
    }

    @Test
    public void testEvaluate_ComplexExpression() {
        assertEquals(14, calculator.evaluate("5 1 2 + 4 * + 3 -"));
    }
}
