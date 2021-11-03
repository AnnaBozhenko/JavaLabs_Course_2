package StrCalculator;

public class Main {
    public static void main (String[] args) {
        StringCalculator test = new StringCalculator();
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