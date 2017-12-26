package com.algorithmspractice.array;

import com.algorithmspractice.utils.HelperUtils;

import java.util.Random;

// Init an array with set 1, 2, and 3.
//int[] nums = {1,2,3};
//Solution solution = new Solution(nums);
//
//// Shuffle the array [1,2,3] and return its result. Any permutation of [1,2,3] must equally likely to be returned.
//solution.shuffle();
//
//// Resets the array back to its original configuration [1,2,3].
//solution.reset();
//
//// Returns the random shuffling of array [1,2,3].
//solution.shuffle();
public class ShuffleAnArray {

    int[] original;
    int[] array;
    Random random = new Random();

    public static void main(String[] args) {
        ShuffleAnArray shuffleAnArray = new ShuffleAnArray(new int[]{1, 2, 3, 4});
        HelperUtils.printArray(shuffleAnArray.shuffle());
        HelperUtils.printArray(shuffleAnArray.reset());
        HelperUtils.printArray(shuffleAnArray.shuffle());
        HelperUtils.printArray(shuffleAnArray.shuffle());
    }

    private int returnRandom(int min, int max){
        return (random.nextInt(max - min) + min);
    }

    public ShuffleAnArray(int[] nums){
        original = nums;
        array = original.clone();
    }

    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        array = original.clone();
        return array;
    }
    /** Returns a random shuffling of the array. */
    public int[] shuffle() {
        for(int i =0; i < array.length; i++){
            swap(i, returnRandom(i, array.length));
        }
        return array;
    }

    public void swap(int i, int j){
        int temp = array[i];
        array[i] = array[j];
        array[j] =temp;
    }
}
