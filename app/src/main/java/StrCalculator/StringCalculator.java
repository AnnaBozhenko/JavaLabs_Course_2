package StrCalculator;

public class StringCalculator {
    public int add(String numbersStr) {
        int sum = 0;
        byte numbOfSummarands = 0;
        String numb = "";
        char[] symbols = numbersStr.toCharArray();
        for (int i = 0; i < symbols.length; i++) {
            if (symbols[i] >= '0' && symbols[i] <= '9') {
                numb += symbols[i];
                if (i + 1 == symbols.length) {
                    sum += Integer.parseInt(numb);
                }
            }
            else if ((symbols[i] == ',' && !numb.equals(""))) {
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