package javaa.problems;

import java.util.ArrayList;
import java.util.List;

/*
 * LeetCode: #442 Find All Duplicates Numbers in an Array
 * 
 * Given an integer array nums of length n where all the integers of nums are in the range [1, n]
 * and each integer appears at most twice, return an array of all the integers that appears twice.
 * 
 * You must write an algorithm that runs in O(n) time and uses only constant auxiliary space,
 * excluding the space needed to store the output
 * 
 * Example 1:
 * 
 * Input: nums = [4,3,2,7,8,2,3,1] Output: [2,3]
 * 
 * Example 2:
 * 
 * Input: nums = [1,1,2] Output: [1]
 * 
 * Example 3:
 * 
 * Input: nums = [1] Output: []
 */
public class FindAllDuplicatesInArray {

    private static List<Integer> findAllDuplicatesInArray(int[] nums) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int index = Math.abs(nums[i]) - 1;
            if (nums[index] < 0) {
                list.add(Math.abs(nums[i]));
            }
            if (nums[index] > 0) {
                nums[index] = -1 * nums[index];
            }
        }

        return list;
    }

    public static void main(String[] args) {
        System.out.println(findAllDuplicatesInArray(new int[] {4, 3, 2, 7, 8, 2, 3, 1}));
        System.out.println(findAllDuplicatesInArray(new int[] {1, 1, 2}));
        System.out.println(findAllDuplicatesInArray(new int[] {1}));
    }
}
