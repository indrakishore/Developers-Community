// 👉🏻selection sort.

import java.util.*;
public class SlectionShort {
    public static void main(String[] args) {
        int [] arr={2,1,5,3};  // Example array
        for(int i=0; i<arr.length; i++){
            int small = i;  // Assume the current element is the smallest
            
            // Find the smallest element in the unsorted part of the array
            for(int j=i+1; j<arr.length; j++){
                if(arr[small] > arr[j]){
                    small = j;  // Update the index of the smallest element
                }
            }
            
            // Swap the smallest element found with the current element
            int temp = arr[i];
            arr[i] = arr[small];
            arr[small] = temp;
        }
        
        // Print the sorted array
        System.out.println(Arrays.toString(arr));  // Output: [1, 2, 3, 5]
    }
}

// 👉🏻Logic
// Selection Process: In each pass, find the smallest element in the unsorted part and place it at the correct position.
// Swapping: Swap the smallest found element with the element at the current index i.
// Number of Swaps: Unlike Bubble Sort, Selection Sort makes fewer swaps since each pass only performs one swap.

// 👉🏻Time Complexity:
// Best, Worst, and Average Case: O(n²)
// The outer loop runs n times, and for each iteration, the inner loop runs approximately n - i times.
// 👉🏻Space Complexity: O(1)
// It is an in-place sorting algorithm, so it uses constant extra space.