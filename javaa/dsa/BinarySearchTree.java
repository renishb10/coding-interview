package javaa.dsa;

import java.util.LinkedList;
import java.util.Queue;

public class BinarySearchTree {
    class Node {
        int data;
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    public Node root = null;

    public void insert(int data) {
        Node newNode = new Node(data);

        // If empty set it as root node
        if (root == null) {
            root = newNode;
        } else {
            Node currNode = root;
            while (true) {
                if (data < currNode.data) {
                    // Left
                    if (currNode.left == null) { // Looking for leaf node
                        currNode.left = newNode;
                        return;
                    }
                    currNode = currNode.left;
                } else {
                    // Right
                    if (currNode.right == null) {
                        currNode.right = newNode;
                        return;
                    }
                    currNode = currNode.right;
                }
            }
        }

    }

    public void lookup(int data) {
        if (root == null) {
            System.out.println("Tree is empty!");
            return;
        }

        Node currNode = root;
        while (currNode != null) {

            if (data < currNode.data) {
                currNode = currNode.left;
            } else if (data > currNode.data) {
                currNode = currNode.right;
            } else {
                System.out.println("Found value!");
                return;
            }
        }

        System.out.println("Value not found!");
    }

    public void printTree() {
        printInOrder(root);
    }

    public void printInOrder(Node node) {
        if (node != null) {
            printInOrder(node.left); // Visit left subtree
            System.out.print(node.data + " "); // Visit node
            printInOrder(node.right); // Visit right subtree
        }
    }

    public void printPreOrder(Node node) {
        if (node != null) {
            System.out.print(node.data + " "); // Visit node
            printInOrder(node.left); // Visit left subtree
            printInOrder(node.right); // Visit right subtree
        }
    }

    public void printPostOrder(Node node) {
        if (node != null) {
            printInOrder(node.left); // Visit left subtree
            printInOrder(node.right); // Visit right subtree
            System.out.print(node.data + " "); // Visit node
        }
    }

    public void breadthFirstSearch(Node root) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            Node currentNode = queue.poll();
            System.out.print(currentNode.data + " ");

            if (currentNode.left != null) {
                queue.add(currentNode.left);
            }

            if (currentNode.right != null) {
                queue.add(currentNode.right);
            }
        }
    }

    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();
        bst.insert(9);
        bst.insert(4);
        bst.insert(6);
        bst.insert(20);
        bst.insert(170);
        bst.insert(15);
        bst.insert(1);
        bst.lookup(1);
        bst.lookup(31);
        bst.printPreOrder(bst.root);
        bst.breadthFirstSearch(bst.root);
    }
}
