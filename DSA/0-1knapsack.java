Problem Statement:-
    You are given a knapsack that can carry a maximum weight capacity of W units. There are n items, each with a weight and a value. You need to select a subset of these items to maximize the total value in the knapsack without exceeding the weight limit.

Each item i has:

Weight: w_i
Value: v_i
You can either include the item in the knapsack or exclude it (hence the 0-1 property). The goal is to find the combination of items that maximizes the total value V without the total weight W_total exceeding the knapsack's capacity.

Constraints:
Each item can only be included once.
The total weight of the chosen items should not exceed W.
You want to maximize the total value of the selected items.
Input:
An integer W representing the maximum weight capacity of the knapsack.
An integer n representing the number of items.
Two arrays: weights[] and values[], where:
weights[i] represents the weight of the i-th item.
values[i] represents the value of the i-th item.
Output:
The maximum possible value that can be obtained by selecting items within the weight limit.

Input:-
W = 50
n = 3
weights = [10, 20, 30]
values = [60, 100, 120]

Output:-
220

APPROACH:-
  Here’s a detailed breakdown of the approach:

1. Problem Breakdown
You are given:

A knapsack with a maximum weight capacity W.
n items, each with a specific weight and value.
Each item can either be included in the knapsack or excluded, leading to a binary choice for each item (hence the "0-1" nature).

2. Objective
The goal is to maximize the total value of the items included in the knapsack without exceeding the weight capacity.

3. Dynamic Programming Approach
The idea is to use a 2D table dp, where dp[i][w] represents the maximum value that can be obtained using the first i items and a knapsack capacity of w.

Initialization:

Create a 2D array dp[][] of size (n+1) x (W+1) where:
dp[i][w] holds the maximum value that can be obtained using the first i items and a knapsack of capacity w.
Initialize dp[0][w] = 0 for all w, meaning that if no items are considered (i.e., i=0), the value will be 0 for any capacity.
Initialize dp[i][0] = 0 for all i, meaning that if the knapsack capacity is 0, the value will be 0 for any number of items.
Filling the DP Table:

For each item i (from 1 to n), and for each capacity w (from 1 to W), decide whether to include the current item in the knapsack or not.
There are two cases:
Exclude the item: In this case, the maximum value is the same as without including the current item, i.e., dp[i-1][w].
Include the item (if it fits in the knapsack): In this case, the maximum value will be the value of the current item plus the maximum value that can be obtained with the remaining capacity, i.e., values[i-1] + dp[i-1][w - weights[i-1]].

Final Solution:

The final answer will be in dp[n][W], which gives the maximum value that can be obtained with all n items and a knapsack of capacity W.
DP Formula:
For each item i and each capacity w:

dp[i][w] = Math.max(dp[i-1][w], values[i-1] + dp[i-1][w - weights[i-1]]);

If the item cannot be included:
dp[i][w] = dp[i-1][w];

Time Complexity:
The time complexity is O(n * W), where:
n is the number of items.
W is the maximum capacity of the knapsack.
This is because we are filling a 2D table of size (n+1) x (W+1).
Space Complexity:
The space complexity is O(n * W) because we use a 2D DP array of size (n+1) x (W+1).

SOURCE CODE:-

public class Knapsack {

    // Function to solve 0-1 Knapsack problem
    public static int knapsack(int W, int[] weights, int[] values, int n) {
        // Create a 2D DP array to store the maximum value that can be obtained
        int[][] dp = new int[n + 1][W + 1];

        // Build the DP table in bottom-up manner
        for (int i = 0; i <= n; i++) {
            for (int w = 0; w <= W; w++) {
                if (i == 0 || w == 0) {
                    dp[i][w] = 0;  // No item or no capacity leads to 0 value
                } else if (weights[i - 1] <= w) {
                    // Max of: item included or not included
                    dp[i][w] = Math.max(values[i - 1] + dp[i - 1][w - weights[i - 1]], dp[i - 1][w]);
                } else {
                    // Item not included if weight exceeds the capacity
                    dp[i][w] = dp[i - 1][w];
                }
            }
        }
        // Return the maximum value for the full capacity and all items
        return dp[n][W];
    }

    // Main method to test the function
    public static void main(String[] args) {
        int W = 50;  // Maximum weight of the knapsack
        int[] weights = {10, 20, 30};  // Weights of items
        int[] values = {60, 100, 120}; // Values of items
        int n = weights.length;  // Number of items

        // Call the knapsack function and display the result
        int maxValue = knapsack(W, weights, values, n);
        System.out.println("Maximum value in the knapsack = " + maxValue);
    }
}

