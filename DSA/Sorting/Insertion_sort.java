import java.util.Arrays;

public class Insertion_sort {
    public static void main(String[] args) {
        int[] arr = {7, 5, 6, 2}; // Example input array
        
        // Start from the second element (index 1) since a single element is already "sorted"
        for (int i = 1; i < arr.length; i++) {
            int ele = arr[i]; // Current element to be inserted
            int check = i - 1; // Index of the last sorted element
            
            // Move elements of arr[0..i-1] that are greater than ele, to one position ahead
            while (check >= 0 && ele < arr[check]) {
                arr[check + 1] = arr[check]; // Shift element to the right
                check--; // Move to the next element on the left
            }
            arr[check + 1] = ele; // Insert the current element into its correct position
        }
        
        // Print the sorted array
        System.out.println(Arrays.toString(arr)); // Output: [2, 5, 6, 7]
    }
}


// 👉🏻Time Complexity:
// Best Case: O(n) — This occurs when the array is already sorted.
// Average and Worst Case: O(n²) — This occurs when the array is in reverse order or when each new element needs to be compared with all sorted elements.
// 👉🏻Space Complexity:
// Space Complexity-O(1) — This is an in-place sorting algorithm, meaning it doesn't require additional storage that grows with the size of the input.

// 👉🏻Logic
// A.Comparisons and Shifts: Each element is compared with those in the sorted part and shifted as necessary to create space for the current element.
// B.Building the Sorted Array: This process is repeated, progressively increasing the size of the sorted part, until the entire array is sorted.