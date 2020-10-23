package Java;

import java.util.Scanner;

public class SubstringComparisions {
    /*public static String getSmallestAndLargest(String s, int k) {
        String smallest = "";
        String largest = "";
        SortedSet<String> treeSet = new TreeSet<String>();

        for (int i = 0; i < s.length() - k + 1; i++) {
            treeSet.add(s.substring(i, i + k));
        }

        smallest = treeSet.first();
        largest = treeSet.last();

        return smallest + "\n" + largest;
    }*/

    public static String getSmallestAndLargest(String s, int k) {
        String smallest = s.substring(0, k);
        String largest = "";

        for (int i = 0; i < s.length() - k + 1; i++) {
            if (s.substring(i, i + k).compareTo(smallest) < 0) {
                smallest = s.substring(i, i + k);
            }
            if (s.substring(i, i + k).compareTo(largest) > 0) {
                largest = s.substring(i, i + k);
            }
        }

        return smallest + "\n" + largest;
    }


    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String s = scan.next();
        int k = scan.nextInt();
        scan.close();

        System.out.println(getSmallestAndLargest(s, k));
    }
}
