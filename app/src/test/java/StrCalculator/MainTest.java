package StrCalculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import java.util.stream.Stream;
import static org.junit.jupiter.api.Assertions.*;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class MainTest {
    private final StringCalculatorTest testable;
    private final String strToTest;

    public MainTest() {
        testable = new StringCalculatorTest();
        strToTest = "//[%%]\n-8%%-45%%-90";
    }


    private static Stream<Arguments> strCalculatorTesterAnySizeDelimiter() {
        return Stream.of(
                Arguments.of("%3", 0),
                Arguments.of("//[****", 0),
                Arguments.of("//[]\n1", 1),
                Arguments.of("//[****]\n3", 3),
                Arguments.of("//[^^^^^^^^^]\n1^^^^^^^^^2", 3),
                Arguments.of("//[$]\n4$5$6", 15),
                Arguments.of("//[!!][++][**$**]\n59!!2++3**$**1++10005", 65),
                Arguments.of("//[.]\n", 0),
                Arguments.of("//[]\n3\n98", 101),
                Arguments.of("//[%%][###]\n%%12###89", 0),
                Arguments.of("//[****]\n3%^7", 0),
                Arguments.of("//[]\n36", 36)
                );
    }


    @ParameterizedTest(name = "{index} => string = {0}, result = {1}")
    @MethodSource("strCalculatorTesterAnySizeDelimiter")
    void testStrCalculatorCalculatorTesterAnySizeDelimiter(String strNumbers, int expected) {
        try {
            assertThat(testable.add(strNumbers), is(expected));
        } catch (NegativesNotAllowedException e) {
            e.printStackTrace();
        }
    }


    @Test
    @DisplayName("Testing of how many times add() was called.")
    public void testGetCalledCount() {
        try {
            int expectedTimesCalled = 5;
            String testableStr = "//[,]\n1,2,3";

            testable.add(testableStr);
            testable.add(testableStr);
            testable.add(testableStr);
            testable.add(testableStr);
            testable.add(testableStr);
            assertThat(testable.GetCalledCount(), is(expectedTimesCalled));
        } catch (NegativesNotAllowedException e) {
            e.printStackTrace();
        }
    }


    @Test
    @DisplayName("Test to verify if exception for passed negative numbers was thrown.")
    public void testException() {
        assertThrows(NegativesNotAllowedException.class, () -> testable.add(strToTest));
    }
}











