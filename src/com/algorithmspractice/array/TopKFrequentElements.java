package com.algorithmspractice.array;
//Given a non-empty array of integers, return the k most frequent elements.
//        For example,
//        Given [1,1,1,2,2,3] and k = 2, return [1,2].
//
//        Note:
//        You may assume k is always valid, 1 ≤ k ≤ number of unique elements.
//        Your algorithm's time complexity must be better than O(n log n), where n is the array's size.

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TopKFrequentElements {
    public static void main(String[] args) {
        System.out.println(topKFrequent(new int[]{1, 1, 1, 2, 2, 3, 5, 4, 4, 3, 3}, 2));
    }

    public static List<Integer> topKFrequent(int[] nums, int k){
        Map<Integer, Integer> map = new HashMap<>();

        for(int i =0; i < nums.length; i++){
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }

        //bucket sort
        List<Integer>[] bucket = new ArrayList[nums.length + 1];

        for(Integer key: map.keySet()){
            int value = map.get(key);
            if(bucket[value] == null){
                bucket[value] = new ArrayList<>();
            }
            bucket[value].add(key);
        }

        List<Integer> result = new ArrayList<>();
        for(int i = bucket.length-1; i >=0 && result.size() <k ; i--){
            if(bucket[i] != null){
                result.addAll(bucket[i]);
            }
        }
        return result;
    }
}
