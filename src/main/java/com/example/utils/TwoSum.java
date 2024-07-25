package com.example.utils;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {

    private static final System.Logger logger = System.getLogger(TwoSum.class.getName());

    public static int[] findTwoSum(int[] nums, int target) {
        Map<Integer, Integer> numMap = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];

            if (numMap.containsKey(complement)) {
                return new int[] { numMap.get(complement), i };
            }

            numMap.put(nums[i], i);
        }
        throw new IllegalArgumentException("No two sum solution");
    }

    public static void main(String[] args) {
        int[] nums = {10, 20, 15, 2, 23, 90, 67};
        int target = 90;

        int[] indices = findTwoSum(nums, target);

        System.out.println("Indices of the two numbers that add up to " + target + " are: " +
                indices[0] + " and " + indices[1]);
    }
}