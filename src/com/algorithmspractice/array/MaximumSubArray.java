package com.algorithmspractice.array;

public class MaximumSubArray {

    public static void main(String args[]){
        int[] input = {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(maxSubArray(input));
    }
    public static int maxSubArray(int[] nums) {
        int maxSum =nums[0], curSum = nums[0];
        for(int i = 1; i < nums.length; i++){
            curSum = Math.max(nums[i], curSum+nums[i]);
            maxSum = Math.max(curSum, maxSum);
        }

        return maxSum;
    }
}
