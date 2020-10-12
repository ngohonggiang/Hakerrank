package Stack_Queue;

import java.util.Scanner;
import java.util.Stack;

public class EqualStacks {
    // stack
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n1 = in.nextInt();
        int n2 = in.nextInt();
        int n3 = in.nextInt();
        int m1 = 0, m2 = 0, m3 = 0;

        Stack<Integer> st1 = new Stack<Integer>();
        Stack<Integer> st2 = new Stack<Integer>();
        Stack<Integer> st3 = new Stack<Integer>();

        int[] arr1 = new int[n1];
        int[] arr2 = new int[n2];
        int[] arr3 = new int[n3];

        for (int i = 0; i < n1; i++) {
            int x = in.nextInt();
            arr1[i] = x;
            m1 += x;
        }
        for (int i = n1 - 1; i >=0; i--) {
            st1.push(arr1[i]);
        }

        for (int i = 0; i < n2; i++) {
            int x = in.nextInt();
            arr2[i] = x;
            m2 += x;
        }
        for (int i = n2 - 1; i >=0; i--) {
            st2.push(arr2[i]);
        }

        for (int i = 0; i < n3; i++) {
            int x = in.nextInt();
            arr3[i] = x;
            m3 += x;
        }
        for (int i = n3 - 1; i >=0; i--) {
            st3.push(arr3[i]);
        }

        if (m1 == m2 && m2 == m3) {
            System.out.println(m1);
            return;
        }

        while (!(m1 == m2 && m2 == m3)) {
            if (m1 > m2 || m1 > m3) {
                while (m1 > m2 || m1 > m3) {
                    m1 -= st1.peek();
                    st1.pop();
                }
            } else if (m2 > m1 || m2 > m3) {
                while (m2 > m1 || m2 > m3) {
                    m2 -= st2.peek();
                    st2.pop();
                }
            } else if (m3 > m1 || m3 > m2) {
                while (m3 > m1 || m3 > m2) {
                    m3 -= st3.peek();
                    st3.pop();
                }
            }
        }

        System.out.println(m1);
    }

    // array
    /*public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n1 = in.nextInt();
        int n2 = in.nextInt();
        int n3 = in.nextInt();
        int m1 = 0, m2 = 0, m3 = 0;

        int[] arr1 = new int[n1];
        int[] arr2 = new int[n2];
        int[] arr3 = new int[n3];

        for (int i = 0; i < n1; i++) {
            arr1[i] = in.nextInt();
            m1 += arr1[i];
        }

        for (int i = 0; i < n2; i++) {
            arr2[i] = in.nextInt();
            m2 += arr2[i];
        }

        for (int i = 0; i < n3; i++) {
            arr3[i] = in.nextInt();
            m3 += arr3[i];
        }

        if (m1 == m2 && m2 == m3) {
            System.out.println(m1);
            return;
        }

        int i = 0, j = 0, k = 0;
        while (!(m1 == m2 && m2 == m3)) {
            if (m1 > m2 || m1 > m3) {
                while (m1 > m2 || m1 > m3) {
                    m1 -= arr1[i++];
                }
            } else if (m2 > m1 || m2 > m3) {
                while (m2 > m1 || m2 > m3) {
                    m2 -= arr2[j++];
                }
            } else if (m3 > m1 || m3 > m2) {
                while (m3 > m1 || m3 > m2) {
                    m3 -= arr3[k++];
                }
            }
        }

        System.out.println(m1);
    }*/
}
