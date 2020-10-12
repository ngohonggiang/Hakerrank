package Stack_Queue;

import java.util.Scanner;
import java.util.Stack;

public class QueueUsingTwoStacks {
    // stack
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int q = scanner.nextInt();

        Stack<Integer> one = new Stack<Integer>();
        Stack<Integer> two = new Stack<Integer>();

        for (int i = 0; i < q; i++) {
            int type = scanner.nextInt();
            if (type == 1) {
                int x = scanner.nextInt();
                two.push(x);
            } else {
                if (one.isEmpty()) {
                    // move all elements from "two" -> "one"
                    while (!two.isEmpty()) {
                        one.push(two.peek());
                        two.pop();
                    }
                }
                if (!one.isEmpty()) {
                    if (type == 2) one.pop();
                    if (type == 3) System.out.println(one.peek());
                }
            }
        }
    }

    // queue
    /*public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int q = scanner.nextInt();
        Queue<Integer> queue = new Queue<Integer>();

        for (int i = 0; i < q; i++) {
            int type = scanner.nextInt();
            if (type == 1) {
                int x = scanner.nextInt();
                queue.enqueue(x);
            } else if (type == 2) {
                queue.dequeue();
            } else if (type == 3) {
                System.out.println(queue.peek());
            }
        }
    }*/
}
