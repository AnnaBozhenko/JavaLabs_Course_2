package StrCalculator;

public class StringCalculator {
    public int Add (String[] numbers) {
        int sum = 0;
        String numb = "";
        char[] numbsArr = numbers.toCharArray();
        for (char symb: numbsArr) {
            if (symb >= '0' && symb <= 9) {
                numb += symb;
            }
            else if (symb == ',') {
                sum +=
            }
        }
        return sum;
    }
}