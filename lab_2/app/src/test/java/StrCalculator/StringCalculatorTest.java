package  StrCalculator;


import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculatorTest {

    static int timesCalled;
    public StringCalculatorTest() {
        timesCalled = 0;
    }

    public int GetCalledCount() {
        return timesCalled;
    }

    public int borderIndex(String source) {
        /*source - string that is considered to divide;
        * returns number of indices to come through to divide source on two parts:
        1st) delimiters' part according to plate: "//[...]...[...]/n"
        * 2nd) countable part - the rest substring;
        * if no  delimiter part was found, returns -1.*/
        String delimPart = "(//\\[.*?]\n)+";
        Pattern p = Pattern.compile(delimPart);
        Matcher m = p.matcher(source);
        if (m.lookingAt()) {
            return m.group().length();
        }
        else{
            return -1;
        }
    }


    public int borderIndex1(String source) {
        if (source.length() > 2 && source.charAt(0) == '/' && source.charAt(1) == '/') {
            boolean openBracket = false;
            for (int border_i = 2; border_i < source.length(); border_i++) {
                if (openBracket) {
                    if (source.charAt(border_i) == ']') openBracket = false;
                }
                else {
                    if (source.charAt(border_i) == '[') openBracket = true;
                    else if (source.charAt(border_i) == '\n') {
                        return border_i + 1;
                    }
                    else return -1;
                }
            }
        }
        return -1;
    }


    public ArrayList<String> defineDelimiters(String source, int upperIndex) {
//        source - string; upperIndex - index number of source's element, upperIndex < source's length;
//        returns array of delimiters passed to the source;
        ArrayList<String> delimiters = new ArrayList<>();
        StringBuilder delim = new StringBuilder();
        for (int i = 2; i < upperIndex; i++) {
            if (source.charAt(i) == '[') {
                continue;
            } else if (source.charAt(i) == ']') {
                if (!delim.toString().equals("")) {
                    delimiters.add(delim.toString());
                    delim.delete(0, delim.capacity());
                }
            } else if (source.charAt(i) == '\n') {
                delimiters.add("\n");
            }
            else delim.append(source.charAt(i));
        }
        return delimiters;
    }


    public int checkIfContainsDelimiter(ArrayList<String> delimiterArr, String strToCheck, int index_str) {
        /*delimiterArr - array of strings, each string is a delimiter; strToCheck - analyzable string,
         * which is checked, starting at given index - index_str, for containing one of the given delimiters.
         * if substring starting from given index equals to one of the delimiters, then return index
         * of strToCheck, got after passing the delimiter.*/
        String partOfStr;
        for (String delimiter : delimiterArr) {
            if (delimiter.length() <= strToCheck.length() - index_str) {
                partOfStr = strToCheck.substring(index_str, index_str + delimiter.length());
                if (delimiter.equals(partOfStr)) {
                    return index_str + delimiter.length();
                }
            }
        }
        return -1;
    }


    public int add(String sourceStr) throws NegativesNotAllowedException {
        timesCalled++;
        int sum = 0;
        int border_i = borderIndex1(sourceStr);
//        if string doesn't satisfy pattern of delimiters passing
        if (border_i == -1) return sum;
        ArrayList<String> delimiters = defineDelimiters(sourceStr, border_i);
        StringBuilder number = new StringBuilder(0);
        ArrayList<String> negatives = new ArrayList<>(0);
        for (int i = border_i; i < sourceStr.length(); i++) {
            if (sourceStr.charAt(i) >= '0' && sourceStr.charAt(i) <= '9' || (sourceStr.charAt(i) == '-' && number.toString().equals(""))) {
                number.append(sourceStr.charAt(i));
                if (i + 1 == sourceStr.length()) {
                    if (number.toString().equals("-")) return 0;
                    else {
                        if (Integer.parseInt(number.toString()) < 0) negatives.add(number.toString());
                        else if (Integer.parseInt(number.toString()) <= 1000) sum += Integer.parseInt(number.toString());
                    }
                    if (negatives.size() != 0)
                        throw new NegativesNotAllowedException(String.format("Negatives not allowed, passed negatives: %s", negatives));
                }
            }
            else if (!number.toString().equals("")) {
                // check if next characters form delimiter
                i = checkIfContainsDelimiter(delimiters, sourceStr, i);
//                no delimiters pattern was found;
                if (i == -1) return 0;
                else {
//                check if there are no repeating delimiters
                    if (i < sourceStr.length()) {
                        if (sourceStr.charAt(i) >= '0' && sourceStr.charAt(i) <= '9' || sourceStr.charAt(i) == '-') {
                            if (number.toString().equals("-")) return 0;
                            else {
                                if (Integer.parseInt(number.toString()) < 0) negatives.add(number.toString());
                                else if (Integer.parseInt(number.toString()) <= 1000) sum += Integer.parseInt(number.toString());
                                number.delete(0, number.capacity());
//                                return to the previous position because in the loop 'i' will be increased
                                i--;
                            }
                        }
                        else return 0;
                    }
                    else return 0;
                }
            }
            else return 0;
        }
        return sum;
    }

}