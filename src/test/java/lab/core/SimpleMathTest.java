package lab.core;

import lab.core.SimpleMath;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.junit.jupiter.params.provider.CsvSource;

/**
 * Class with unit tests.
 *
 * @author BarbaraKorpak
 * @version 1.1
 */
public class SimpleMathTest {

    SimpleMath simpleMath;

    @BeforeEach
    void setUp() {
        simpleMath = new SimpleMath();
    }

    /**
     * Parameterized test should trow incorrect params exception on zero as
     * number of trapezoids.
     *
     *
     */
    @ParameterizedTest
    @ValueSource(ints = {0})
    void testShouldThrownIncorrectParamsExceptionOnZeroAsNumberOfTrapezoids(int numberOfTrapezoids) {
        assertThrows(IncorrectParamsException.class, () -> simpleMath.integral(8, 17, numberOfTrapezoids), "Exception not thrown on incorrect parameters");
    }

    /**
     * Parameterized test should trow incorrect params exception on negative
     * parameters as number of trapezoids.
     *
     *
     */
    @ParameterizedTest
    @ValueSource(ints = {-1, -5, -20})
    void testShouldThrownIncorrectParamsExceptionOnNegativeParameters(int numberOfTrapezoids) {
        assertThrows(IncorrectParamsException.class, () -> simpleMath.integral(8, 17, numberOfTrapezoids), "Exception not thrown on incorrect parameters");
    }

    /**
     * Parameterized test should trow incorrect params exception on lower limit
     * is bigger that upper limit integral.
     *
     *
     */
    @ParameterizedTest
    @CsvSource({
        "17, 8",
        "100, 50",
        "50, 40",
        "46, 45"
    })
    void testShouldThrownIncorrectParamsExceptionOnMinBiggerThanMax(int min, int max) {
        assertThrows(IncorrectParamsException.class, () -> simpleMath.integral(min, max, 2), "Exception not thrown on incorrect parameters");
    }

    /**
     * Parameterized test with the correct situation.
     *
     *
     */
    @ParameterizedTest
    @CsvSource({
        "2, 10, 10, 136",
        "0, 10, 10, 150",
        "10.5, 15.5, 10, 155",
        "-5.0, 10.0, 3, 150"
    })
    public void testShouldHaveCorrectResult(double min, double max, int numberOfTrapezoids, double expectedResult) {
        try {
            double result = simpleMath.integral(min, max, numberOfTrapezoids);
            assertEquals(expectedResult, result, "Integral result differs from expected");
        } catch (IncorrectParamsException e) {
            fail("An IncorrectParamsException was thrown");
        }
    }

}
