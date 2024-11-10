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

    public void insertAfter(int pos, int data) {
        if (pos < 1 || pos > size) {
            System.out.println("Index out of bounds");
            return;
        }
    
        // If inserting at the beginning, use prepend
        if (pos == 1) {
            prepend(data);
            return;
        }
    
        // If inserting at the end, use append
        if (pos == size) {
            append(data);
            return;
        }
    
        Node currNode = head;
        for (int i = 1; i < pos; i++) {  // Iterate to the node before the insertion point
            currNode = currNode.next;
        }
    
        Node newNode = new Node(data);
        newNode.next = currNode.next;
        currNode.next = newNode;
        size++;
    
        // Update tail if we inserted at the end
        if (newNode.next == null) {
            tail = newNode;
        }
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

        slist.insertAfter(2, 99);
        slist.insertAfter(1, 22);
        slist.insertAfter(7, 101);
        slist.insertAfter(10, 11);

        slist.print();
        System.out.println("Head is " + slist.head.data);
        System.out.println("Tail is " + slist.tail.data);
        System.out.println("Size is " + slist.size);
    }
}
