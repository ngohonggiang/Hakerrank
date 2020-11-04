package Sort;

import edu.princeton.cs.algs4.StdRandom;

public class QuickSort_3_Way {
    private static void swap(Comparable[] a, int i, int j) {
        Comparable tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }

    private static void sort(Comparable[] a, int lo, int hi) {
        if (hi <= lo) return;
        int lt = lo, gt = hi;
        Comparable v = a[lo];
        int i = lo;
        while (i <= gt) {
            int cmp = a[i].compareTo(v);
            if (cmp < 0) swap(a, i++, lt++); // < v, exchange, increase i, lt
            else if (cmp > 0) swap(a, i, gt--); // > v, exchange, decrease gt
            else i++; // =v, increase i
        }
        sort(a, lo, lt - 1);
        sort(a, gt + 1, hi);
    }

    public static void sort(Comparable[] a) {
        StdRandom.shuffle(a);
        sort(a, 0, a.length - 1);
    }

    public static void printArr(Comparable[] a) {
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");;
        }
        System.out.println("");
    }

    public static void main(String[] args) {
        Integer[] a = {24, 30, 12, 16, 5, 32, 1, 8};
        sort(a);
        printArr(a);
    }
}
