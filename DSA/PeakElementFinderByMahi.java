// File: protocol.java

/*
 * Problem Statement:
 * Given an array of integers, find a peak element. A peak element is an element that is greater 
 * than its neighbors. In case of a boundary element, it only needs to be greater than its one neighbor.
 * The goal is to find the index of one peak element in the array using an efficient approach.
 * 
 * A peak element can be located anywhere in the array, and there can be multiple peak elements.
 * The function should return the index of one such peak.
 */

/*
 * Approach:
 * 1. The problem can be solved using a binary search-like approach.
 * 2. The `findPeakElement` function uses recursion to find the peak element.
 * 3. In the recursive helper function `findPeakUtil`, we calculate the middle index:
 *    - Check if the middle element is greater than its neighbors (i.e., it's a peak).
 *    - If the element on the left side of mid is greater, search in the left half of the array.
 *    - If the element on the right side of mid is greater, search in the right half of the array.
 * 4. This approach ensures that a peak is found in O(log n) time.
 */

 import java.util.Scanner;

 public class PeakElementFinder {
 
     // Method to find a peak element in the array
     public static int findPeakElement(int[] arr) {
         return findPeakUtil(arr, 0, arr.length - 1);  // Call helper function
     }
 
     // Recursive function to find peak element using binary search logic
     private static int findPeakUtil(int[] arr, int left, int right) {
         int mid = left + (right - left) / 2;  // Find the middle index
 
         // Check if mid is a peak element
         if ((mid == 0 || arr[mid - 1] < arr[mid]) && (mid == arr.length - 1 || arr[mid] > arr[mid + 1])) {
             return mid;  // Mid is a peak element
         }
 
         // If the left neighbor is greater, the peak must be on the left side
         if (mid > 0 && arr[mid - 1] > arr[mid]) {
             return findPeakUtil(arr, left, mid - 1);
         }
 
         // Otherwise, the peak must be on the right side
         return findPeakUtil(arr, mid + 1, right);
     }
 
     public static void main(String[] args) {
         Scanner scanner = new Scanner(System.in);
 
         // Input the length of the array
         System.out.print("Enter the length of the array: ");
         int n = scanner.nextInt();
 
         // Create and input elements for the array
         int[] arr = new int[n];
         System.out.println("Enter the elements of the array:");
         for (int i = 0; i < n; i++) {
             arr[i] = scanner.nextInt();
         }
 
         // Find the peak element index and print it
         int peakIndex = findPeakElement(arr);
         System.out.println("Index of a peak element: " + peakIndex);
         System.out.println("Peak element: " + arr[peakIndex]);
 
         scanner.close(); // Close the scanner to avoid resource leak
     }
 }
 