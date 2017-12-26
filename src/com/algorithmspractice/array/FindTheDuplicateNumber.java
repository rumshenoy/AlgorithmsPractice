package com.algorithmspractice.array;
//Given an array nums containing n + 1 integers where each integer is between 1 and n (inclusive),
// prove that at least one duplicate number must exist. Assume that there is only one duplicate number, find the duplicate one.
//
//Note:
//You must not modify the array (assume the array is read only).
//You must use only constant, O(1) extra space.
//Your runtime complexity should be less than O(n2).
//There is only one duplicate number in the array, but it could be repeated more than once.

//Space complexity : O(1)
//Time complexity: O(n)
public class FindTheDuplicateNumber {
    public static void main(String[] args) {
        FindTheDuplicateNumber find = new FindTheDuplicateNumber();
        System.out.println(find.findDuplicate(new int[]{5, 4, 3, 2, 1, 2}));
        System.out.println(find.findDuplicate(new int[]{1, 4, 3, 2, 1, 5}));
    }
    public int findDuplicate(int[] nums) {
        int slow = nums[0];
        int fast = nums[0];

        do{
            slow = nums[slow];
            fast = nums[nums[fast]];
        }while(slow != fast);

        int ptr1 = nums[0], ptr2 = slow;
        while(ptr1 != ptr2){
            ptr1 = nums[ptr1];
            ptr2 = nums[ptr2];
        }

        return ptr1;
    }
}