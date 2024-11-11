package javaa.dsa;

public class DoublyLinkedList {
    class Node {
        int data;
        Node prev;
        Node next;

        public Node(int data) {
            this.data = data;
        }
    }

    private Node head = null;
    private Node tail = null;
    private int size = 0;

    public void prepend(int data) {
        Node newNode = new Node(data);
        newNode.next = head;
        
        if (head != null) {
            head.prev = newNode;
        }
        head = newNode;
        
        if (tail == null) { // List was empty
            tail = newNode;
        }
        
        size++;
    }

    public void append(int data) {
        Node newNode = new Node(data);
        
        if (tail == null) { // List was empty
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
        
        size++;
    }

    public void insert(int pos, int data) {
        if (pos < 1 || pos > size + 1) {
            System.out.println("Index out of bounds");
            return;
        }

        if (pos == 1) {
            prepend(data);
            return;
        }

        if (pos == size + 1) {
            append(data);
            return;
        }

        Node currNode = head;
        for (int i = 1; i < pos - 1; i++) { // Traverse to the node just before the position
            currNode = currNode.next;
        }

        Node newNode = new Node(data);
        newNode.next = currNode.next;
        newNode.prev = currNode;
        
        if (currNode.next != null) {
            currNode.next.prev = newNode;
        }
        
        currNode.next = newNode;
        
        size++;
    }

    public void remove(int pos) {
        if (pos < 1 || pos > size) {
            System.out.println("Index out of bounds");
            return;
        }

        if (pos == 1) { // Remove the head
            head = head.next;
            if (head != null) {
                head.prev = null;
            } else {
                tail = null; // List becomes empty
            }
        } else {
            Node currNode = head;
            for (int i = 1; i < pos - 1; i++) { // Traverse to the node before the one to be removed
                currNode = currNode.next;
            }

            currNode.next = currNode.next.next;
            if (currNode.next != null) {
                currNode.next.prev = currNode;
            } else {
                tail = currNode; // If removed last element, update tail
            }
        }

        size--;
    }

    public void print() {
        Node currNode = head;
        while (currNode != null) {
            String strFormat = currNode.next != null ? "%d <-> " : "%d -> null\n";
            System.out.printf(strFormat, currNode.data);
            currNode = currNode.next;
        }
    }

    public static void main(String[] args) {
        DoublyLinkedList dlist = new DoublyLinkedList();
        dlist.prepend(1);
        dlist.prepend(2);
        dlist.prepend(3);
        dlist.append(0);
        dlist.append(-1);
        dlist.print();
        System.out.println("Head is " + dlist.head.data);
        System.out.println("Tail is " + dlist.tail.data);
        System.out.println("Size is " + dlist.size);

        dlist.insert(2, 99);
        dlist.insert(1, 22);
        dlist.insert(7, 101);
        dlist.insert(10, 11);

        dlist.print();
        System.out.println("Head is " + dlist.head.data);
        System.out.println("Tail is " + dlist.tail.data);
        System.out.println("Size is " + dlist.size);

        dlist.remove(2);
        dlist.remove(7);
        dlist.remove(1);
        dlist.print();
        System.out.println("Head is " + dlist.head.data);
        System.out.println("Tail is " + dlist.tail.data);
        System.out.println("Size is " + dlist.size);
    }
}
