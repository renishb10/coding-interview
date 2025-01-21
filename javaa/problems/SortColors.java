package javaa.problems;

import java.util.Arrays;

/*
 * LeetCode: #75 Sort Colors
 * 
 * Given an array nums with n objects colored red, white, or blue, sort them in-place so that
 * objects of the same color are adjacent, with the colors in the order red, white, and blue.
 * 
 * We will use the integers 0, 1, and 2 to represent the color red, white, and blue, respectively.
 * 
 * You must solve this problem without using the library's sort function.
 * 
 * Example 1: Input: nums = [2,0,2,1,1,0] Output: [0,0,1,1,2,2]
 * 
 * Example 2: Input: nums = [2,0,1] Output: [0,1,2]
 */
public class SortColors {
    // Algorithm used: Dutch National Flag algorithm (Three way partitioning)
    private static void sortColors(int[] nums) {
        int left = 0, mid = 0, right = nums.length - 1;

        while (mid <= right) {
            if (nums[mid] == 0) { // move it to front i.e left
                swap(nums, left, mid);
                left++;
                mid++;
            } else if (nums[mid] == 1) {
                // Mid should be 1, so we are good
                mid++;
            } else {
                swap(nums, mid, right);
                right--;
            }
        }
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        int[] arr1 = new int[] {2, 0, 2, 1, 1, 0};
        int[] arr2 = new int[] {2, 0, 1};

        System.out.println(Arrays.toString(arr1));
        System.out.println(Arrays.toString(arr2));

        sortColors(arr1);
        sortColors(arr2);

        System.out.println(Arrays.toString(arr1));
        System.out.println(Arrays.toString(arr2));
    }
}
