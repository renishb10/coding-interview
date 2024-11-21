package javaa.dsa;

import java.util.Arrays;

public class BubbleSort {
    public static void sort(int[] arr) {
        int len = arr.length;
        boolean needSorting;

        for (int pass = 0; pass < len - 1; pass++) {
            needSorting = false;

            // Only iterate through the unsorted portion
            for (int i = 0; i < len - pass - 1; i++) {
                if (arr[i] > arr[i + 1]) {
                    swapArrayItems(i, i + 1, arr);
                    needSorting = true;
                }
            }

            // If no swap break it
            if (!needSorting)
                break;
        }
    }

    private static void swapArrayItems(int i1, int i2, int[] arr) {
        int temp = arr[i1];
        arr[i1] = arr[i2];
        arr[i2] = temp;
    }

    public static void main(String[] args) {
        int[] arr1 = {6, 5, 3, 1, 8, 7, 2, 4};
        System.out.println("Before Sorting");
        System.out.println(Arrays.toString(arr1));

        sort(arr1);

        System.out.println("After Sorting");
        System.out.println(Arrays.toString(arr1));
    }
}
