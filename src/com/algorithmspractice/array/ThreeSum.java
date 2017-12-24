package com.algorithmspractice.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

//Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0?
// Find all unique triplets in the array which gives the sum of zero.
//Note: The solution set must not contain duplicate triplets.
//For example, given array S = [-1, 0, 1, 2, -1, -4],
//A solution set is:
//[
//[-1, 0, 1],
//[-1, -1, 2]
//]
public class ThreeSum {
    public static void main(String[] args) {
        System.out.println(threeSum(new int[]{-1, 0, 1, 2, -1, -4}, 0));
        System.out.println(threeSum(new int[]{12, 3, 4, 1, 6, 9} , 24));
        System.out.println(threeSum(new int[]{}, 0));
    }

    public static List<List<Integer>> threeSum(int[] nums, int total) {
        Arrays.sort(nums);
        List<List<Integer>> result = new LinkedList<>();

        for (int i = 0; i < nums.length; i++) {
            int sum = total - nums[i];
            if(i==0 ||( i > 0 && nums[i] != nums[i-1])){
                int low = i + 1, high = nums.length - 1;
                while (low < high) {
                    if (nums[low] + nums[high] == sum) {
                        result.add(Arrays.asList(nums[i], nums[low], nums[high]));
                        while (low < high && nums[low] == nums[low + 1]) {
                            low++;
                        }
                        while (low < high && nums[high] == nums[high - 1]) {
                            high--;
                        }
                        low++;
                        high--;
                    }else{
                        if(nums[low] + nums[high] < sum){
                            low++;
                        }else{
                            high--;
                        }
                    }


                }
            }

        }

        return result;
    }
}
