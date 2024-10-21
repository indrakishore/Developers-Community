// 👉🏻 Q.Selection Sort java

import java.util.*;
public class Selection_sort {
    public static void main(String[] args) {
        int[] arr = {2, 1, 5, 3};  // Example array
        for (int i = 0; i < arr.length; i++) {
            int smallest = i;  // Assume the current element is the smallest
            
            // Find the smallest element in the unsorted part of the array
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[smallest] > arr[j]) {
                    smallest = j;  // Update the index of the smallest element
                }
            }
            
            // Swap the smallest element found with the current element
            int temp = arr[i];
            arr[i] = arr[smallest];
            arr[smallest] = temp;
        }
        
        // Print the sorted array
        System.out.println(Arrays.toString(arr));  // Output: [1, 2, 3, 5]
    }
}

// 👉🏻 Logic:
// Selection Process: In each pass, find the smallest element in the unsorted part and place it at the correct position.
// Swapping: Swap the smallest found element with the element at the current index i.
// Number of Swaps: Unlike Bubble Sort, Selection Sort makes fewer swaps since each pass only performs one swap.

// 👉🏻Code explanation of selection sort.
// Let's walk through the sorting process for the array {2, 1, 5, 3}.

// Initial array: {2, 1, 5, 3}
// Iteration 1 (i = 0):

// Current element: 2
// Find the smallest element in the rest of the array {1, 5, 3}. The smallest is 1.
// Swap 2 with 1.
// Array after swap: {1, 2, 5, 3}
// Iteration 2 (i = 1):

// Current element: 2
// Find the smallest element in the rest of the array {5, 3}. The smallest is 2 (no need to swap).
// Array remains: {1, 2, 5, 3}
// Iteration 3 (i = 2):

// Current element: 5
// Find the smallest element in the rest of the array {3}. The smallest is 3.
// Swap 5 with 3.
// Array after swap: {1, 2, 3, 5}
// Iteration 4 (i = 3):

// Only one element left (5), so no further action is needed.
// Final sorted array: [1, 2, 3, 5]

// 👉🏻 Time Complexity:
// Best, Worst, and Average Case: O(n²)
// The outer loop runs n times, and for each iteration, the inner loop runs approximately n - i times.

// 👉🏻 Space Complexity: O(1)
// It is an in-place sorting algorithm, so it uses constant extra space.
