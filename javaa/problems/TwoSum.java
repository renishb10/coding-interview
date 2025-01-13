package javaa.problems;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class TwoSum {
    public static void main(String[] args) {
        System.out.println(hasTwoSumPair(new int[] {2, 1, 9, 6, 3}, 7));
        System.out.println(hasTwoSumPair(new int[] {1, 7, 8, 4, 3}, 6));
        System.out.println(Arrays.toString(twoSum(new int[] {2, 1, 9, 6, 3}, 7)));
        System.out.println(Arrays.toString(twoSum(new int[] {1, 7, 8, 5, 3}, 6)));
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

    private static int[] twoSum(int[] nums, int t) {
        int[] res = new int[2];
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int balance = t - nums[i];
            if (map.containsKey(balance)) {
                res[0] = map.get(balance);
                res[1] = i;
                break;
            } else {
                map.put(nums[i], i);
            }
        }
        return res;
    }
}
