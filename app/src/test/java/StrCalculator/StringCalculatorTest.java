/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package StrCalculator;

import org.junit.Test;

public class StringCalculatorTest {
    @Test public int add(String numbersStr) {
            int sum = 0;
            byte numbOfSummarands = 0;
            String numb = "";
            char[] symbols = numbersStr.toCharArray();
            for (int i = 0; i < symbols.length; i++) {
                if (symbols[i] >= '0' && symbols[i] <= '9') {
                    numb += symbols[i];
                    numbOfSummarands = (numbOfSummarands == 0) ? (byte)(numbOfSummarands + 1) : numbOfSummarands;
                    if (i + 1 == symbols.length) {
                        sum += Integer.parseInt(numb);
                    }
                }
                else if ((symbols[i] == ',' && numbOfSummarands > 0)) {
                    sum += Integer.parseInt(numb);
                    numb = "";
                    numbOfSummarands++;
                    if (numbOfSummarands == 2) {
                        break;
                    }
                }
                else break;
            }
            return sum;
        }
    }
