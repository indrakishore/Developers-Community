// 👉🏻👉🏻bubble sort

import java.util.Arrays;

public class Bubblesort {
    public static void main(String[] args) {
        int[] arr = {5, 4, -1, 3, 2, 1};  // Example input array
        
        // Outer loop to control the number of passes
        for (int i = 0; i < arr.length - 1; i++) {
            // Inner loop to perform adjacent element comparisons and swaps
            for (int j = 0; j < arr.length - i - 1; j++) {
                // If the current element is greater than the next element, swap them
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];      // Store the value of arr[j]
                    arr[j] = arr[j + 1];    // Swap arr[j] with arr[j+1]
                    arr[j + 1] = temp;      // Complete the swap
                }
            }
        }
        
        // Print the sorted array
        System.out.println(Arrays.toString(arr));  // Output: [-1, 1, 2, 3, 4, 5]
    }
}

// 👉🏻👉🏻 time complexcity= O(n^2). 
//👉🏻👉🏻 space complexcity=O(1)
// 👉🏻👉🏻logic.
  // -Comparisons and Swaps: Continuously compare adjacent elements and swap if needed.
  // -Shrinking Range: After each pass, the unsorted portion of the array shrinks, as the largest elements move to their correct positions.
  // -End Condition: The outer loop runs until all elements are in the correct order.