package javaa.problems;

import java.util.Arrays;

/*
 * LeetCode: #31 A permutation of an array of integers is an arrangement of its members into a
 * sequence or linear order.
 * 
 * For example, for arr = [1,2,3], the following are all the permutations of arr: [1,2,3], [1,3,2],
 * [2, 1, 3], [2, 3, 1], [3,1,2], [3,2,1]. The next permutation of an array of integers is the next
 * lexicographically greater permutation of its integer. More formally, if all the permutations of
 * the array are sorted in one container according to their lexicographical order, then the next
 * permutation of that array is the permutation that follows it in the sorted container. If such
 * arrangement is not possible, the array must be rearranged as the lowest possible order (i.e.,
 * sorted in ascending order).
 * 
 * For example, the next permutation of arr = [1,2,3] is [1,3,2]. Similarly, the next permutation of
 * arr = [2,3,1] is [3,1,2]. While the next permutation of arr = [3,2,1] is [1,2,3] because [3,2,1]
 * does not have a lexicographical larger rearrangement. Given an array of integers nums, find the
 * next permutation of nums.
 * 
 * The replacement must be in place and use only constant extra memory.
 * 
 * Example 1: Input: nums = [1,2,3] Output: [1,3,2]
 * 
 * Example 2: Input: nums = [3,2,1] Output: [1,2,3]
 * 
 * Example 3: Input: nums = [1,1,5] Output: [1,5,1]
 */
public class NextPermutation {
    /*
     * Solution 1: Brute force - Find all the permutations and sort them asc, to find the next one.
     */
    /*
     * Solution 2:
     * 
     * Step 1: Find the decreasing element from Right -> Left
     * 
     * Step 2: Find the immediate next value for that decreasing element & swap it
     * 
     * Step 3: Sort the right elements in ascending order Step 4: If no descending order found, then
     * reverse the whole series & return
     */
    private static void nextPermutation(int[] nums) {
        int i = nums.length - 2; // pointer to begin with last before element - Right pointer
        // Step 1
        while (i >= 0 && nums[i] >= nums[i + 1]) {
            i--;
        }

        // Step 2:
        if (i >= 0) {
            int j = nums.length - 1;
            while (nums[i] >= nums[j]) {
                j--;
            }

            swap(nums, i, j);
        }

        // Step 3:
        reverse(nums, i + 1, nums.length - 1);
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    private static void reverse(int[] nums, int start, int end) {
        while (start < end) {
            swap(nums, start, end);
            start++;
            end--;
        }
    }

    public static void main(String[] args) {
        int[] arr1 = new int[] {1, 2, 3};
        int[] arr2 = new int[] {3, 2, 1};
        int[] arr3 = new int[] {1, 1, 5};
        System.out.println("Find Next Permutations for below numbers");
        System.out.println(Arrays.toString(arr1));
        System.out.println(Arrays.toString(arr2));
        System.out.println(Arrays.toString(arr3));

        nextPermutation(arr1);
        nextPermutation(arr2);
        nextPermutation(arr3);

        System.out.println("Next Permutations are...");
        System.out.println(Arrays.toString(arr1));
        System.out.println(Arrays.toString(arr2));
        System.out.println(Arrays.toString(arr3));
    }
}
