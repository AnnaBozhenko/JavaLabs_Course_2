package StrCalculator;

public class StringCalculator {
    public int add(String numbersStr) {
        int sum = 0;
        String numb = "";
        char[] symbols = numbersStr.toCharArray();
        for (int i = 0; i < symbols.length; i++) {
            if (symbols[i] >= '0' && symbols[i] <= '9') {
                numb += symbols[i];
                if (i + 1 == symbols.length) {
                    sum += Integer.parseInt(numb);
                }
            }
            else if ((symbols[i] == ',' || symbols[i] == '\n') && !numb.equals("")) {
//                check if there is no following symbol (invalid format)
//                check if the following symbol is not a repeated comma or newline char (invalid format)
                if (i + 1 == symbols.length || (symbols[i + 1] == '\n' || symbols[i + 1] == ',')) break;
                else {
                    sum += Integer.parseInt(numb);
                    numb = "";
                }
            }
            else break;
        }
        return sum;
    }
}