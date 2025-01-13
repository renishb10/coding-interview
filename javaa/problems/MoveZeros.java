package javaa.problems;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/*
 * LeetCode: #283 Given an integer array nums, move all 0's to the end of it while maintaining the
 * relative order of the non-zero elements. Should be in-place without making a copy of the array.
 * Eg: Input: [0,1,0,3,12] Output: [1,3,12,0,0] Eg: Input: [0] Output: [0]
 */
public class MoveZeros {
    private static void moveZerosUsingQueue(int[] nums) {
        if (nums.length == 0)
            return;

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                queue.add(nums[i]);
            }
        }

        int index = 0;
        while (queue.size() != 0) {
            nums[index] = queue.poll();
            index++;
        }

        for (int i = index; i < nums.length; i++) {
            nums[i] = 0;
        }
    }

    private static void moveZerosUsingPointers(int[] nums) {
        if (nums.length == 1)
            return;

        int left = 0;
        for (int right = 0; right < nums.length; right++) {
            if (nums[right] != 0) {
                nums[left] = nums[right];
                left++;
            }
        }
        // from index; left to nums.length - 1, with 0s
        for (int i = left; i < nums.length; i++) {
            nums[i] = 0;
        }
    }

    public static void main(String[] args) {
        int[] arr1 = new int[] {0, 1, 0, 3, 12};
        moveZerosUsingQueue(arr1);
        System.out.println(Arrays.toString(arr1));
        int[] arr2 = new int[] {0, 1, 0, 3, 12};
        moveZerosUsingPointers(arr2);
        System.out.println(Arrays.toString(arr1));
    }
}
