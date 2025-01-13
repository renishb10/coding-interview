package javaa.problems;

import java.util.HashSet;
import java.util.Set;

public class FindDuplicateArrays {
    public static void main(String[] args) {
        int[] arr1 = {1, 2, 3, 4};
        int[] arr2 = {5, 4, 6, 9, 7};

        // O(n) solution using HashSet
        // O(a) Space complexity, we create new HashSet
        Boolean result = containsDuplicate(arr1, arr2);
        System.out.println(result ? "Array contains Duplicate" : "Array is Unique");
    }

    private static Boolean containsDuplicate(int[] arr1, int[] arr2) {
        Set<Integer> items = new HashSet<Integer>();
        for (int i : arr1) {
            items.add(i);
        }

        for (int j : arr2) {
            if (items.contains(j)) {
                return true;
            }
        }

        return false;
    }
}
