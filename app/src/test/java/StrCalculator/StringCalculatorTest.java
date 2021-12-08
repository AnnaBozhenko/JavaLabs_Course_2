package  StrCalculator;

import org.checkerframework.checker.units.qual.A;

import java.util.ArrayList;

public class StringCalculatorTest {

    static int timesCalled;
    public StringCalculatorTest() {
        timesCalled = 0;
    }

    public int GetCalledCount(){
        return timesCalled;
    }

    public int add(String numbersStr) throws NegativesNotAllowedException {

        int sum = 0;
//        define delimiter

        if (numbersStr.charAt(0) == '/' && numbersStr.charAt(1) == '/' && numbersStr.charAt(2) == '[') {
            ArrayList<Integer> negativeNumbers = new ArrayList<>();
            StringBuilder delimiter = new StringBuilder(0);
            StringBuilder number = new StringBuilder();
//            set index to 3 to iterate over given string because it has been already checked for first 3 characters
            int index = 3;
            short delim_numb = 0;
            while (index < numbersStr.length() && numbersStr.charAt(index) != ']') {
                delimiter.append(numbersStr.charAt(index++));
                delim_numb++;
            }
            if (index == numbersStr.length() && numbersStr.charAt(index - 1) != ']') sum = 0;
            //case when there was no delimiter passed (no enclosing square brackets)
            else {
//                last character was ']', so go further
                index++;
//                case if there were no delimiter passed
                if (index < numbersStr.length() && numbersStr.charAt(index) != '\n') {
                    sum = 0;
                    return sum;
                }
                index++;
                if (delimiter.capacity() == 0) {
                    if (index < numbersStr.length() && numbersStr.charAt(index) == '-') number.append(numbersStr.charAt(index++));
                    while(index < numbersStr.length()) {
                        if (numbersStr.charAt(index) >= '0' && numbersStr.charAt(index) <= '9') number.append(numbersStr.charAt(index++));
//                    sum-value will be as default, that is, 0
                        else {
                            sum = 0;
                            return sum;
                        }
                    }
                    if (!number.toString().equals("") && !number.toString().equals("-")) {
                        if (Integer.parseInt(number.toString()) < 0) throw new NegativesNotAllowedException(String.format("negatives not allowed, passed negatives: [%d]", Integer.parseInt(number.toString())));
                        else if (Integer.parseInt(number.toString()) <= 1000) sum = Integer.parseInt(number.toString());
                    }
                } else {
                    while (index < numbersStr.length()) {
                        if ((numbersStr.charAt(index) >= '0' && numbersStr.charAt(index) <= '9') || (numbersStr.charAt(index) == '-' && number.toString().equals(""))) {
                            number.append(numbersStr.charAt(index));
                            System.out.println(number);
                            if (index + 1 == numbersStr.length()) {
                                if (number.toString().equals("-")) {
                                    sum = 0;
                                    break;
                                }
                                if (Integer.parseInt(number.toString()) < 0) negativeNumbers.add(Integer.parseInt(number.toString()));
                                else if (Integer.parseInt(number.toString()) <= 1000) sum += Integer.parseInt(number.toString());
                                if (negativeNumbers.size() != 0) throw new NegativesNotAllowedException(String.format("negatives not allowed, passed negatives: %s", negativeNumbers));
                            }
                        } else if (!number.toString().equals("")) {
                            if (numbersStr.charAt(index) == delimiter.toString().charAt(0)) {
                                System.out.println("start point of delimiter");
                                index++;
//                                first character of delimiter was checked, so move forward to the second one
                                for (int delimIndex = 1; delimIndex < delim_numb && index < numbersStr.length(); delimIndex++, index++) {
                                    if (numbersStr.charAt(index) != delimiter.charAt(delimIndex)) {
                                        sum = 0;
                                        return sum;
                                    }
                                }
                                System.out.println("delimiter passed successfully");
                                if (index == numbersStr.length() || numbersStr.charAt(index) < '0' || numbersStr.charAt(index) > '9') {
                                    System.out.println("here is a bug!");
                                    sum = 0;
                                    break;
                                }
                                index--;
                                if (number.toString().equals("-")) {
                                    sum = 0;
                                    break;
                                }
                                if (Integer.parseInt(number.toString()) < 0) negativeNumbers.add(Integer.parseInt(number.toString()));
                                else if (Integer.parseInt(number.toString()) <= 1000) sum += Integer.parseInt(number.toString());
                                number.delete(0, number.capacity());
                            } else  if (numbersStr.charAt(index) == '\n') {
                                if (index + 1 == numbersStr.length() || numbersStr.charAt(index + 1) < '0' || numbersStr.charAt(index + 1) > '9') {
                                    sum = 0;
                                    break;
                                }
                                if (number.toString().equals("-")) {
                                    sum = 0;
                                    break;
                                }
                                if (Integer.parseInt(number.toString()) < 0) negativeNumbers.add(Integer.parseInt(number.toString()));
                                else if (Integer.parseInt(number.toString()) <= 1000) sum += Integer.parseInt(number.toString());
                                number.delete(0, number.capacity());
                            }
                            else {
                                sum = 0;
                                return sum;
                            }
                        }
                        else {
                            System.out.println("buuug");
                            sum = 0;
                            break;
                        }
                        index++;
                    }
                }
            }
        }
        timesCalled++;
        return sum;
    }
}