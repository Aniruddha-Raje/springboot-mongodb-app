package com.example.utils;

public class RemoveDuplicatesSortedArray {

    private static int removeDuplicates(int[] nums) {
        int arrLen = nums.length;

        /*
         * This index will move only when we modify the array in-place to include a new
         * non-duplicate element.
         */
        int j = 0;

        for (int i = 0; i < arrLen; i++) {
            /*
             * If the current element is equal to the next element, then skip the current
             * element because it's a duplicate.
             */
            if (i < arrLen - 1 && nums[i] == nums[i + 1]) {
                continue;
            }

            nums[j++] = nums[i];
        }

        return j;
    }

    public static void main(String[] args) {
        int[] nums = new int[] { 1, 1, 1, 3, 5, 5, 7 };
        int newLength = removeDuplicates(nums);

        System.out.println("Length of array after removing duplicates = " + newLength);

        System.out.print("Array = ");
        for (int i = 0; i < newLength; i++) {
            System.out.print(nums[i] + " ");
        }
        System.out.println();
    }
}
