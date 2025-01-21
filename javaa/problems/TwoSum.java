package javaa.problems;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/*
 * LeetCode: #1 Given an array of integers nums and an integer target, return indices of the two
 * numbers such that they add up to target.
 * 
 * You may assume that each input would have exactly one solution, and you may not use the same
 * element twice.
 * 
 * You can return the answer in any order.
 * 
 * Example 1:
 * 
 * Input: nums = [2,7,11,15], target = 9 Output: [0,1] Explanation: Because nums[0] + nums[1] == 9,
 * we return [0, 1]. Example 2:
 * 
 * Input: nums = [3,2,4], target = 6 Output: [1,2] Example 3:
 * 
 * Input: nums = [3,3], target = 6 Output: [0,1]
 */
public class TwoSum {
    public static void main(String[] args) {
        System.out.println(hasTwoSumPair(new int[] {2, 1, 9, 6, 3}, 7));
        System.out.println(hasTwoSumPair(new int[] {1, 7, 8, 4, 3}, 6));
        System.out.println(Arrays.toString(twoSum(new int[] {2, 1, 9, 6, 3}, 7)));
        System.out.println(Arrays.toString(twoSum(new int[] {1, 7, 8, 5, 3}, 6)));
    }

    private static boolean hasTwoSumPair(int[] arr, int sum) {
        Set<Integer> seen = new HashSet<>();

        for (int num : arr) {
            int balance = sum - num;
            if (seen.contains(balance)) {
                return true;
            }

            seen.add(num);
        }

        return false;
    }

    private static int[] twoSum(int[] nums, int t) {
        int[] res = new int[2];
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int balance = t - nums[i];
            if (map.containsKey(balance)) {
                res[0] = map.get(balance);
                res[1] = i;
                break;
            } else {
                map.put(nums[i], i);
            }
        }
        return res;
    }
}
