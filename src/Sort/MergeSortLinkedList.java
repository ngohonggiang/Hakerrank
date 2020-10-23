package Sort;

import java.util.Scanner;

public class MergeSortLinkedList {
    node head = null;
    static class node {
        int val;
        node next;

        public node(int val) {
            this.val = val;
        }
    }

    node sort(node a, node b) {
        node result;
        if (a == null) return b;
        if (b == null) return a;
        if (a.val <= b.val) {
            result = a;
            result.next = sort(a.next, b);
        } else {
            result = b;
            result.next = sort(a, b.next);
        }
        return result;
    }

    node mergeSort(node h) {
        if (h == null || h.next == null) return h;

        node middle = getMiddle(h);
        node nextToMid = middle.next;

        middle.next = null;

        node left = mergeSort(h);

        node right = mergeSort(nextToMid);

        node sortedlist = sort(left, right);
        return sortedlist;
    }

    public static node getMiddle(node head) {
        if (head == null) return head;

        node slow = head;
        node fast = head;

        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    void addNode(int new_data) {
        node new_node = new node(new_data);
        new_node.next = head;
        head = new_node;
    }

    void printList(node head) {
        node p = head;
        while (p != null) {
            System.out.print(p.val + " ");
            p = p.next;
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        MergeSortLinkedList list = new MergeSortLinkedList();

        for (int i = 0; i < 10; i++) {
            list.addNode(in.nextInt());
        }

        list.head = list.mergeSort(list.head);
        list.printList(list.head);
    }
}