package Sort;

public class InsertionSort1 {
    static void insertionSort1(int n, int[] arr) {
        int last = arr[n - 1], i = n - 2;
        while (i >= 0 && last < arr[i]) {
            arr[i + 1] = arr[i--];
            printArray(arr);
        }
        arr[i + 1] = last;
        printArray(arr);
    }

    static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println("");
    }

    public static void main(String[] args) {
        int[] arr = new int[] {1, 2, 3, 4, 5, 6, 7, 0};
        insertionSort1(8, arr);
    }
}