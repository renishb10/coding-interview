package javaa.problems;

/*
 * LeetCode: #14 Find the longest common prefix string amongst an array of strings. If there is no
 * common prefix, return empty string. Eg: Input: ["flower", "flow", "flight"] Output: "fl" Eg:
 * Input: ["grow", "learn"] Output: ""
 */
public class LongestCommonPrefix {
    /*
     * Method: 1 Horizontal Scanning (Compares prefix of first string with each & shortens until it
     * matches all strings). Algorithm: Assume the prefix is the first string. Compare this prefix
     * with each string in the array. If the current string doesn't start with the prefix, reduce
     * the prefix by one character until it matches or becomes empty.
     */

    private static String lcmHorizontalScan(String[] strs) {
        if (strs == null || strs.length == 0)
            return "";

        // Assume the prefix is the first string
        String prefix = strs[0];

        for (int i = 1; i < strs.length; i++) {
            // indexOf Returns the first occurence, so if its not 0 then we proceed
            while (strs[i].indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length() - 1);
                if (prefix.isEmpty())
                    return "";
            }
        }

        return prefix;
    }

    /*
     * Method: 2 Binary search the length of the LCP by checking if all strings share a common
     * prefix of a given length. Algorithm: Find the minimum string length. Perform binary search on
     * the range [0, minLength]. For each middle point, check if all strings share the prefix.
     */
    private static String lcmBinarySearch(String[] strs) {
        if (strs == null || strs.length == 0)
            return "";

        int minLength = Integer.MAX_VALUE;
        for (String str : strs) {
            minLength = Math.min(minLength, str.length());
        }

        int low = 0, high = minLength;
        while (low < high) {
            int mid = (low + high + 1) / 2;
            if (isCommonPrefix(strs, mid)) {
                low = mid;
            } else {
                high = mid - 1; // go back to previous low
            }
        }

        return strs[0].substring(0, low);
    }

    private static boolean isCommonPrefix(String[] strs, int length) {
        String prefix = strs[0].substring(0, length); // Substring is 0 based
        System.out.println(prefix);
        for (int i = 0; i < strs.length; i++) {
            if (!strs[i].startsWith(prefix)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String[] strs = {"flower", "flow", "flight"};
        // System.out.println(lcmHorizontalScan(strs));
        System.out.println(lcmBinarySearch(strs));
    }
}
