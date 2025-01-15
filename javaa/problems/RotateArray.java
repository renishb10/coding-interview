package javaa.problems;

/*
 * LeetCode: #189 Given an array, rotate the array to the right by k steps, where k is non-negative.
 */
public class RotateArray {
    private static void rotateArray(int[] nums, int k) {
        int n = nums.length;
        k = k % n; // Handle cases where k is greater than the array length

        // Step 1: Reverse the entire array
        reverse(nums, 0, n - 1);

        // Step 2: Reverse the first k elements
        reverse(nums, 0, k - 1);

        // Step 3: Reverse the remaining n-k elements
        reverse(nums, k, n - 1);
    }

    private static void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6, 7};
        int k = 3;

        System.out.println("Original Array: " + java.util.Arrays.toString(nums));
        rotateArray(nums, k);
        System.out.println("Rotated Array: " + java.util.Arrays.toString(nums));
    }
}
