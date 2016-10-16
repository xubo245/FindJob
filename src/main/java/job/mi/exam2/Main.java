package job.mi.exam2;//package main
//注意不要添加包名称，否则会报错。

import java.util.ArrayList;
import java.util.Scanner;

class Test {
}

public class Main {
    public static void main(String args[]) {
        Scanner cin = new Scanner(System.in);
        while (cin.hasNextInt()) {
            int n = cin.nextInt();
            Node node = null;
            for (int i = 0; i < n; i++) {
                int a = cin.nextInt();
                int b = cin.nextInt();
                if (i == 0) {
                    node = new Node(a, 1);
                    node.list.add(new Node(b, 2));
                } else {
                    insertTree(node, a, b);
                }
            }
            int max = 0;
            max = findMax(node);
            System.out.println(max);

        }
    }

    public static int findMax(Node node) {
        int max = 0;
        if (node.left == null) {
            if (node.right == null) {
                if (max < node.high) {
                    max = node.high;
                }
            } else {
                int high = findMax(node.right);
                if (max < high) {
                    max = high;
                }
            }
        } else {
            int high = findMax(node.left);
            if (max < high) {
                max = high;
            }
            if (node.right != null) {
                int high1 = findMax(node.right);
                if (max < high1) {
                    max = high1;
                }
            }
        }
        return max;

    }

    public static boolean insertTree(Node node, int a, int b) {
        if (node == null) {
            return false;
        }
        if (node.value == a) {
            if (node.left == null) {
                node.left = new Node(b, node.high + 1);
            } else {
                node.right = new Node(b, node.high + 1);
            }
        } else {
            if (insertTree(node.left, a, b) == false) {
                return insertTree(node.right, a, b);
            }
        }
        return false;
    }
}

class Node {
    int value;
    int high;
    Node left;
    Node right;
    ArrayList<Node> list = new ArrayList<Node>();

    public Node(int value, int high) {
        this.value = value;
        this.high = high;
    }
}
