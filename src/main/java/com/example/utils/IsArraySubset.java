package com.example.utils;

public class IsArraySubset {

    public static boolean isSubset(int[] arr1, int[] arr2, int m, int n) {
        // Iterate over each element in the second array
        for (int i = 0; i < n; i++) {
            boolean found = false;
            // Check if the element exists in the first array
            for (int j = 0; j < m; j++) {
                if (arr2[i] == arr1[j]) {
                    found = true;
                    break;
                }
            }
            // If any element is not found, return false
            if (!found) return false;
        }
        // If all elements are found, return true
        return true;
    }

    public static void main(String[] args) {
        int[] arr1 = {11, 1, 13, 21, 3, 7};
        int[] arr2 = {11, 3, 7, 1};
        int m = arr1.length;
        int n = arr2.length;

        if (isSubset(arr1, arr2, m, n)) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }
}