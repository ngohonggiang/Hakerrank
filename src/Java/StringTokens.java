package Java;

import java.util.Scanner;

public class StringTokens {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();

        // trim() eliminate leading and trailing spaces of string
        if (s.trim().length() == 0 || s.trim().length() > 400000) {
            System.out.println(0);
            return;
        }

        String[] tokens = s.trim().split("[ !,?.\\_'@]+");

        System.out.println(tokens.length);
        for (String token:tokens) {
            System.out.println(token);
        }
    }
}
