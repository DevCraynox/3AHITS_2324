package at.htlhl.calculator;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class CalculatorTest {
    Calculator calculator;

    /**
     * Wird einmal aufgerufen, wenn die Klasse für den Text initialisiert wird.
     */
    @BeforeAll
    public static void beforeClass() {

    }

    /**
     * Wird immer von einer Testmethode aufgerufen
     */
    @BeforeEach
    public void setup() {
        calculator = new Calculator();
    }

    @Test
    public void multiply() {
        assertEquals(36, calculator.multiply(6, 6));
    }

    @Test
    public void testAbsoluteValue() {
        assertEquals(6, calculator.absolutValue(6));
        assertEquals(6, calculator.absolutValue(-6));
    }

    @Test
    public void add() {
        assertEquals(42, calculator.add(20, 22));
    }

    @Test
    public void subtract() {
        assertEquals(-3, calculator.subtract(8, 11));
    }

    @Test
    public void testDivide() {
        try {
            assertEquals(3, calculator.divide(9, 3));
        } catch (CalcException ex) {
            fail("Hier sollte keine Exception auftreten!");
        }

        try {
            calculator.divide(9, 0);
            fail("CalcException sollte auslösen!");
        } catch (CalcException ex) {
            // Ignore
        }
    }

    /**
     * Wird immer nach einer Testmethode aufgerufen.
     */
    @AfterEach
    public void tearDown() {

    }

    /**
     * Wird aufgerufen, wenn alle Test für die Klasse abschlossen sind.
     */
    @AfterAll
    public static void afterClass() {

    }
}
