package javaa.problems;

import java.util.List;

/*
 * LeetCode: #41 Find the Missing Positive Number in an Array
 * 
 * Given an unsorted integer array nums. Return the smallest positive integer that is not present in
 * nums.
 * 
 * You must implement an algorithm that runs in O(n) time and uses O(1) auxiliary space.
 * 
 * Example 1:
 * 
 * Input: nums = [1,2,0] Output: 3 Explanation: The numbers in the range [1,2] are all in the array.
 * 
 * Example 2:
 * 
 * Input: nums = [3,4,-1,1] Output: 2 Explanation: 1 is in the array but 2 is missing.
 * 
 * Example 3:
 * 
 * Input: nums = [7,8,9,11,12] Output: 1 Explanation: The smallest positive integer 1 is missing.
 */
public class FindMissingPositive {
    private static int findMissingPositive(int[] nums) {
        /*
         * Step 1: Pre process the given array (change -ve and 0s to out of length) Step 2: Mark the
         * indexes Step 3: Find the first non-marked index
         */

        // step 1
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] <= 0) {
                nums[i] = nums.length + 1;
            }
        }

        // step 2
        for (int i = 0; i < nums.length; i++) {
            int index = Math.abs(nums[i]) - 1;
            if (index < nums.length && nums[index] > 0) {
                nums[index] = -1 * nums[index];
            }
        }

        // step 3
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                return i + 1;
            }
        }

        return nums.length + 1;
    }

    public static void main(String[] args) {
        System.out.println(findMissingPositive(new int[] {1, 2, 0}));
        System.out.println(findMissingPositive(new int[] {3, 4, -1, 1}));
        System.out.println(findMissingPositive(new int[] {7, 8, 9, 11, 12}));
    }
}
