package Sort;

public class InsertionSort2 {
    static void insertionSort2(int n, int[] arr) {
        for (int i = 2; i <= n; i++) {
            insertionSort1(i, arr);
        }
    }

    static void insertionSort1(int n, int[] arr) {
        int last = arr[n-1];
        int i = n-2;
        while (i >= 0 && last < arr[i]) {
            arr[i+1] = arr[i--];
        }
        arr[i+1] = last;
        printArray(arr);
    }

    static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println("");
    }

    public static void main(String[] args) {
        int[] arr = new int[] {1, 4, 3, 5, 6, 2};
        insertionSort2(6, arr);
    }
}
