package com.algorithmspractice.dynamicprogramming;
//http://interactivepython.org/runestone/static/pythonds/Recursion/DynamicProgramming.html#fig-dpcoins
public class CoinChangeProblem {
    public static int[] coinChange;

    public static void main(String args[]){

        int[] arr = {1, 5, 10, 25};
        int change = 11;

        coinChange = new int[change+1];
        System.out.println(coinChangeDP(arr, change));

        int a= change;
        while(a >0){
            System.out.println(arr[coinChange[a]]);
            a = a - arr[coinChange[a]];
        }
    }

    static int coinChangeDP(int[] coinValueList, int change){
        int[] minCoins = new int[change+1];
        int coinCount =0, coin = 0;
        for(int i=1; i < change+1; i++){
            coinCount = i; //11
            for(int j = 0; j < coinValueList.length; j++){
                if(coinValueList[j] <= i){
                    if(minCoins[i - coinValueList[j]] + 1 < coinCount){
                        coinCount = minCoins[i - coinValueList[j]]+1;
                        coin = j;
                    }
                }
            }
            minCoins[i] = coinCount;
            coinChange[i] = coin;
        }
        return minCoins[change];
    }
}
