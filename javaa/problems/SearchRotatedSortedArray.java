package javaa.problems;

/*
 * LeetCode: #33 Search in a Rotated Sorted Array There is an integer array nums sorted in ascending
 * order (with distinct values).
 * 
 * Prior to being passed to your function, nums is possibly rotated at an unknown pivot index k (1
 * <= k < nums.length) such that the resulting array is [nums[k], nums[k+1], ..., nums[n-1],
 * nums[0], nums[1], ..., nums[k-1]] (0-indexed). For example, [0,1,2,4,5,6,7] might be rotated at
 * pivot index 3 and become [4,5,6,7,0,1,2].
 * 
 * Given the array nums after the possible rotation and an integer target, return the index of
 * target if it is in nums, or -1 if it is not in nums.
 * 
 * Input: nums = [4,5,6,7,0,1,2], target = 0 Output: 4
 * 
 * Input: nums = [4,5,6,7,0,1,2], target = 3 Output: -1
 */
public class SearchRotatedSortedArray {
    private static int searchRotatedSortedArray(int[] nums, int t) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (t == nums[mid])
                return mid;

            // Left to Mid is Sorted
            if (nums[left] <= nums[mid]) {
                if (t >= nums[left] && t <= nums[mid])
                    right = mid - 1;
                else
                    left = mid + 1;
            } else { // Mid to Right is Sorted
                // And check if target is within the range
                if (t > nums[mid] && t <= nums[right])
                    left = mid + 1;
                else
                    right = mid - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr1 = new int[] {9, 8, 10, 12, 2, 3, 4, 5, 6, 7};
        System.out.println(searchRotatedSortedArray(arr1, 8));
    }
}
