package javaa.dsa;

public class SinglyLinkedList {
    class Node {

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    
        int data;
        Node next;
    }

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

    public void insert(int pos, int data) {
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

    public void remove(int pos) {
        if (pos < 1 || pos > size) {
            System.out.println("Index out of bounds");
            return;
        }
    
        if (pos == 1) { // Remove the head
            head = head.next;
            if (size == 1) { // If it was the only node, update tail as well
                tail = null;
            }
        } else {
            Node currNode = head;
            
            // Traverse to the node just before the one to be removed
            for (int i = 1; i < pos - 1; i++) {
                currNode = currNode.next;
            }
            
            // Remove the target node by skipping it
            currNode.next = currNode.next.next;
    
            // If removing the last element, update tail
            if (pos == size) {
                tail = currNode;
            }
        }
    
        size--;
    }

    public void print() {
        Node currNode = head;
        while(currNode != null) {
            String strFormat = currNode.next != null ?  "%d -> " : "%d -> null\n";
            System.out.printf(strFormat, currNode.data);
            currNode = currNode.next;
        }
    }

    public void reverse() {
        // Check if the list is empty or has only one node
        if (head == null || head.next == null) {
            return;
        }
    
        Node prevNode = null;
        Node currNode = head;
        tail = head; // Tail becomes the original head after reversal
    
        // Iterate through the list and reverse the direction of each node's pointer
        while (currNode != null) {
            Node nextNode = currNode.next; // Temporarily store the next node
            currNode.next = prevNode;      // Reverse the current node's pointer
            prevNode = currNode;           // Move prevNode and currNode one step forward
            currNode = nextNode;
        }
    
        // Set the head to the last processed node, which is the new head of the reversed list
        head = prevNode;
    }

    public Node reverseRecursion(Node head) {
        // Base case: if head is null or only one node, it's the new head of reversed list
        if (head == null || head.next == null) {
            return head;
        }

        // Recursively reverse the rest of the list
        Node reversedHead = reverseRecursion(head.next);

        // Make the next node point back to the current head
        head.next.next = head;
        head.next = null; // Set the next of the current node to null to avoid cycle

        // Return the head of the reversed list
        return reversedHead;
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

        slist.insert(2, 99);
        slist.insert(1, 22);
        slist.insert(7, 101);
        slist.insert(10, 11);

        slist.print();
        System.out.println("Head is " + slist.head.data);
        System.out.println("Tail is " + slist.tail.data);
        System.out.println("Size is " + slist.size);

        System.out.println("Remove items");
        slist.remove(2);
        slist.remove(7);
        slist.remove(1);
        slist.print();
        System.out.println("Head is " + slist.head.data);
        System.out.println("Tail is " + slist.tail.data);
        System.out.println("Size is " + slist.size);

        System.out.println("Reverse List");
        slist.reverse();
        slist.print();
        System.out.println("Head is " + slist.head.data);
        System.out.println("Tail is " + slist.tail.data);
        System.out.println("Size is " + slist.size);

        System.out.println("Reverse List (Recursive)");
        slist.head = slist.reverseRecursion(slist.head);
        slist.print();
        System.out.println("Head is " + slist.head.data);
        System.out.println("Tail is " + slist.tail.data);
        System.out.println("Size is " + slist.size);
    }
}
