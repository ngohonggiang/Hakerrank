package Sort;

public class MergeSortBottomUp {
    private static boolean less(Comparable a, Comparable b) {
        return a.compareTo(b) < 0;
    }

    private static void merge(Comparable[] a, Comparable[] aux,
                              int lo, int mid, int hi) {
        for (int k = lo; k <= hi; k++) {
            aux[k] = a[k];
        }

        int i = lo, j = mid + 1;
        for (int k = lo; k <= hi; k++) {
            if (i > mid) a[k] = aux[j++];
            else if (j > hi) a[k] = aux[i++];
            else if (less(a[j], a[i])) a[k] = aux[j++];
            else a[k] = aux[i++];
        }
    }

    public static void sort(Comparable[] a) {
        int n = a.length;
        Comparable[] aux = new Comparable[n];
        for (int sz = 1; sz < n; sz += sz) {
            for (int lo = 0; lo < n - sz; lo += sz + sz) {
                merge(a, aux, lo, lo + sz - 1, Math.min(lo + sz - 1, n - 1));
            }
        }
    }

    public static void main(String[] args) {
        Integer[] a = {24, 30, 12, 16, 5, 32, 1, 8};
        sort(a);
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
    }
}
