// File: protocol.java

/*
 * Problem Statement:
 * You are given an array where each element represents the price of a given stock on a specific day. 
 * Your goal is to maximize your profit by choosing a day to buy one stock and choosing a different day 
 * in the future to sell that stock. You are only allowed to make one transaction (i.e., buy one and sell one share).
 * 
 * Write a function that returns the maximum profit you can achieve from this transaction.
 * If no profit is possible, return 0.
 */

/*
 * Approach:
 * 1. Initialize `minPrice` to a very high value and `maxProfit` to 0.
 * 2. Iterate through the array of stock prices:
 *    - For each price, update `minPrice` to the lowest value seen so far.
 *    - Calculate the profit by subtracting `minPrice` from the current price.
 *    - Update `maxProfit` if the calculated profit is higher than the current `maxProfit`.
 * 3. At the end of the loop, `maxProfit` will hold the maximum profit that can be made.
 * 4. If no profit is possible, return 0.
 */

 import java.util.Scanner;

 public class BestTimeToBuyAndSellStock {
 
     // Function to calculate maximum profit
     public static int maxProfit(int[] prices) {
         if (prices == null || prices.length == 0) return 0;
 
         int minPrice = Integer.MAX_VALUE;
         int maxProfit = 0;
 
         // Iterate through the prices array
         for (int i = 0; i < prices.length; i++) {
             // Update the minimum price seen so far
             if (prices[i] < minPrice) {
                 minPrice = prices[i];
             }
             // Calculate profit and update the maximum profit
             int profit = prices[i] - minPrice;
             if (profit > maxProfit) {
                 maxProfit = profit;
             }
         }
         return maxProfit; // Return the maximum profit
     }
 
     public static void main(String[] args) {
         Scanner scanner = new Scanner(System.in);
 
         // Prompt user for the number of days
         System.out.print("Enter the number of days: ");
         int n = scanner.nextInt();
 
         // Create an array to store the prices
         int[] prices = new int[n];
 
         // Input stock prices from user
         System.out.println("Enter the stock prices for " + n + " days:");
         for (int i = 0; i < n; i++) {
             prices[i] = scanner.nextInt();
         }
 
         // Call the maxProfit function and print the result
         int result = maxProfit(prices);
         System.out.println("Maximum Profit: " + result);
     }
 }
 