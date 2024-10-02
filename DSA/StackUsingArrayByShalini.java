package DSA;

public class StackUsingArrayByShalini{
    public static void main(String[] args) {
        stack s = new stack();
        // Pushing elements onto the stack
        s.push(6);
        s.push(7);
        s.push(12);
        
        System.out.println("Top of the stack before deleting any element: " + s.peek());
        System.out.println("Size of the stack before deleting any element: " + s.size());
        System.out.println("The element deleted is: " + s.pop());
        System.out.println("Top of the stack after deleting an element: " + s.peek());

        // Peek the top element without popping
        System.out.println("Peeking the top element: " + s.peek());

        // Popping from an empty stack
        if (s.isEmpty()) {
            System.out.println("The stack is empty now.");
        } else {
            System.out.println("Stack is not empty.");
        }
    }
}
class stack {
    int size = 10000; // Maximum stack size
    int arr[] = new int[size];
    int top = -1;

    // Push an element onto the Stack
    void push(int x) {
        if(top == size - 1) {
            System.out.println("Stack Overflow");
            return;
        }
        top++;
        arr[top] = x;
    }

    // Pop the top element from the stack
    int pop() {
        if(top == -1) {
            System.out.println("Stack Underflow");
            return -1;
        }
        int x = arr[top];
        top--;
        return x;
    }

    // Peek the top element without removing it
    int peek() {
        if(top == -1) {
            System.out.println("Stack is Empty");
            return -1;
        }
        return arr[top];
    }

    // Return the current size of the stack
    int size() {
        return top + 1;
    }

    // Check if the stack is empty
    boolean isEmpty() {
        return top == -1;
    }
}
