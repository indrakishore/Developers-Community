package DSA;

import java.util.Stack;
public class StackUsingStackClassByShalini {
    public static void main(String[] args) {

        // Initialize a stack of Integer type
        Stack<Integer> stack = new Stack<>(); 

        // Pushing elements onto the stack
        stack.push(10);
        stack.push(20);
        stack.push(30);
        stack.push(40);
        stack.push(50);

        // Display the top element
        System.out.println("Top element: " + stack.peek());

        // Display the current size of the stack
        System.out.println("Current stack size: " + stack.size());

        // Popping elements from the stack
        System.out.println("Popped element: " + stack.pop());
        System.out.println("Popped element: " + stack.pop());

        // Display the top element and size after popping
        System.out.println("Top element after popping: " + stack.peek());
        System.out.println("Stack size after popping: " + stack.size());

        // Checking if the stack is empty
        if (stack.isEmpty()) {
            System.out.println("The stack is empty.");
        } else {
            System.out.println("The stack is not empty.");
        }

        // Pop remaining elements
        while (!stack.isEmpty()) {
            System.out.println("Popped element: " + stack.pop());
        }

        // Trying to pop from an empty stack
        if (stack.isEmpty()) {
            System.out.println("The stack is empty, can't pop anymore.");
        }
    }
}
