package javaa.dsa;

import java.util.Arrays;

public class SelectionSort {
    public static void sort(int[] arr) {
        int len = arr.length;

        for (int i = 0; i < len; i++) {
            int minIndex = i;

            for (int j = i + 1; j < len; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }

            // Only swap if the current index is not the minimum
            if (minIndex != i) {
                swapArrayItems(i, minIndex, arr);
            }
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
