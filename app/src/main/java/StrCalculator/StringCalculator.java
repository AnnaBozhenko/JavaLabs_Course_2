package  StrCalculator;

public class StringCalculator {

    public int add(String numbersStr) throws NegativesNotAllowedException {
        int sum = 0;
        StringBuilder num = new StringBuilder(numbersStr.length());
        char[] numbersArr = numbersStr.toCharArray();
        if (numbersArr[0] == '/' && numbersArr[1] == '/' && numbersArr[3] == '\n') {
            char delimiter = numbersArr[2];
            for (int i = 4; i < numbersArr.length; i++) {
                if ((numbersArr[i] >= '0' && numbersArr[i] <= '9') || (numbersArr[i] == '-' && num.toString().equals(""))) {
                    num.append(numbersArr[i]);
                    if (i + 1 == numbersArr.length) {
                        if (num.toString().equals("-")) {
                            sum = 0;
                            break;
                        } else if (Integer.parseInt(num.toString()) < 0) {
                            throw new NegativesNotAllowedException(String.format("negatives not allowed, passed number: %d", Integer.parseInt(num.toString())));
                        }
                        sum += Integer.parseInt(num.toString());
                    }
                } else if (numbersArr[i] == delimiter || numbersArr[i] == '\n' && !num.toString().equals("")) {
                    if (i + 1 == numbersArr.length || numbersArr[i + 1] == delimiter || numbersArr[i + 1] == '\n') {
                        sum = 0;
                        break;
                    } else {
                        if (num.toString().equals("-")) {
                            sum = 0;
                            break;
                        } else if (Integer.parseInt(num.toString()) < 0) {
                            throw new NegativesNotAllowedException(String.format("negatives not allowed, passed number: %d", Integer.parseInt(num.toString())));
                        }
                        sum += Integer.parseInt(num.toString());
                        num.delete(0, num.capacity() - 1);
                    }
                } else {
                    sum = 0;
                    break;
                }
            }
        }
        return sum;
    }
}