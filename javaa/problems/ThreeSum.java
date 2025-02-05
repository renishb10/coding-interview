package javaa.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/*
 * LeetCode: #15 Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]]
 * such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.
 * 
 * Notice that the solution set must not contain duplicate triplets.
 */

public class ThreeSum {
    private static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums); // Sort the array to make it easier to handle duplicates
        List<List<Integer>> triplets = new ArrayList<>();

        for (int i = 0; i < nums.length - 2; i++) {
            // Skip duplicates for 'i' to ensure unique triplets
            if (i > 0 && nums[i] == nums[i - 1])
                continue;

            int left = i + 1, right = nums.length - 1;
            int target = -nums[i]; // Target value to sum to zero

            while (left < right) {
                int sum = nums[left] + nums[right];

                if (sum == target) {
                    // Add found triplet
                    triplets.add(Arrays.asList(nums[i], nums[left], nums[right]));

                    // Skip duplicates for left pointer
                    while (left < right && nums[left] == nums[left + 1])
                        left++;
                    // Skip duplicates for right pointer
                    while (left < right && nums[right] == nums[right - 1])
                        right--;

                    // Move both pointers inward
                    left++;
                    right--;
                } else if (sum < target) {
                    left++; // Increase sum by moving left pointer to a larger number
                } else {
                    right--; // Decrease sum by moving right pointer to a smaller number
                }
            }
        }
        return triplets;
    }

    public static void main(String[] args) {
        System.out.println("Three Sum");
        System.out.println(threeSum(new int[] {-1, 0, 1, 2, -1, -4}));
        System.out.println(threeSum(new int[] {0, 1, 1}));
        System.out.println(threeSum(new int[] {0, 0, 0}));
    }
}
