/* The problem statement is that we are given an array prices where prices[i] is the price of a given stock on the ith day.
we want to maximize your profit by choosing a single day to buy one stock and choosing a different day in the future to sell that stock.
We have to  the maximum profit you can achieve from this transaction. If we cannot achieve any profit, return 0.
Example 1:
Input: prices = [7,1,5,3,6,4]
Output: 5
Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
Note that buying on day 2 and selling on day 1 is not allowed because you must buy before you sell.*/
// So For this problem statement we have intuitive approach that is below.

#include<iostream>
#include<vector>
#include<climits>
using namespace std;
class Solution {
public:
    int maxProfit(vector<int>& prices) {
        int maxProfit = 0, bestBuy = prices[0];
        for(int i =1; i<prices.size(); i++){
            if(prices[i]>bestBuy){
                maxProfit = max(maxProfit, prices[i]-bestBuy);
            }
            else{
                bestBuy = min(bestBuy, prices[i]);
            }
        }
        return maxProfit;
        
    }
};

int main(){
Solution s;
vector<int>v = {7,1,5,3,6,4];
cout<<"maximum profit is :- "<<s.maxProfit(v);
