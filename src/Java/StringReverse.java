package Java;

import java.util.Scanner;

public class StringReverse {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        String A = in.next();
        String reverseA = "";

        for (int i = A.length() - 1; i >= 0; i--) {
            reverseA += A.charAt(i);
        }

        if (reverseA.equals(A)) System.out.println("Yes");
        else System.out.println("No");
    }
}
