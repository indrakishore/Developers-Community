// Q.👉🏻👉🏻 Bubble Sort java
 
import java.util.Arrays;

public class Bubble_sort {
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

//👉🏻👉🏻 step by step code explanation
// Initial Array: arr = {5, 4, -1, 3, 2, 1}
// First Pass (i = 0):
// Inner Loop Comparisons:

// Compare 5 and 4: Swap → {4, 5, -1, 3, 2, 1}
// Compare 5 and -1: Swap → {4, -1, 5, 3, 2, 1}
// Compare 5 and 3: Swap → {4, -1, 3, 5, 2, 1}
// Compare 5 and 2: Swap → {4, -1, 3, 2, 5, 1}
// Compare 5 and 1: Swap → {4, -1, 3, 2, 1, 5}
// End of First Pass: The largest element 5 is now in its correct position.

// Second Pass (i = 1):
// Inner Loop Comparisons:

// Compare 4 and -1: Swap → {-1, 4, 3, 2, 1, 5}
// Compare 4 and 3: Swap → {-1, 3, 4, 2, 1, 5}
// Compare 4 and 2: Swap → {-1, 3, 2, 4, 1, 5}
// Compare 4 and 1: Swap → {-1, 3, 2, 1, 4, 5}
// End of Second Pass: The second largest element 4 is now in its correct position.

// Third Pass (i = 2):
// Inner Loop Comparisons:

// Compare -1 and 3: No swap → {-1, 3, 2, 1, 4, 5}
// Compare 3 and 2: Swap → {-1, 2, 3, 1, 4, 5}
// Compare 3 and 1: Swap → {-1, 2, 1, 3, 4, 5}
// End of Third Pass: The third largest element 3 is now in its correct position.

// Fourth Pass (i = 3):
// Inner Loop Comparisons:

// Compare -1 and 2: No swap → {-1, 2, 1, 3, 4, 5}
// Compare 2 and 1: Swap → {-1, 1, 2, 3, 4, 5}
// End of Fourth Pass: The fourth largest element 2 is now in its correct position.

// Fifth Pass (i = 4):
// Inner Loop Comparisons:

// Compare -1 and 1: No swap → {-1, 1, 2, 3, 4, 5}
// End of Fifth Pass: The fifth largest element 1 is now in its correct position.

// Final Output
// The final sorted array is printed as [-1, 1, 2, 3, 4, 5].


// 👉🏻👉🏻 Time complexity = O(n^2)
// 👉🏻👉🏻 Space complexity = O(1)
// 👉🏻👉🏻 Logic:
// - Comparisons and Swaps: Continuously compare adjacent elements and swap if needed.
// - Shrinking Range: After each pass, the unsorted portion of the array shrinks, as the largest elements move to their correct positions.
// - End Condition: The outer loop runs until all elements are in the correct order.
