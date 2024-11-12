package javaa.dsa;

public class StackUsingLL {
    class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
        }
    }

    private Node top = null;
    private Node bottom = null;
    private int size = 0;

    public void push(int data) {
        Node newNode = new Node(data);
        
        if (bottom == null) {
            bottom = newNode; // Set bottom if stack is initially empty
        }
        
        newNode.next = top; // New node points to current top
        top = newNode;       // Update top to the new node
        size++;
    }

    public int pop() {
        if (top == null) {
            System.out.println("Stack is empty.");
            return -1; // Return -1 or throw an exception if stack is empty
        }
        
        int poppedData = top.data; // Save data to return
        top = top.next;            // Move top down by one node
        size--;

        if (top == null) {         // If stack becomes empty, update bottom
            bottom = null;
        }
        
        return poppedData;
    }

    public void print() {
        System.out.println("-----------------------");
        System.out.println("---------Stack---------");
        System.out.println("-----------------------");
        
        Node currNode = top;
        while(currNode != null) {
            System.out.printf("%d\n", currNode.data);
            currNode = currNode.next;
        }
        System.out.println("-----------------------");
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return top == null;
    }

    public int peek() {
        if (top == null) {
            System.out.println("Stack is empty.");
            return -1; // Return -1 or throw an exception if stack is empty
        }
        return top.data;
    }

    public static void main(String[] args) {
        StackUsingLL stack = new StackUsingLL();
        stack.push(4);
        stack.push(3);
        stack.push(2);
        stack.push(1);
        stack.print();

        System.out.println("Top element is: " + stack.peek());
        System.out.println("Popped element is: " + stack.pop());
        // stack.print();
        System.out.println("Current stack size: " + stack.getSize());
    }
}
