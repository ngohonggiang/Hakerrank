package Algorithms;

import java.util.Arrays;
import java.util.Scanner;

public class Pairs {
    static int pairs(int k, int[] a) {
        Arrays.sort(a);
        int n = a.length;
        int count = 0, i = 0, j = 1;
        while (j < n) {
            int tmp = a[j] - a[i];
            if (tmp == k) {
                count++;
                j++;
            } else if (tmp > k) i++;
            else j++;
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int k = in.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }

        System.out.println(pairs(k, arr));
    }
}
