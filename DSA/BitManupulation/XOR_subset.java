// 👉🏻👉🏻Given a set, find XOR of the XOR’s of all subsets.
// -The question is to find XOR of the XOR’s of all subsets. i.e if the set is {1,2,3}. All subsets are : [{1}, {2}, {3}, {1, 2}, {1, 3}, {2, 3}, {1, 2, 3}]. Find the XOR of each of the subset and then find the XOR of every subset result.
import java.util.*;

class GFG {

    // Function to find XOR of a subset
    static int findSubsetXOR(int[] subset) {
        int xorVal = 0;
        for (int num : subset) {
            xorVal ^= num;
        }
        return xorVal;
    }

    // Function to generate all subsets and calculate XOR of each subset
    static int findXOR(int[] set, int n) {
        int totalXOR = 0;
        int numOfSubsets = 1 << n; // 2^n subsets

        System.out.println("Subsets and their XOR values:");

        for (int i = 0; i < numOfSubsets; i++) {
            List<Integer> subset = new ArrayList<>();

            // Generate each subset
            for (int j = 0; j < n; j++) {
                if ((i & (1 << j)) > 0) {
                    subset.add(set[j]);
                }
            }

            // Convert list to array for finding XOR
            int[] subsetArray = subset.stream().mapToInt(Integer::intValue).toArray();
            int subsetXOR = findSubsetXOR(subsetArray);
            totalXOR ^= subsetXOR;

            // Print subset and its XOR value
            System.out.println(subset + " -> XOR: " + subsetXOR);
        }

        return totalXOR;
    }

    // Driver code
    public static void main(String[] args) {
        int[] set = {1, 2, 3};
        int n = set.length;

        System.out.println("XOR of XOR's of all subsets is: " + findXOR(set, n));
    }
}


//👉🏻👉🏻 Output
// Subsets and their XOR values:
// [] -> XOR: 0
// [1] -> XOR: 1
// [2] -> XOR: 2
// [1, 2] -> XOR: 3
// [3] -> XOR: 3
// [1, 3] -> XOR: 2
// [2, 3] -> XOR: 1
// [1, 2, 3] -> XOR: 0
// XOR of XOR's of all subsets is: 0

// 👉🏻👉🏻Logic  
// The program generates all possible subsets and calculates their XOR.
// For example, the subset [1, 2] has an XOR of 3 (1 ^ 2 = 3), and [2, 3] has an XOR of 1 (2 ^ 3 = 1).
// The final result is the XOR of all the individual subset XORs, which in this case is 0.

// 👉🏻👉🏻 explanation of code-
// Subset Generation:

// A.The code uses a bitwise method to generate all possible subsets.
// It loops over integers from 0 to 2^n - 1 (which represents the possible subsets in binary).
// B.For each integer i, its binary representation indicates which elements of the original set are included in the subset. For example, if i = 5 (binary 101), the subset includes the first and third elements.
// XOR Calculation:

//C. For each generated subset, the XOR of its elements is calculated. This is done using the findSubsetXOR function.
// D.The program maintains a running XOR of all XORs of the subsets using totalXOR.
// Final XOR:

// E.After all subsets are processed, the XOR of all XOR values from the subsets is printed as the final result.

// 👉🏻👉🏻time complexity 
// Subset generation: There are 2^n subsets, so this loop runs 2^n times.
// XOR calculation: For each subset, the XOR of its elements is computed in linear time.
// Overall time complexity: O(2^n * n), where n is the size of the set. This is because there are 2^n subsets, and computing the XOR of each subset takes O(n).


//👉🏻👉🏻 Space Complexity:
// O(n) for storing the subsets at any given time (since the largest subset will have n elements).