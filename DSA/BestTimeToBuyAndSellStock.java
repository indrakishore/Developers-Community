import java.util.Scanner;

public class BestTimeToBuyAndSellStock {

    // Function to calculate maximum profit
    public static int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) return 0;

        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;

        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < minPrice) {
                minPrice = prices[i];
            }
            int profit = prices[i] - minPrice;
            if (profit > maxProfit) {
                maxProfit = profit;
            }
        }
        return maxProfit;
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
