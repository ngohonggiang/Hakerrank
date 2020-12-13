package Stack_Queue;

import java.util.PriorityQueue;
import java.util.Scanner;

public class JesseAndCookies {
    static int cookies(int k, int[] A) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int operations = 0;

        for (int a : A) {
            pq.add(a);
        }

        while (pq.size() > 1) {
            if (pq.peek() >= k) return operations;
            else {
                int cookie1 = pq.poll();
                int cookie2 = pq.poll();
                int newCookie = cookie1 + 2 * cookie2;
                pq.add(newCookie);
                operations++;
            }
        }
        if (pq.size() > 0 && pq.peek() >= k) return operations;
        else return -1;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt(); // so banh
        int k = in.nextInt(); // do ngot
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = in.nextInt();
        }
        System.out.println(cookies(k, a));
    }
}
