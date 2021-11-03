package StrCalculator;

public class Main {
    public static void main (String[] args) {
        StringCalculator test = new StringCalculator();
        String a = "1";
        String b = "1,2";
        String c = "4,5,6";
        String d = "@59";
        String e = "";
        String f = "9,4\n6";
        String g = "2\n5\n5";
        String h = "1,\n3";
        String i = "3,\n";
        String j = ",";
        String k = "\n";
        System.out.println("\""+ a +"\"" + ": " + test.add(a));
        System.out.println("\""+ b +"\"" + ": " + test.add(b));
        System.out.println("\""+ c +"\"" + ": " + test.add(c));
        System.out.println("\""+ d +"\"" + ": " + test.add(d));
        System.out.println("\""+ e +"\"" + ": " + test.add(e));
        System.out.println("\""+ f +"\"" + ": " + test.add(f));
        System.out.println("\""+ g +"\"" + ": " + test.add(g));
        System.out.println("\""+ h +"\"" + ": " + test.add(h));
        System.out.println("\""+ i +"\"" + ": " + test.add(i));
        System.out.println("\""+ j +"\"" + ": " + test.add(j));
        System.out.println("\""+ k +"\"" + ": " + test.add(k));
    }
}