
/*
Problem Statement : Find the second maximum value in a given array.

Approach :

1. We will initialize two variables, "max" and "secondmax", and assign them the lowest possible integer value, which is `Integer.MIN_VALUE`.

2. We will then iterate through the array and compare each element with the current "max" and "secondmax" values.

3. If the current element (arr[i]) is greater than "max", we will:
   - Assign the current "max" value to "secondmax" (because the new element becomes the maximum).
   - Update "max" to arr[i].

4. If the current element (arr[i]) is not greater than "max" but is greater than "secondmax", we will:
   - Assign "secondmax" to arr[i] because this element is now the second largest.

5. By the end of the iteration, "secondmax" will hold the second largest value in the array.

Example:
Input: [3, 5, 7, 2, 8]
After processing: max = 8, secondmax = 7

This approach ensures that we find the second maximum value in O(n) time complexity, where n is the number of elements in the array.

*/


public class FindSecondMaximum {

    public static void main(String[] args) {

        int[] arr = {13, 34, 14, 56, 34, 70};
        int max = Integer.MAX_VALUE+1;
        int secMax = Integer.MIN_VALUE;
        for(int ele: arr) {
            if(ele>max) {
                secMax = max;
                max = ele;
            }else if(ele!=max && ele > secMax) {
                secMax = ele;
            }
        }System.out.print(secMax);

    }

}
