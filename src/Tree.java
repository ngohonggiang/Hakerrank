import edu.princeton.cs.algs4.Queue;

import java.util.List;
import java.util.Stack;

public class Tree<T> {
    Node root;

    public Tree() {
        root = null;
    }

    static class Node {
        int data;
        Node parent;
        List<Node> children;
        boolean visited;

        public Node(int data, Node parent, List<Node> children) {
            this.data = data;
            this.parent = parent;
            this.children = children;
        }

        @Override
        public String toString() {
            return "Node(" + data + ")";
        }
    }

    static boolean insert(Node root, int parent, int newInt) {
        if (root.data == parent) {
            if (root.children != null) {
                root.children.add(new Node(newInt, root, null));
            } else {
                root.children = List.of(new Node(newInt, root, null));
            }
            return true;
        } else {
            root.children.forEach(x -> insert(x, parent, newInt));
        }
        return true;
    }

    static void delete(Node root, int key) {
        if (root.data == key) {
            if (root.children == null) {
                root.parent.children.remove(root);
            } else {
                root.data = root.children.get(0).data;
                if (root.children.size() == 1) {
                    root.children = null;
                } else {
                    root.children.remove(0);
                }
            }
        } else {
            root.children.forEach(x -> delete(x, key));
        }
    }

    static boolean isBinaryTree(Node root) {

        return false;
    }

    static boolean isBinarySearchTree(Node root) {

        return false;
    }

    static int height(Node root) {
        return 0;
    }


    static void print(Node root) {
        if (root == null) return;

        Queue<Node> queue = new Queue<>();
        queue.enqueue(root);

        while (!queue.isEmpty()) {
            int n = queue.size();
            while (n > 0) {
                Node p = queue.peek();
                queue.dequeue();
                System.out.print(p.data + " ");

                for (int i = 0; i < p.children.size(); i++) {
                    queue.enqueue(p.children.get(i));
                }
                n--;
            }
            System.out.println();
        }
    }

    // postorder ko dung de quy
    // cho nut cha vao
    // peek ra, ktra neu nut cha co con thi push lai vao va them nut con vao stack
    // lap lai neu nut ko co con thi in ra
    public static void postorderNoRecursion(Node root) {
        Stack<Node> stack = new Stack<>();
        stack.push(root);

    }

    public static void preorder(Node root) {
        System.out.println(root + ", ");
        root.children.forEach(Tree::preorder);
    }

    public static void postorder(Node root) {
        root.children.forEach(Tree::postorder);
        System.out.println(root + ", ");
    }
}
