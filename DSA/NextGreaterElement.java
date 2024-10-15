// File: protocol.java

/*
 * Problem Statement:
 * Given an array of integers, the task is to find the next greater element for each element 
 * in the array. The next greater element for an element is the first greater element on the 
 * right side of that element in the array. If there is no greater element, the next greater 
 * element is considered to be -1.
 * 
 * Write a function that returns an array of the next greater elements for each element in the input array.
 */

/*
 * Approach:
 * 1. Initialize an empty stack to keep track of elements for which we need to find the next greater element.
 * 2. Create an output array to store the results, initialized to -1.
 * 3. Traverse the input array from right to left:
 *    - For each element, pop elements from the stack while they are less than or equal to the current element.
 *    - If the stack is not empty after popping, the top element of the stack is the next greater element.
 *    - Push the current element onto the stack.
 * 4. Continue this process until all elements are processed.
 * 5. Return the output array containing the next greater elements.
 */

 import java.util.Scanner;
 import java.util.Stack;
 
 public class NextGreaterElement {
 
     // Function to find the next greater element for each element in the array
     public static int[] nextGreaterElement(int[] arr) {
         int n = arr.length;  // Get the length of the array
         int[] result = new int[n];  // Array to store the result
         Stack<Integer> stack = new Stack<>();  // Stack to keep track of elements
         
         // Traverse the array from right to left
         for (int i = n - 1; i >= 0; i--) {
             // Remove elements from the stack that are smaller than or equal to the current element
             while (!stack.isEmpty() && stack.peek() <= arr[i]) {
                 stack.pop();  // Pop the smaller elements
             }
             
             // If the stack is empty, there is no greater element
             result[i] = stack.isEmpty() ? -1 : stack.peek();  // Get the next greater element
             
             // Push the current element onto the stack for future comparisons
             stack.push(arr[i]);
         }
         
         return result;  // Return the result array
     }
 
     public static void main(String[] args) {
         Scanner scanner = new Scanner(System.in);
 
         // Input array size from the user
         System.out.print("Enter the number of elements in the array: ");
         int n = scanner.nextInt();
 
         // Initialize the array with the user's input
         int[] arr = new int[n];
         System.out.println("Enter the elements of the array:");
         for (int i = 0; i < n; i++) {
             arr[i] = scanner.nextInt();
         }
 
         // Call the nextGreaterElement function to get the result
         int[] result = nextGreaterElement(arr);
 
         // Print the result
         System.out.println("Next Greater Elements:");
         for (int i = 0; i < n; i++) {
             System.out.println(arr[i] + " -> " + result[i]);
         }
 
         scanner.close();  // Close the scanner to avoid resource leaks
     }
 }
 