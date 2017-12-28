package com.algorithmspractice.array;
import com.algorithmspractice.utils.HelperUtils;
//Find the kth largest element in an unsorted array.
// Note that it is the kth largest element in the sorted order, not the kth distinct element.
//For example,
//Given [3,2,1,5,6,4] and k = 2, return 5.
//
//Note:
//You may assume k is always valid, 1 ≤ k ≤ array's length.
public class KthLargestElementInAnArray {
    public static void main(String[] args) {
        System.out.println(findKthLargest(new int[]{3, 2, 1, 5, 6, 4}, 2));
        System.out.println(findKthLargest(new int[]{9, 8, 6, 5, 3, 4, 2}, 2));
        System.out.println(findKthLargest(new int[]{9, 8, 6, 5, 3, 4, 2}, 4));
        System.out.println(findKthLargest(new int[]{9, 8, 6, 5, 3, 4, 2}, 6));
    }

    public static int findKthLargest(int[] nums, int k) {
        int low = 0, high = nums.length-1;
        k = nums.length - k;

        while(low < high){
            int q = partition(nums, low, high);
            if(q==k){
                break;
            }
            if( q < k){
                low = q + 1;
            }else{
                high = q-1;
            }
        }

        return nums[k];
    }

    private static int partition(int[] nums, int l, int r) {
        int p = nums[r];
        for(int i = l; i < r; i++){
            if(nums[i] < p){
                HelperUtils.swap(nums, i, l);
                l++;
            }
        }

        HelperUtils.swap(nums, l, r);
        return l;
    }

}