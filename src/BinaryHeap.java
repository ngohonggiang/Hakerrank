public class BinaryHeap<Key extends Comparable<Key>> {
    private Key[] pq;
    private int n;

    public BinaryHeap(int capacity) {
        pq = (Key[]) new Comparable[capacity];
    }

    public boolean isEmpty() {
        return n == 0;
    }

    public void insert(Key x) {
        pq[++n] = x;
        swim(n);
    }

    public Key delMax() {
        Key max = pq[1];
        swap(1, n--);
        sink(1);
        pq[n + 1] = null;
        return max;
    }

    private void swim(int k) {
        while (k > 1 && less(k / 2, k)) {
            swap(k, k / 2);
            k = k / 2;
        }
    }

    private void sink(int k) {
        while (2 * k <= n) {
            int j = 2 * k;
            if (j < n && less(j, j + 1)) j++;
            if (!less(k, j)) break;
            swap(k, j);
            k = j;
        }
    }

    private boolean less(int i, int j) {
        return pq[i].compareTo(pq[j]) < 0;
    }

    private void swap(int i, int j) {
        Key t = pq[i]; pq[i] = pq[j]; pq[j] = t;
    }
}
