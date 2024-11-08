package javaa.dsa;

class Node {

    public Node(int data) {
        this.data = data;
        this.next = null;
    }

    int data;
    Node next;
    int size;
}

public class SinglyLinkedList {
    public Node head = null;
    public Node tail = null;

    public void prepend(int data) {
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
    }

    public void append(int data) {
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
    }

    public void print() {
        Node currNode = head;
        while(currNode != null) {
            String strFormat = currNode.next != null ?  "%d -> " : "%d -> null";
            System.out.printf(strFormat, currNode.data);
            currNode = currNode.next;
        }
    }

    public static void main(String[] args) {
        SinglyLinkedList slist = new SinglyLinkedList();
        slist.prepend(1);
        slist.prepend(2);
        slist.prepend(3);
        slist.print();
    }
}
