package  StrCalculator;

public class StringCalculatorTest {

    public int add(String numbersStr) {
        StringBuilder num = new StringBuilder(numbersStr.length());
        int sum = 0;
        char[] numbersArr = numbersStr.toCharArray();
        if (numbersArr[0] == '/' && numbersArr[1] == '/' && numbersArr[3] == '\n') {
            char delimiter = numbersArr[2];
            for (int i = 4; i < numbersArr.length; i++) {
                if (numbersArr[i] >= '0' && numbersArr[i] <= '9') {
                    num.append(numbersArr[i]);
                    if (i + 1 == numbersArr.length) {
                        sum += Integer.parseInt(num.toString());
                    }
                }
                else if (numbersArr[i] == delimiter || numbersArr[i] == '\n' && num.capacity() != 0) {
                    if (i + 1 == numbersArr.length || numbersArr[i + 1] == delimiter || numbersArr[i + 1] == '\n') {
                        sum = 0;
                        break;
                    }
                    else {
                        sum += Integer.parseInt(num.toString());
                        num.delete(0, num.capacity() - 1);
                    }
                }
                else {
                    sum = 0;
                    break;
                }
            }
        }
        return sum;
    }
}