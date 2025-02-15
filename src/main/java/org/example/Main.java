package org.example;
import java.util.ArrayList;
import  java.util.Scanner;
import java.util.List;


public class Main {
    public static void main(String[] args) {
        System.out.println("Example 1");
        Scanner scanner = new Scanner(java.lang.System.in);
        System.out.print("n = ");
        int n = scanner.nextInt();
        System.out.println(get_elements(n));
        System.out.println("Example 2");
        String str = "make install";
        System.out.println(reverse_string(str));
        System.out.println("Example 3");
        System.out.print("a = ");
        double a = scanner.nextDouble();
        System.out.print("b = ");
        double b = scanner.nextDouble();
        System.out.print("c = ");
        double c = scanner.nextDouble();
        try {
            List<Double>results = solver(a,b,c);
            System.out.println("Solves: ");
            for (int i=0; i < results.size(); i++)
                System.out.println(String.format("x%d = ", i) + String.valueOf(results.get(i)));
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
        System.out.println("Example 4");
        double sum = 0.25;
        double k = 0.25;
        int nn = 3;
        while (k >= Math.pow(10,-6)) {
            k = func(nn);
            sum += k;
            nn++;
        }
        System.out.println("sum = " + String.valueOf(sum));
        System.out.println("Example 5");
        System.out.print("Input word: ");
        scanner.nextLine();
        String word = scanner.nextLine();
        System.out.println(isPalindrom(word));
    }
    public static String get_elements(int n)
    {
        String res = "";
        for (int i = 1; i < n+1; i++)
        {
            if (i % 5 == 0 && i % 7 == 0)
                res += String.format("%s - fizzbuzz; ", i);
            else if (i%5 == 0)
                res += String.format("%s - fizz; ", i);
            else if (i%7 == 0)
                res += String.format("%s - buzz; ", i);
            else
                res += String.format("%s; ", i);
        }
        return res;
    }
    public static String reverse_string(String str)
    {
        String resultString = "";
        for (int i = str.length()-1; i>=0; i--)
            resultString += str.charAt(i);
        return resultString;
    }
    public static List<Double> solver(double a, double b, double c) throws Exception
    {
        List<Double> res = new ArrayList<>();
        double d = b*b-4*a*c;
        if (Math.abs(a) < Math.pow(10,-20))
            res.add(-c/b);
        else if (Math.abs(d) < Math.pow(10,-20))
            res.add(-b/(2*a));
        else if (d > 0) {
            res.add((-b - Math.sqrt(d)) / (2 * a));
            res.add((-b + Math.sqrt(d)) / (2 * a));
        }
        else
            throw new Exception("No real solves");
        return res;
    }
    public static double func(int n)
    {
        return 1.0/(n*n+n-2);
    }
    public static String isPalindrom(String s)
    {
        String t = s.toLowerCase();
        return t.equals(reverse_string(t)) ? String.format("%s - palindrom", t) : String.format("%s - not palindrom", t);
    }
}