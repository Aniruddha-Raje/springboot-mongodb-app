package com.example.utils;

public class FindPeak {

    private static final System.Logger logger = System.getLogger(FindPeak.class.getName());

    public static int findPeakElement(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }

        int left = 0, right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < nums[mid + 1]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return nums[left];
    }

    public static void main(String[] args) {
        int[] input = {10, 20, 15, 2, 23, 90, 67};
        int peak = findPeakElement(input);
        System.out.println("A peak element is: " + peak);
    }
}
