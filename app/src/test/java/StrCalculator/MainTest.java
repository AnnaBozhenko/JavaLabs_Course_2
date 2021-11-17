package StrCalculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import java.util.stream.Stream;
import static org.junit.jupiter.api.Assertions.*;

public class MainTest {
    private final StringCalculatorTest testable;
    private final String strToTest;
    public MainTest() {
        testable = new StringCalculatorTest();
        strToTest = "//,\n8,-45,-90";
    }

//    @ParameterizedTest(name = "{index} => string = {0}, result = {1}")
//    @MethodSource("strCalculatorTester")
//    void testStrCalculator(String strNumbers, int expected) {
//        assertEquals(expected, testable.add(strNumbers), 0f);
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
    @Test
    @DisplayName("There exception didn't occur.")
    public void testException() {
        assertThrows(NegativesNotAllowedException.class, () -> testable.add(strToTest));
    }
}











