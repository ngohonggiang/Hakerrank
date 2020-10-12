package Stack_Queue;

import edu.princeton.cs.algs4.Stack;
import java.util.Scanner;

public class Balanced_Brackets {
    // not using stack
    /*public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int t = -1;
        scanner.nextLine();
        for (int i = 0; i < n; i++) {
            String s = scanner.nextLine();
            while (s.length() != t) {
                t = s.length();
                s = s.replace("()", "");
                s = s.replace("[]", "");
                s = s.replace("{}", "");
            }
            if (s.length() == 0) System.out.println("YES");
            else System.out.println("NO");
        }
    }*/

    // using stack
    static String isBalanced(String s) {
        Stack<Character> stack = new Stack<Character>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            switch (c) {
                case '{':
                case '[':
                case '(':
                    stack.push(c);
                    break;
                case '}':
                    if (stack.isEmpty() || stack.peek() != '{') return "NO";
                    stack.pop();
                    break;
                case ']':
                    if (stack.isEmpty() || stack.peek() != '[') return "NO";
                    stack.pop();
                    break;
                case ')':
                    if (stack.isEmpty() || stack.peek() != '(') return "NO";
                    stack.pop();
                    break;
            }
        }
        return stack.isEmpty()? "YES" : "NO";
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.nextLine();
        for (int i = 0; i < n; i++) {
            String str = scanner.nextLine();
            System.out.println(isBalanced(str));
        }
    }
}

