package javaa.problems;

import java.util.HashMap;

/*
 * Largest sub array with 0 sum
 *
 * Given an array having both positive and negative integers. The task is to compute the length of
 * the largest subarray with sum 0.
 * 
 * Eg: [15, -2, 2, -8, 1, 7, 10, 23]
 */
public class LargestSubarrayWith0Sum {
    private static int largestSubarrayWith0Sum(int[] nums) {
        int sum = 0, len = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (sum == 0) {
                len = i + 1;
            } else if (map.containsKey(sum)) {
                len = Math.max(len, i - map.get(sum));
            } else {
                map.put(sum, i);
            }
        }

        return len;
    }

    public static void main(String[] args) {
        System.out.println(largestSubarrayWith0Sum(new int[] {15, -2, 2, -8, 1, 7, 10, 23}));
    }
}
