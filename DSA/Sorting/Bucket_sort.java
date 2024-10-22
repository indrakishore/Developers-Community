
// 👉🏻Bucket sort

import java.util.ArrayList;
import java.util.List;

public class Main {
    // Insertion sort function to sort individual buckets
    public static void insertionSort(List<Float> bucket) {
        for (int i = 1; i < bucket.size(); ++i) {
            float key = bucket.get(i);
            int j = i - 1;
            while (j >= 0 && bucket.get(j) > key) {
                bucket.set(j + 1, bucket.get(j));
                j--;
            }
            bucket.set(j + 1, key);
        }
    }

    // Function to sort arr[] of size n using bucket sort
    public static void bucketSort(float[] arr) {
        int n = arr.length;

        // 1) Create n empty buckets
        List<Float>[] buckets = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            buckets[i] = new ArrayList<>();
        }

        // 2) Put array elements in different buckets
        for (int i = 0; i < n; i++) {
            int bi = (int) (n * arr[i]);
            buckets[bi].add(arr[i]);
        }

        // 3) Sort individual buckets using insertion sort
        for (int i = 0; i < n; i++) {
            insertionSort(buckets[i]);
        }

        // 4) Concatenate all buckets into arr[]
        int index = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < buckets[i].size(); j++) {
                arr[index++] = buckets[i].get(j);
            }
        }
    }

    // Driver program to test above function
    public static void main(String[] args) {
        float[] arr = {0.897f, 0.565f, 0.656f, 0.1234f, 0.665f, 0.3434f};
        bucketSort(arr);

        System.out.println("Sorted array is:");
        for (float num : arr) {
            System.out.print(num + " ");
        }
    }
}

// 👉🏻Time Complexity:
// * Best Case: O(n) (when the elements are uniformly distributed).
// * Worst Case: O(n²) (if all elements fall into a single bucket).
// * Average Case: O(n + k), where n is the number of elements and k is the number of buckets.

// 👉🏻Space Complexity:
// * O(n + k): Requires space for the buckets and the sorted array.

// 👉🏻Logic 
// A.Distribution: The main idea of Bucket Sort is to distribute the input elements into buckets based on their value ranges. This allows for sorting smaller groups of numbers (the buckets), which is typically faster.
// B.Sorting: Once the numbers are distributed, sorting within small buckets is generally more efficient, especially when the number of elements in each bucket is small.
// C.Concatenation: Finally, all sorted buckets are concatenated to form the final sorted array.