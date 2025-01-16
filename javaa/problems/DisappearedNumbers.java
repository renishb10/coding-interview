package javaa.problems;

import java.util.ArrayList;
import java.util.List;

/*
 * LeetCode: #448 Find Disappeared Numbers in an Array Given an array nums of n integers where
 * nums[i] is in the range [1, n], return an array of all the integers in the range [1, n] that do
 * not appear in nums.
 * 
 * Example 1:
 * 
 * Input: nums = [4,3,2,7,8,2,3,1] Output: [5,6]
 * 
 * Example 2:
 * 
 * Input: nums = [1,1] Output: [2]
 */
public class DisappearedNumbers {
    private static List<Integer> findDisappearedNumbers(int[] nums) {
        // Mark the visited index (make it negative)
        for (int i = 0; i < nums.length; i++) {
            int index = Math.abs(nums[i]) - 1;
            if (nums[index] > 0) {
                nums[index] = -1 * nums[index];
            }
        }

        // Check not marked index
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                list.add(i + 1);
            }
        }

        return list;
    }

    public static void main(String[] args) {
        System.out.println(findDisappearedNumbers(new int[] {4, 3, 2, 7, 8, 2, 3, 1}));
        System.out.println(findDisappearedNumbers(new int[] {1, 1}));
    }
}
