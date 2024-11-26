package javaa.dsa;

public class BinarySearch {
    public static boolean search(int[] arr, int val) {
        // Check if the array is empty
        if (arr == null || arr.length == 0) {
            return false;
        }

        // Initialize pointers
        int low = 0, high = arr.length - 1;

        // Perform binary search
        while (low <= high) { // Include the case where low == high
            // Prevent integer overflow (value more or equal to 2 billion)
            int mid = low + (high - low) / 2;

            if (arr[mid] == val) {
                return true; // Value found
            } else if (arr[mid] > val) {
                high = mid - 1; // Search in the left half
            } else {
                low = mid + 1; // Search in the right half
            }
        }

        // Value not found
        return false;
    }


    public static void main(String[] args) {
        int[] arr1 = {2, 4, 6, 7, 9, 13, 17, 23, 44};

        boolean result = search(arr1, 6);

        System.out.println("Search Result: " + result);
    }
}
