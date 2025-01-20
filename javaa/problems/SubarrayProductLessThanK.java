package javaa.problems;

/*
 * LeetCode: #713 Given an array of integers nums and an integer k, return the number of contiguous
 * subarrays where the product of all the elements in the subarray is strictly less than k.
 * 
 * Example 1:
 * 
 * Input: nums = [10,5,2,6], k = 100 Output: 8 Explanation: The 8 subarrays that have product less
 * than 100 are: [10], [5], [2], [6], [10, 5], [5, 2], [2, 6], [5, 2, 6] Note that [10, 5, 2] is not
 * included as the product of 100 is not strictly less than k.
 * 
 * Example 2:
 * 
 * Input: nums = [1,2,3], k = 0 Output: 0
 * 
 * 
 * Constraints:
 * 
 * 1 <= nums.length <= 3 * 104 1 <= nums[i] <= 1000 0 <= k <= 106
 */
public class SubarrayProductLessThanK {
    private static int numSubarrayProductLessThanK(int[] nums, int k) {
        int prod = 1, count = 0, left = 0;
        for (int right = 0; right < nums.length; right++) {
            prod *= nums[right];
            // Shrink the pointers, if the product is higher or equal
            while (left <= right && prod >= k) {
                prod /= nums[left]; // Deduct the left value, that increases the product value more
                                    // than k by dividing.
                left++;
            }
            count += right - left + 1;
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(numSubarrayProductLessThanK(new int[] {10, 5, 2, 6}, 100));
        System.out.println(numSubarrayProductLessThanK(new int[] {1, 2, 3}, 0));
    }
}
