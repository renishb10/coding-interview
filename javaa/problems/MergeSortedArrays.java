package javaa.problems;

import java.util.ArrayList;
import java.util.List;

public class MergeSortedArrays {

    public static void main(String[] args) {
        int[] arr1 = new int[]{2, 3, 5, 7, 20};
        int[] arr2 = new int[]{-1, 5, 15, 17, 40, 120};

        System.out.println(mergeSortedArrays(arr1, arr2));
    }

    private static List<Integer> mergeSortedArrays(int[] arr1, int[] arr2) {
        List<Integer> mergedArray = new ArrayList<>();

        int i = 0;
        int j = 0;

        // Merge elements from both arrays in sorted order
        while (i < arr1.length && j < arr2.length) {
            if (arr1[i] < arr2[j]) {
                mergedArray.add(arr1[i++]);
            } else {
                mergedArray.add(arr2[j++]);
            }
        }

        // Add any remaining elements from arr1 or arr2
        addRemainingElements(mergedArray, arr1, i);
        addRemainingElements(mergedArray, arr2, j);

        return mergedArray;
    }

    // Helper method to add remaining elements
    private static void addRemainingElements(List<Integer> mergedArray, int[] arr, int index) {
        while (index < arr.length) {
            mergedArray.add(arr[index++]);
        }
    }
}