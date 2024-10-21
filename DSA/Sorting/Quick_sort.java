public class QuickSort {
    
    // Function that partitions the array and places the pivot element at its correct position
    int partition(int a[], int start, int end) {
        int pivot = a[end]; // Choosing the last element as the pivot
        int i = (start - 1); // Pointer for the smaller element
        
        // Traverse through the array
        for (int j = start; j <= end - 1; j++) {
            // If the current element is smaller than the pivot
            if (a[j] < pivot) {
                i++; // Increment the index of the smaller element
                // Swap a[i] with a[j]
                int t = a[i];
                a[i] = a[j];
                a[j] = t;
            }
        }
        // Place the pivot element in the correct position
        int t = a[i + 1];
        a[i + 1] = a[end];
        a[end] = t;
        
        return (i + 1); // Return the partitioning index
    }

    // Function to implement Quick Sort
    void quick(int a[], int start, int end) {
        // a[] = array to be sorted, start = Starting index, end = Ending index
        if (start < end) {
            int p = partition(a, start, end); // p is the partitioning index
            quick(a, start, p - 1); // Recursively sort elements before partition
            quick(a, p + 1, end); // Recursively sort elements after partition
        }
    }

    // Function to print an array
    void printArr(int a[], int n) {
        for (int i = 0; i < n; i++)
            System.out.print(a[i] + " ");
        System.out.println();
    }

    public static void main(String[] args) {
        int a[] = {13, 18, 27, 2, 19, 25}; // Example array
        int n = a.length;
        
        System.out.println("Before sorting array elements are - ");
        QuickSort q1 = new QuickSort();
        q1.printArr(a, n);
        
        q1.quick(a, 0, n - 1); // Perform quick sort
        
        System.out.println("After sorting array elements are - ");
        q1.printArr(a, n);
    }
}

// 👉🏻Logic:
// Divide and Conquer: The algorithm divides the array into smaller parts based on a pivot and recursively sorts these parts.
// In-Place Sorting: It does not require additional arrays or lists, making it space efficient.

//👉🏻 code explanation
//  Let's walk through the sorting process for the array {13, 18, 27, 2, 19, 25}.
// Initial array: {13, 18, 27, 2, 19, 25}
// First Call to quick(a, 0, 5)
// Pivot: 25 (last element)
// Array traversal:
// Compare 13 < 25 → swap with itself → {13, 18, 27, 2, 19, 25}
// Compare 18 < 25 → swap with itself → {13, 18, 27, 2, 19, 25}
// Compare 27 < 25 → no swap
// Compare 2 < 25 → swap 2 with 27 → {13, 18, 2, 27, 19, 25}
// Compare 19 < 25 → swap 19 with 27 → {13, 18, 2, 19, 27, 25}
// Final swap with pivot: Swap 25 with 27 → {13, 18, 2, 19, 25, 27}
// Partition index returned: 4
// Second Call to quick(a, 0, 3)
// Pivot: 19
// Array traversal:
// Compare 13 < 19 → swap with itself → {13, 18, 2, 19, 25, 27}
// Compare 18 < 19 → swap with itself → {13, 18, 2, 19, 25, 27}
// Compare 2 < 19 → swap 2 with 18 → {13, 2, 18, 19, 25, 27}
// Final swap with pivot: Swap 19 with 18 → {13, 2, 18, 19, 25, 27}
// Partition index returned: 3
// Third Call to quick(a, 0, 2)
// Pivot: 18
// Array traversal:
// Compare 13 < 18 → swap with itself → {13, 2, 18, 19, 25, 27}
// Compare 2 < 18 → swap 2 with 13 → {2, 13, 18, 19, 25, 27}
// Final swap with pivot: Swap 18 with 13 → {2, 13, 18, 19, 25, 27}
// Partition index returned: 2
// Fourth Call to quick(a, 0, 1)
// Pivot: 13
// Array traversal:
// Compare 2 < 13 → swap with itself → {2, 13, 18, 19, 25, 27}
// Final swap with pivot: Swap 13 with itself → {2, 13, 18, 19, 25, 27}
// Partition index returned: 1
// Final sorted array: [2, 13, 18, 19, 25, 27]

// 👉🏻Time Complexity:
// Best Case: O(n log n) - when the pivot divides the array into two equal halves.
// Worst Case: O(n²) - occurs when the pivot is the smallest or largest element in each recursive call (e.g., sorted array).
// Average Case: O(n log n).

// 👉🏻Space Complexity:
// Space Complexity: O(log n) for the recursion stack in the average case, O(n) in the worst case (due to the stack depth in case of unbalanced partitions).
