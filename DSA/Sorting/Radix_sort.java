// 👉🏻👉🏻Radix sort Java implementation

import java.io.*;
import java.util.*;

class Radix {

    // A utility function to get maximum value in arr[]
    static int getMax(int arr[], int n)
    {
        int mx = arr[0];
        for (int i = 1; i < n; i++)
            if (arr[i] > mx)
                mx = arr[i];
        return mx;
    }

    // A function to do counting sort of arr[] according to
    // the digit represented by exp.
    static void countSort(int arr[], int n, int exp)
    {
        int output[] = new int[n]; // output array
        int i;
        int count[] = new int[10];
        Arrays.fill(count, 0);

        // Store count of occurrences in count[]
        for (i = 0; i < n; i++)
            count[(arr[i] / exp) % 10]++;

        // Change count[i] so that count[i] now contains
        // actual position of this digit in output[]
        for (i = 1; i < 10; i++)
            count[i] += count[i - 1];

        // Build the output array
        for (i = n - 1; i >= 0; i--) {
            output[count[(arr[i] / exp) % 10] - 1] = arr[i];
            count[(arr[i] / exp) % 10]--;
        }

        // Copy the output array to arr[], so that arr[] now
        // contains sorted numbers according to current
        // digit
        for (i = 0; i < n; i++)
            arr[i] = output[i];
    }

    // The main function to that sorts arr[] of
    // size n using Radix Sort
    static void radixsort(int arr[], int n)
    {
        // Find the maximum number to know number of digits
        int m = getMax(arr, n);

        // Do counting sort for every digit. Note that
        // instead of passing digit number, exp is passed.
        // exp is 10^i where i is current digit number
        for (int exp = 1; m / exp > 0; exp *= 10)
            countSort(arr, n, exp);
    }

    // A utility function to print an array
    static void print(int arr[], int n)
    {
        for (int i = 0; i < n; i++)
            System.out.print(arr[i] + " ");
    }

    // Main driver method
    public static void main(String[] args)
    {
        int arr[] = { 170, 45, 75, 90, 802, 24, 2, 66 };
        int n = arr.length;

        // Function Call
        radixsort(arr, n);
        print(arr, n);
    }
}


// 👉🏻👉🏻 Logic of the code.
// -This Java program implements Radix Sort, a non-comparative integer sorting algorithm. Radix Sort works by sorting numbers digit by digit, starting from the least significant digit to the most significant digit. It uses Counting Sort as a subroutine to sort based on each digit.




// 👉🏻👉🏻 explanation of the code.
// 1. getMax Function:
// .This function finds the maximum value in the input array. It is crucial to Radix Sort because we need to know the maximum number in the array to determine how many digits it has. This allows us to know how many passes of sorting (one per digit) we need to perform.

// 2. countSort Function:
// This function performs Counting Sort on the array based on a specific digit, represented by exp. The parameter exp controls which digit we are sorting by, starting from the least significant digit (ones place) and moving to higher places (tens, hundreds, etc.).

// Explanation of the Steps:
// Create the output array: This array stores the sorted version of the input array for the current digit.

// Create and initialize count array: This array is used to count the occurrences of each digit (0-9). It is initialized to 0 using Arrays.fill(count, 0).

// Step 1 - Count occurrences of each digit:

// Traverse through the array and, for each element, calculate which digit (at the current place represented by exp) should be counted.
// (arr[i] / exp) % 10 extracts the digit at the current place (for example, if arr[i] = 123 and exp = 10, it extracts the tens digit 2).
// Step 2 - Prefix sum to calculate positions:

// The count[i] array is modified so that count[i] contains the actual position of this digit in the output array.
// Step 3 - Build the output array:

// Traverse the input array from right to left and place elements in the output array at their correct positions.
// Step 4 - Copy the output array to the original array:

// After sorting the current digit, the output array is copied back into the original arr array.

// 3. radixsort Function:
// This is the main driver function that applies the Radix Sort algorithm. It first finds the maximum number in the array using getMax to determine the number of digits. Then it iteratively calls countSort for each digit, starting from the least significant digit (units place, exp = 1) and working its way up.
 // Explanation of the Steps:
// Find maximum number (m):
// This helps to determine how many passes of sorting are needed, as each pass sorts based on a different digit.
// Counting Sort for each digit:
// The loop runs while m / exp > 0, meaning it sorts the array until it has processed every digit of the largest number.
// exp starts at 1 (units place) and multiplies by 10 after each iteration, so it moves from units to tens, hundreds, etc.

// 4. print Function:
// This utility function prints the elements of the array.

// 5. main Method:
// This is the entry point of the program. The array arr[] is initialized with some sample values. The radixsort function is called to sort the array, and then the sorted array is printed using the print function.

//👉🏻👉🏻  Time complexity -
// Time Complexity: O(d * (n + k)) where d is the number of digits in the maximum number, n is the number of elements, and k is the range of digits (which is 10 for decimal numbers).

// 👉🏻👉🏻  Space complexity-
// Space Complexity: O(n), as we need to store the output array of size n.
