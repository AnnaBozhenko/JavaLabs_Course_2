package StrCalculator;

import jdk.nashorn.internal.ir.annotations.Ignore;
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
        strToTest = "//,\n-8,-45,-90";
    }


    private static Stream<Arguments> strCalculatorTesterAnySizeDelimiter() {
        return Stream.of(
                Arguments.of("//[****]\n1-8", 0),
                Arguments.of("//[****", 0),
                Arguments.of("//[]\n1", 1),
                Arguments.of("//[****]\n1", 1),
                Arguments.of("//[^^^^^^^^^]\n1^^^^^^^^^2", 3),
                Arguments.of("//[$]\n4$5$6", 15),
                Arguments.of("//[!!]\n59!!2!!10005", 61),
                Arguments.of("//[.]\n", 0),
                Arguments.of("//[(^_^)]\n3(^_^)8(^_^)12", 23),
                Arguments.of("//[@!@]\n1@!@3@!", 0)
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


//    private static Stream<Arguments> NumbersValidNumbersAreNotGreaterThanThousand() {
//        return Stream.of(
//                Arguments.of("//,\n1001", 0),
//                Arguments.of("//,\n1,20000", 1),
//                Arguments.of("//,\n4,1005,6", 10)
//        );
//    }
//
//
//    @ParameterizedTest(name = "{index} => string = {0}, result = {1}")
//    @MethodSource("NumbersValidNumbersAreNotGreaterThanThousand")
//    void testStrCalculatorNumbersValidNumbersAreNotGreaterThanThousand(String strNumbers, int expected) {
//        try {
//            assertEquals(expected, testable.add(strNumbers), 0f);
//        } catch (NegativesNotAllowedException e) {
//            e.printStackTrace();
//        }
//    }

//    private static Stream<Arguments> strCalculatorTester() {
//        return Stream.of(
//                Arguments.of("//,\n1", 1),
//                Arguments.of("//,\n1,2", 3),
//                Arguments.of("//,\n4,5,6", 15),
//                Arguments.of("//,\n@59", 0),
//                Arguments.of("//,\n", 0),
//                Arguments.of("//,\n9,4\n6", 19),
//                Arguments.of("//,\n2\n5\n5", 12),
//                Arguments.of("//,\n1,\n3", 0),
//                Arguments.of("//,\n3,\n", 0),
//                Arguments.of("//,\n,", 0),
//                Arguments.of("//,\n\n", 0)
//        );
//    }
//
//
//    @ParameterizedTest(name = "{index} => string = {0}, result = {1}")
//    @MethodSource("strCalculatorTester")
//    void testStrCalculator(String strNumbers, int expected) {
//        try {
//            assertEquals(expected, testable.add(strNumbers), 0f);
//        } catch (NegativesNotAllowedException e) {
//            e.printStackTrace();
//        }
//    }


//    @Test
//    @DisplayName("Testing of how many times add() was called.")
//    public void testGetCalledCount() {
//        try {
//            int expectedTimesCalled = 5;
//            String testableStr = "//,\n1,2,3";
//
//            testable.add(testableStr);
//            testable.add(testableStr);
//            testable.add(testableStr);
//            testable.add(testableStr);
//            testable.add(testableStr);
//            assertThat(testable.GetCalledCount(), is(expectedTimesCalled));
//        } catch (NegativesNotAllowedException e) {
//            e.printStackTrace();
//        }
//    }


//    @Ignore
//    @Test
//    @DisplayName("Test to verify if exception for passed negative numbers was thrown.")
//    public void testException() {
//        assertThrows(NegativesNotAllowedException.class, () -> testable.add(strToTest));
//    }
}











