package javaa.problems;

import java.util.HashSet;
import java.util.Set;

/*
 * LeetCode: #217 Contains Duplicate - Given an integer array nums, return true if any value appears
 * at least twice in the array, and return false if every element is distinct.
 * 
 * Use SET datastructure to solve
 */
public class ContainsDuplicate {
    private static boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();

        for (int i = 0; i < nums.length; i++) {
            if (set.contains(nums[i]))
                return true;
            else
                set.add(nums[i]);
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(containsDuplicate(new int[] {1, 2, 3, 4, 5}));
        System.out.println(containsDuplicate(new int[] {1, 2, 3, 4, 2}));
    }
}
