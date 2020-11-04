package Sort;

public class InsertionSort {
    private static boolean less(Comparable a, Comparable b) {
        return a.compareTo(b) < 0;
    }

    private static void swap(Comparable[] a, int i, int j) {
        Comparable tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }

    public static void  sort(Comparable[] a) {
        int n = a.length;
        for (int i = 0; i < n; i++) {
            for (int j = i; j > 0; j--) {
                if (less(a[j], a[j - 1])) swap(a, j, j - 1);
            }
        }
    }

    public static void main(String[] args) {
        Integer[] a = {24, 30, 12, 16, 5, 0, 32, 1, 8};
        sort(a);
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
    }
}
