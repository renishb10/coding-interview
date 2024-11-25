package javaa.dsa;

import java.util.Arrays;

public class QuickSort {
    // Main sorting function
    public static void sort(int[] arr, int low, int high) {
        if (arr == null || arr.length <= 1) {
            return; // No sorting needed for null or single-element arrays
        }

        if (low < high) {
            int pivotIndex = partition(arr, low, high); // Find the pivot index
            sort(arr, low, pivotIndex - 1); // Recursively sort left half
            sort(arr, pivotIndex + 1, high); // Recursively sort right half
        }
    }

    // Partition the array and return the pivot index
    private static int partition(int[] arr, int low, int high) {
        int pivot = arr[high]; // Choose the last element as the pivot
        int i = low - 1; // Index for the smaller element

        for (int j = low; j < high; j++) {
            if (arr[j] <= pivot) {
                i++;
                swap(arr, i, j);
            }
        }

        // Place pivot in its correct position
        swap(arr, i + 1, high);
        return i + 1;
    }

    // Swap utility function
    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    // Main method to test the QuickSort implementation
    public static void main(String[] args) {
        int[] arr = {6, 5, 3, 1, 8, 7, 2, 4};

        System.out.println("Before Sorting:");
        System.out.println(Arrays.toString(arr));

        sort(arr, 0, arr.length - 1);

        System.out.println("After Sorting:");
        System.out.println(Arrays.toString(arr));
    }
}
