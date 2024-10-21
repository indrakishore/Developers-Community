// 👉🏻👉🏻 Q.How to know if a number is a power of 2?
/* package whatever //do not write package name here */
import java.io.*;

class PowerOf_two {

    // Function to check if x is power of 2
    static public boolean isPowerOfTwo(int x) {
        // First x in the below expression is for the case when x is 0 
        return (x != 0) && ((x & (x - 1)) == 0);
    }

    public static void main(String[] args) {
        // Test cases
        System.out.println(isPowerOfTwo(4));   // Output: true (4 is 2^2)
        System.out.println(isPowerOfTwo(7));   // Output: false (7 is not a power of 2)
        System.out.println(isPowerOfTwo(16));  // Output: true (16 is 2^4)
        System.out.println(isPowerOfTwo(0));   // Output: false (0 is not a power of 2)
        System.out.println(isPowerOfTwo(1));   // Output: true (1 is 2^0)
    }
}

//👉🏻👉🏻 Output
// true
// false
// true
// false
// true

// 👉🏻👉🏻 Logic of the code and explanation
// A.Function Purpose: The function isPowerOfTwo(int x) checks if a given integer x is a power of two.

// B.Bitwise Trick: The condition (x & (x - 1)) == 0 is a well-known bitwise trick:

// C.For any power of two, there is only one 1 bit in its binary representation (e.g., 2 = 10, 4 = 100).
// Subtracting 1 from a power of two flips all bits after the least significant 1 bit. For example, 4 = 100, and 4 - 1 = 011.

// D.Applying x & (x - 1) results in 0 if x is a power of two.
// Non-zero Check: The additional condition x != 0 ensures that 0 is not considered a power of two, as 0 & (0 - 1) would also result in 0.

// Thus, the function returns true if the number is a power of two, and false otherwise.


// 👉🏻👉🏻Time complexcity-
// The bitwise operation x & (x - 1) is performed in constant time, i.e., 
// O(1), since bitwise operations are very fast and take constant time regardless of the input size.

//  👉🏻👉🏻space complexcity-
// The function uses a constant amount of space (a few variables like x and the result), and it doesn't use any extra space that grows with the input size.
// Therefore, the space complexity is also O(1).
