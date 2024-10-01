package DSA;

public class StackUsingLinkedListByShalini {
    public static void main(String[] args) {
        LinkedListStack s = new LinkedListStack();

        // Pushing elements onto the stack
        s.push(6);
        s.push(3);
        s.push(7);

        System.out.println("Top of the stack before deleting any element: " + s.top());
        System.out.println("Size of the stack before deleting any element: " + s.size());
        System.out.println("The element deleted is: " + s.pop());
        System.out.println("Size of the stack after deleting an element: " + s.size());
        System.out.println("Top of the stack after deleting an element: " + s.top());

        // Peek the top element without popping
        System.out.println("Peeking the top element: " + s.top());

        // Try popping from an empty stack
        if (s.isEmpty()) {
            System.out.println("The stack is empty now.");
        } else {
            System.out.println("Stack is not empty.");
        }
    }
}

class LinkedListStack {
    // Node class to represent elements in the stack
    private class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    private Node top;  // Top pointer of the stack
    private int size;  // To keep track of the size of the stack

    // Constructor to initialize stack
    public LinkedListStack() {
        this.top = null;
        this.size = 0;
    }

    // Push an element onto the stack
    public void push(int x) {
        Node newNode = new Node(x);
        newNode.next = top;
        top = newNode;
        size++;
    }

    // Pop the top element from the stack
    public int pop() {
        if (top == null) {
            System.out.println("Stack Underflow");
            return -1;
        }
        int x = top.data;
        top = top.next;
        size--;
        return x;
    }

    // Peek the top element without removing it
    public int top() {
        if (top == null) {
            System.out.println("Stack is Empty");
            return -1;
        }
        return top.data;
    }

    // Return the current size of the stack
    public int size() {
        return size;
    }

    // Check if the stack is empty
    public boolean isEmpty() {
        return top == null;
    }
}

