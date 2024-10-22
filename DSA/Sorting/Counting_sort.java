// 👉🏻Counting sort

import java.util.Arrays;

public class Count_sort {
    public static int[] countSort(int[] inputArray) {
        int N = inputArray.length;
        int M = 0;

        for (int i = 0; i < N; i++) {
            M = Math.max(M, inputArray[i]);
        }

        int[] countArray = new int[M + 1];

        for (int i = 0; i < N; i++) {
            countArray[inputArray[i]]++;
        }

        for (int i = 1; i <= M; i++) {
            countArray[i] += countArray[i - 1];
        }

        int[] outputArray = new int[N];

        for (int i = N - 1; i >= 0; i--) {
            outputArray[countArray[inputArray[i]] - 1] = inputArray[i];
            countArray[inputArray[i]]--;
        }

        return outputArray;
    }

    public static void main(String[] args) {
        int[] inputArray = {4, 3, 12, 1, 5, 5, 3, 9};
        int[] outputArray = countSort(inputArray);

        for (int i = 0; i < inputArray.length; i++) {
            System.out.print(outputArray[i] + " ");
        }
    }
}

// 👉🏻Time Complexity
// * O(N + M), where N is the number of elements in the input array and M is the range of the input values (the maximum value in the array).
// 👉🏻Space Complexity
// * O(N + M), as it requires additional space for countArray of size M + 1 and outputArray of size N.

// 👉🏻Logic
// Count frequencies: Count how many times each element appears in the input array.
// Cumulative count: Modify the count array to reflect the cumulative positions.
// Sort: Use the cumulative information to place each element in its correct sorted position.


