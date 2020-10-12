package Stack_Queue;

import java.util.Stack;

public class TwoStacksQueue {
    public static class MyQueue1<T> {
        Stack<T> stack1 = new Stack<>();
        Stack<T> stack2 = new Stack<>();

        public void enqueue(T num) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
            stack1.push(num);
            while (!stack2.empty()) {
                stack1.push(stack2.pop());
            }
        }

        public void dequeue() {
            stack1.pop();
        }

        public T peek() {
            return stack1.peek();
        }
    }

    public static class MyQueue2<T> {
        Stack<T> stack1 = new Stack<>();
        Stack<T> stack2 = new Stack<>();

        public void enqueue(T num) {
            stack1.push(num);
        }

        public void dequeue() {
            while (stack2.isEmpty()) {
                while (!stack1.isEmpty()) {
                    stack2.push(stack1.pop());
                }
            }
            stack2.pop();
        }

        public T peek() {
            if (stack2.isEmpty()) {
                while (!stack1.isEmpty()) {
                    stack2.push(stack1.pop());
                }
            }
            return stack2.peek();
        }
    }
}