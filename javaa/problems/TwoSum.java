package javaa.problems;

import java.util.HashSet;
import java.util.Set;

public class TwoSum {
    public static void main(String[] args) {
        System.out.println(hasTwoSumPair(new int[]{2,1,9,6,3}, 7));
        System.out.println(hasTwoSumPair(new int[]{1,7,8,4,3}, 6));
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
}
