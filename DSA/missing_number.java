/* Problem Statement : find the missing numbers in an integer array that contains numbers from 1 to a specified maximum value (e.g., 100).
The array may have one or more missing numbers, and the goal is to identify and print all the missing numbers.

Approach
The approach used in this code involves the following steps:

BitSet Initialization: A BitSet is initialized with the size equal to the maximum value (count).
The BitSet is used to keep track of the numbers present in the array. 
Marking Present Numbers: Iterate through the given array and mark the corresponding index in the BitSet as true for each number present in the array. 
Identifying Missing Numbers: Calculate the number of missing elements by subtracting the length of the array from the maximum value (count).
Iterate through the BitSet to find the indices that are still false, which correspond to the missing numbers.*/

import java.util.Arrays;
import java.util.BitSet;
 
/**
 * Java program to find missing elements in a Integer array containing 
 * numbers from 1 to 100.
 *
 * @author Javin Paul
 */
public class MissingNumberInArray {
 
    public static void main(String args[]) {

        // one missing number
        printMissingNumber(new int[]{1, 2, 3, 4, 6}, 6);
 
        // two missing number
        printMissingNumber(new int[]{1, 2, 3, 4, 6, 7, 9, 8, 10}, 10);
 
        // three missing number
        printMissingNumber(new int[]{1, 2, 3, 4, 6, 9, 8}, 10);
 
        // four missing number
        printMissingNumber(new int[]{1, 2, 3, 4, 9, 8}, 10);
 
        // Only one missing number in array
        int[] iArray = new int[]{1, 2, 3, 5};
        int missing = getMissingNumber(iArray, 5);
        System.out.printf("Missing number in array %s is %d %n", 
                           Arrays.toString(iArray), missing);
    }
   /**
    * A general method to find missing values from an integer array in Java.
    * This method will work even if array has more than one missing element.
    */
    private static void printMissingNumber(int[] numbers, int count) {
        int missingCount = count - numbers.length;
        BitSet bitSet = new BitSet(count);
 
        for (int number : numbers) {
            bitSet.set(number - 1);
        }
 
        System.out.printf("Missing numbers in integer array %s, with total number %d is %n",
        Arrays.toString(numbers), count);
        int lastMissingIndex = 0;

        for (int i = 0; i < missingCount; i++) {
            lastMissingIndex = bitSet.nextClearBit(lastMissingIndex);
            System.out.println(++lastMissingIndex);
        }
 
    }


