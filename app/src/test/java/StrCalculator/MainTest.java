/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package StrCalculator;

import org.junit.Test;

public class MainTest {
    @Test public void testStrCalculator() {
        StringCalculatorTest test = new StringCalculatorTest();
        String a = "1";
        String b = "1,2";
        String c = "4,5,6";
        String d = "@59";
        String e = "";
        System.out.println("\""+ a +"\"" + ": " + test.add(a));
        System.out.println("\""+ b +"\"" + ": " + test.add(b));
        System.out.println("\""+ c +"\"" + ": " + test.add(c));
        System.out.println("\""+ d +"\"" + ": " + test.add(d));
        System.out.println("\""+ e +"\"" + ": " + test.add(e));
    }
}
