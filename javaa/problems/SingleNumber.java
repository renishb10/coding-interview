package javaa.problems;

/*
 * LeetCode: #136 Given a non-empty array of integers nums, every element appears twice except for
 * one. Find that single one. Input: [2,2,1] Output: 1
 */
public class SingleNumber {
    /*
     * Solution 1: Using Set but it takes Space complexity of O(n) Solution 2: Using XOR Bit
     * Manipulation (Same numbers if XORed, we get 0)
     */
    private static int findSingleNumber(int[] nums) {
        int val = 0;
        for (int n : nums) {
            val = val ^ n;
        }

        return val;
    }

    public static void main(String[] args) {
        int[] nums = {2, 2, 1};
        System.out.println(findSingleNumber(nums));
        int[] nums2 = {4, 3, 1, 1, 4, 5, 5};
        System.out.println(findSingleNumber(nums2));
        int[] nums3 = {1};
        System.out.println(findSingleNumber(nums3));
    }
}
