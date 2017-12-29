package com.algorithmspractice.dynamicprogramming;
//Say you have an array for which the ith element is the price of a given stock on day i.
//If you were only permitted to complete at most one transaction (ie, buy one and sell one share of the stock),
//design an algorithm to find the maximum profit.
//
//Example 1:
//Input: [7, 1, 5, 3, 6, 4]
//Output: 5
//
//max. difference = 6-1 = 5 (not 7-1 = 6, as selling price needs to be larger than buying price)
//Example 2:
//Input: [7, 6, 4, 3, 1]
//Output: 0
//
//In this case, no transaction is done, i.e. max profit = 0.
public class BestTimeToBuyAndSellStock {
    public static void main(String[] args) {
        System.out.println(maxProfit(new int[]{7, 1, 5, 3, 6, 4}));
        System.out.println(maxProfit(new int[]{7, 2, 5, 3, 6, 4, 2, 1, 9, 8 }));
        System.out.println(maxProfit(new int[]{7, 2, 5, 3, 6, 4, 2, 4, 2, 8 }));
        System.out.println(maxProfit(new int[]{7, 6, 5, 4, 3, 2 }));
    }

    public static int maxProfit(int[] prices) {
        int min = Integer.MAX_VALUE;
        int profit = 0;
        for(int i =0; i < prices.length; i++){
            if(prices[i] < min){
                min = prices[i];
            }else{
                profit = Math.max(prices[i] - min, profit);
            }
        }
        return profit;
    }
}
