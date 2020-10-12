package Algorithms;

import java.util.Arrays;
import java.util.Scanner;

public class closetNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] a = new int[n];
        int[] b = new int[2*n];
        int min = Integer.MAX_VALUE;
        int k = 0;

        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        Arrays.sort(a);
        for (int i = 0; i < n-1; i++) {
            if (min == a[i+1] - a[i]) {
                b[k++] = a[i];
                b[k++] = a[i+1];
            } else if (min > a[i+1] - a[i]) {
                k = 0;
                b[k++] = a[i];
                b[k++] = a[i+1];
                min = a[i+1] - a[i];
            }
        }
        for(int i = 0; i < k; i++)
            System.out.print(b[i]+" ");
    }
}

