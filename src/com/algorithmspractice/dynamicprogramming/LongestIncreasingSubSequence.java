package com.algorithmspractice.dynamicprogramming;

public class LongestIncreasingSubSequence {
    public static void main(String[] args){
        int[] arr = {10, 9, 2, 5, 3, 7, 101, 18};
        int res = lengthOfLIS(arr);
        System.out.println(res);

        int[] arr2 = {10, 22, 9, 33, 21, 50, 41, 60};
        res = lengthOfLIS(arr2);
        System.out.println(res);
    }

    public static int lengthOfLIS(int[] nums) {
        if(nums.length == 0){
            return 0;
        }

        int[] res = new int[nums.length];
        for(int i =0; i < nums.length; i++){
            res[i] = 1;
        }

        int max = 1;
        for(int i = 1; i < nums.length; i++){
            for(int j = 0; j <= i-1;j++){
                if(nums[i] > nums[j]){
                    res[i] = Math.max(res[i], res[j] +1);
                }

                if(res[i] > max){
                    max = res[i];
                }
            }

        }
        return max;
    }
}
