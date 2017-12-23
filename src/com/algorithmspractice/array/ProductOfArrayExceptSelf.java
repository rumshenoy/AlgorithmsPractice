package com.algorithmspractice.array;

import com.algorithmspractice.utils.HelperUtils;

public class ProductOfArrayExceptSelf {
//    Given an array of n integers where n > 1, nums, return an array output such that output[i]
//    is equal to the product of all the elements of nums except nums[i].
//    Solve it without division and in O(n).
//    For example, given [1,2,3,4], return [24,12,8,6].
//    Follow up:
//    Could you solve it with constant space complexity?
//    (Note: The output array does not count as extra space for the purpose of space complexity analysis.)

    public static void main(String[] args) {
        HelperUtils.printArray(productOfArray(new int[]{1,2,3,4}));
    }

    public static int[] productOfArray(int[] nums){
        int[] product = new int[nums.length];
        int productSoFar = 1;

        for(int i = 0; i < nums.length; i++){
            product[i] = productSoFar;
            productSoFar = productSoFar * nums[i];
        }

        productSoFar = 1;
        for(int i = nums.length -1 ; i>=0; i--){
            product[i] = product[i] * productSoFar;
            productSoFar = productSoFar * nums[i];
        }

        return product;
    }
}
