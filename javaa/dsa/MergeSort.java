package javaa.dsa;

import java.util.Arrays;

public class MergeSort {
    public static void sort(int[] arr, int low, int high) {
        if (low >= high)
            return;

        int mid = (low + high) / 2; // Find the mid point to divide

        sort(arr, low, mid); // Divide left half
        sort(arr, mid + 1, high); // Divide right half

        merge(arr, low, mid, high);
    }

    public static void merge(int[] arr, int low, int mid, int high) {
        int[] temp = new int[high - low + 1];
        int left = low; // Start of left array
        int right = mid + 1; // Start of right array
        int index = 0;

        while (left <= mid && right <= high) {
            if (arr[left] <= arr[right]) {
                temp[index++] = arr[left++];
            } else {
                temp[index++] = arr[right++];
            }
        }

        while (left <= mid) {
            temp[index++] = arr[left++];
        }

        while (right <= high) {
            temp[index++] = arr[right++];
        }

        // Copy the sorted temp array back to the original array
        System.arraycopy(temp, 0, arr, low, temp.length);
    }

    public static void main(String[] args) {
        int[] arr1 = {6, 5, 3, 1, 8, 7, 2, 4};

        System.out.println("Before Sorting");
        System.out.println(Arrays.toString(arr1));

        sort(arr1, 0, arr1.length - 1);

        System.out.println("After Sorting");
        System.out.println(Arrays.toString(arr1));
    }
}
