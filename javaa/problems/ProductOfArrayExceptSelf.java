package javaa.problems;

import java.util.Arrays;

/*
 * Given an integer array nums, return an array answer such that answer[i] is equal to the product
 * of all the elements of nums except nums[i].
 * 
 * The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.
 * 
 * You must write an algorithm that runs in O(n) time and without using the division operation.
 * 
 * Example 1:
 * 
 * Input: nums = [1,2,3,4] Output: [24,12,8,6]
 * 
 * Example 2:
 * 
 * Input: nums = [-1,1,0,-3,3] Output: [0,0,9,0,0]
 */
public class ProductOfArrayExceptSelf {
    private static int[] productExceptSelf(int[] nums) {
        int[] prefixProducts = new int[nums.length];
        prefixProducts[0] = 1; // there is no element prefix to the first so start with 1
        for (int i = 1; i < nums.length; i++) {
            prefixProducts[i] = prefixProducts[i - 1] * nums[i - 1];
        }

        int suffixProduct = 1; // instead of an array we use variable and dynamically calculate
                               // product
        for (int i = nums.length - 1; i >= 0; i--) {
            prefixProducts[i] = prefixProducts[i] * suffixProduct; // instead of new answer array,
                                                                   // we use prefixProducts itself
            suffixProduct = suffixProduct * nums[i];
        }

        return prefixProducts;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(productExceptSelf(new int[] {1, 2, 3, 4})));
        System.out.println(Arrays.toString(productExceptSelf(new int[] {-1, 1, 0, -3, 3})));
    }
}
