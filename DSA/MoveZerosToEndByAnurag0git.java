"""
Problem Statement: Given an array with non-zero elements, move all zeros to the end of the array.

Approach:
We'll use a two-pointer technique:
- Initialize two pointers, let's call them i and j, both starting at the beginning of the array.
- Traverse through the array with pointer i.
- Whenever we encounter arr[i] != 0 (a non-zero element) and arr[j] == 0 (a zero element), we swap arr[i] and arr[j].
- Regardless of whether we swap or not, always increment j.
- This ensures that j always points to the next position where a zero should be placed.
- Continue this process until i has traversed the entire array.

At the end of this process, all zeros will be moved to the end of the array while maintaining the relative order of non-zero elements.

Example:
Input: [0, 1, 0, 3, 12]
After processing: [1, 3, 12, 0, 0]

This approach efficiently moves zeros to the end of the array in O(n) time complexity, where n is the number of elements in the array.
"""

	
import java.util.Arrays;

public class moveZerosToEnd {

	public static void main(String[] args) {

		int j = 0;
		int arr[] = {8, 1, 0, 2, 1, 0, 3};
		int n = arr.length;
		for(int i = 0; i<n; i++) {
			if(arr[i]!=0 && arr[j]==0) {
				int temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
			}if(arr[j]!=0)j++;
		}System.out.print(Arrays.toString(arr));
	}

}
