package javaa.dsa;

class Node {

    public Node(int data) {
        this.data = data;
        this.next = null;
    }

    int data;
    Node next;
}

public class SinglyLinkedList {
    public Node head = null;
    public Node tail = null;
    public int size = 0;

    public void prepend(int data) {
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;

        if (tail == null) tail = newNode;

        size++;
    }

    public void append(int data) {
        Node newNode = new Node(data);
        
        if (head == null) {
            head = newNode;
            tail = newNode;
        } 
        else {
            tail.next = newNode;
            tail = newNode;
        }

        size++;
    }

    public void print() {
        Node currNode = head;
        while(currNode != null) {
            String strFormat = currNode.next != null ?  "%d -> " : "%d -> null\n";
            System.out.printf(strFormat, currNode.data);
            currNode = currNode.next;
        }
    }

    public static void main(String[] args) {
        SinglyLinkedList slist = new SinglyLinkedList();
        slist.prepend(1);
        slist.prepend(2);
        slist.prepend(3);
        slist.append(0);
        slist.append(-1);
        slist.print();
        System.out.println("Head is " + slist.head.data);
        System.out.println("Tail is " + slist.tail.data);
        System.out.println("Size is " + slist.size);
    }
}
