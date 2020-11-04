package Sort;

import java.util.Scanner;

public class QuickSortInPlace {
    private static boolean less(Comparable a, Comparable b) {
        return a.compareTo(b) < 0;
    }

    private static void swap(Comparable[] a, int i, int j) {
        Comparable tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }

    public static int partition(Comparable[] a, int lo, int hi) {
        Comparable pivot = a[hi];
        int index = lo;
        for (int i = lo; i < hi; i++) {
            if (less(a[i], pivot)) {
                swap(a, i, index);
                index++;
            }
        }
        swap(a, index, hi);
        return index;
    }

    private static void sort(Comparable[] a, int lo, int hi) {
        if (lo < hi) {
            int j = partition(a, lo, hi);
            printArr(a);
            sort(a, lo, j - 1);
            sort(a, j + 1, hi);
        }
    }

    public static void printArr(Comparable[] a) {
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");;
        }
        System.out.println("");
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        Integer[] a = new Integer[n];
        for (int i = 0; i < n; i++) {
            a[i] = in.nextInt();
        }
        sort(a, 0, n - 1);
    }
}
