package StrCalculator;

class StringTool {
    static String rowStr(String source) {
        /*source - string that can contain special characters (newline char and tabulation)
        which need to be turned into non-special;
        returns String with turned above-mentioned special characters to non-special.*/
        StringBuilder result = new StringBuilder();
        for (char c: source.toCharArray()) {
           switch (c) {
               case '\n':
                   result.append("\\n");
                   break;
               case '\t':
                   result.append("\\t");
                   break;
               default:
                   result.append(c);
           }
        }
        return result.toString();
    }
}


public class Main {
    public static void main (String[] args) {
        StringCalculator A = new StringCalculator();
        String source = "//[$]\n4$5$6";
        try {
            System.out.println("----------------------");
            System.out.printf("Entered: %s%n",StringTool.rowStr(source));
            System.out.printf("Calculated: %d%n", A.add(source));
            System.out.println("----------------------");
        } catch (NegativesNotAllowedException e) {
            e.printStackTrace();
        }
    }
}