import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class BinarySearch {
    /*int binarySearch(int arr[], int low, int high, int value) {
        if (low <= high) {
            int mid = low + (high - low)/2;
            if (arr[mid] == value) return mid + 1;
            if (arr[mid] > value) return binarySearch(arr, low, mid - 1, value);
            if (arr[mid] < value) return binarySearch(arr, mid + 1, high, value);
        }
        return -1;
    }*/
    int binarySearch(int[] arr, int x) {
        int n = arr.length;
        int l = arr[0];
        int r = arr[n-1];
        while (l <= r) {
            int mid = l + (r-l)/2;
            if (arr[mid] == x) return mid;
            else if (arr[mid] > x) r = mid - 1;
            else l = mid + 1;
        }
        return -1;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        int value = scanner.nextInt();
        Arrays.sort(arr);
        BinarySearch bs = new BinarySearch();
        System.out.println(bs.binarySearch(arr, value));
    }
}



