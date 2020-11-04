package Sort;

public class HeapSort {
    private static boolean less(Comparable[] a, int i, int j) {
        return a[i].compareTo(a[j]) < 0;
    }

    private static void swap(Comparable[] a, int i, int j) {
        Comparable tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }

    private static void sink(Comparable[] a, int k, int n) {
        int largest = k;
        int left = 2 * k + 1;
        int right = 2 * k + 2;

        if (left < n && less(a, largest, left)) largest = left;
        if (right < n && less(a, largest, right)) largest = right;

        if (largest != k) {
            swap(a, k, largest);
            sink(a, largest, n);
        }
    }

    public static void sort(Comparable[] a) {
        int n = a.length;
        for (int k = n / 2 - 1; k >= 0; k--) {
            sink(a, k, n);
        }

        for (int i = n - 1; i > 0; i--) {
            swap(a, 0, i);
            sink(a, 0, i);
        }
    }

    public static void main(String[] args) {
        Integer[] a = {24, 30, 12, 16, 5, 32, 1, 8};
        sort(a);
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");;
        }
    }
}
