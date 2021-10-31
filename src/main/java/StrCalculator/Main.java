package StrCalculator;

public class Main {
    public static void main (String args[]) {
        StringCalculator c = new StringCalculator();
        System.out.println("String: " + "" + " -> " + c.add(""));
        System.out.println("String: " + "1" + " -> " + c.add("1"));
        System.out.println("String: " + "3,7" + " -> " + c.add("3,7"));
        System.out.println("String: " + "9,3,5" + " -> " + c.add("9,3,5"));
        System.out.println("String: " + "1,n" + " -> " + c.add("1,n"));
        System.out.println("String: " + "*,2" + " -> " + c.add("*,2"));
    }
}