package javaa.problems;

import java.util.HashSet;
import java.util.Set;

public class FirstRecurringItem {
    public static void main(String[] args) {
        int[] arr = new int[]{ 2, 3, 7, 2, 5, 4, 10};

        System.out.println(firstRecurringItem(arr));
    }

    private static int firstRecurringItem(int[] arr) {
        Set<Integer> items = new HashSet<>();

        for (int i : arr) {
            if (!items.add(i)) { // Add returns false if item already exists
                return i;
            }
        }

        return -1;
    }
}
