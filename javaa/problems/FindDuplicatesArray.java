package javaa.problems;

import java.util.HashMap;

public class FindDuplicatesArray {
    public static void main(String[] args) {
        int[] arr1 = {1, 2, 3, 4};
        int[] arr2 = {5, 0, 6, 9, 7};

        // O(n) solution using HashMap
        Boolean result = containsDuplicate(arr1, arr2);
        System.out.println(result ? "Array contains Duplicate" : "Array is Unique");
    }

    private static Boolean containsDuplicate(int[] arr1, int[] arr2) {
        HashMap<Integer, Boolean> map = new HashMap<Integer, Boolean>();
        for (int i : arr1) {
            if (!map.containsKey(i)) {
                map.put(i, true);
            }
        }

        for (int j : arr2) {
            if (map.containsKey(j)) {
                return true;
            }
        }

        return false;
    }
}