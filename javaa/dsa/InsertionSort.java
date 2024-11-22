package javaa.dsa;

import java.util.Arrays;

public class InsertionSort {
    public static void sort(int arr[]) {
        if (arr == null || arr.length <= 1) {
            return; // No sorting needed for null or single-element arrays
        }

        int len = arr.length;

        for (int i = 1; i < len; i++) {
            int key = arr[i];
            int j = i - 1;

            // Shift elements of arr[0..i-1] that are greater than key
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j]; // shifting to right
                j--;
            }

            // Place key in its correct position
            arr[j + 1] = key;
        }
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
