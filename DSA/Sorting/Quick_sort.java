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


// 👉🏻Time Complexity:
// Best Case: O(n log n) - when the pivot divides the array into two equal halves.
// Worst Case: O(n²) - occurs when the pivot is the smallest or largest element in each recursive call (e.g., sorted array).
// Average Case: O(n log n).

// 👉🏻Space Complexity:
// Space Complexity: O(log n) for the recursion stack in the average case, O(n) in the worst case (due to the stack depth in case of unbalanced partitions).
