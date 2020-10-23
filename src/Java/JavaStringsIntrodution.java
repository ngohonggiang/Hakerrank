package Java;

import java.util.Scanner;

public class JavaStringsIntrodution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        String A = in.next();
        String B = in.next();

        System.out.println(A.length() + B.length());

        if (A.charAt(0) <= B.charAt(0)) System.out.println("No");
        else System.out.println("Yes");

        String tmpA = A.substring(0, 1).toUpperCase() + A.substring(1);
        String tmpB = B.substring(0, 1).toUpperCase() + B.substring(1);
        System.out.println(tmpA + " " + tmpB);
    }
}
