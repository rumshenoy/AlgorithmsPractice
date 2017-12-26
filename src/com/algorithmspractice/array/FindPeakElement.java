package com.algorithmspractice.array;
//A peak element is an element that is greater than its neighbors.
//Given an input array where num[i] ≠ num[i+1], find a peak element and return its index.
//The array may contain multiple peaks, in that case return the index to any one of the peaks is fine.
//You may imagine that num[-1] = num[n] = -∞.
//For example, in array [1, 2, 3, 1], 3 is a peak element and your function should return the index number 2.

public class FindPeakElement {
    public static void main(String[] args) {
        System.out.println(findPeakElement(new int[]{1, 2, 3, 1}));
        System.out.println(findPeakElement(new int[]{1, 2, 3, 1, 4, 5, 6, 1}));
        System.out.println(findPeakElement(new int[]{1, 2, 3, 4, 5, 6, 7}));
        System.out.println(findPeakElement(new int[]{5, 4, 3, 2, 1}));
    }

    public static int findPeakElement(int[] nums) {
        int low = 0, high = nums.length -1, mid = 0;

        while(low < high){
            mid = (low+high)/2;
            if(nums[mid] > nums[mid +1]){
                high = mid;
            }else{
                low = mid+1;
            }
        }

        return low;
    }
}
