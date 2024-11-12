package javaa.dsa;

public class QueueUsingLL {
    class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
        }
    }

    private Node front = null;
    private Node rear = null;
    private int size = 0;

    public void enqueue(int data) {
        Node newNode = new Node(data);
        
        if (rear == null) {
            rear = newNode;
            front = newNode;
        } else {   
            rear.next = newNode; // New node points to rear.next
            rear = newNode;       // Update rear to the new node
        }
        size++;
    }

    public void dequeue() {
        if (size == 0) {
            System.out.println("Queue is empty");
            return;
        }

        front = front.next;
        size--;

        // If the queue is now empty, reset rear to null as well
        if (front == null) {
            rear = null;
        }
    }

    public int peek() {
        if (size == 0) {
            System.out.println("Queue is empty");
            return -1; // Or throw an exception
        }
        return front.data;
    }

    public void print() {
        System.out.println("-----------------------");
        System.out.println("---------Queue---------");
        System.out.println("-----------------------");
        if (size == 0) {
            System.out.println("Queue is empty!");
            return;
        }
        
        Node currNode = front;
        while(currNode != null) {
            System.out.printf("%d -> ", currNode.data);
            currNode = currNode.next;
        }
        System.out.printf("\n-----------------------");
    }

    public static void main(String[] args) {
        QueueUsingLL queue = new QueueUsingLL();
        queue.enqueue(4);
        queue.enqueue(3);
        queue.enqueue(2);
        queue.enqueue(1);
        queue.print();
        queue.dequeue();
        queue.print();
    }
}
