package javaa.problems;

/*
 * LeetCode: #8 Find the longest palindromic substring Eg: Input: "babacd" Output: "bab" or "aba"
 */

/*
 * Solution - Brute Force (use two loop and use isPalindrome method which has another loop so it
 * takes O(n^3)) - Dynamic Programming (using memoization but uses extra space) - O(n^2) -
 * Manacher's Algorithm (O(n^2) but not expected to know) - Expansion Around Center - Take center
 * point and expand left & right to find the palindrom
 */

// Expansion Around Center
/*
 * This program finds the longest palindromic substring in a given string using the expand around
 * center approach. The key idea is to consider each character (or a pair of characters) in the
 * string as the center of a potential palindrome and expand outward until the palindrome condition
 * breaks. Center Expansion:
 * 
 * Palindromes have a center, which can be a single character (e.g., "aba") or two characters (e.g.,
 * "abba"). For every character in the string, the program attempts two types of expansions:
 * Odd-length palindrome (expandAroundCenter(s, i, i)). Even-length palindrome
 * (expandAroundCenter(s, i, i + 1)). Tracking Longest Palindrome:
 * 
 * The start and end variables keep track of the starting and ending indices of the longest
 * palindrome found so far. If a longer palindrome is found during the expansion, start and end are
 * updated. Efficiency:
 * 
 * The algorithm runs in 𝑂 ( 𝑛 2 ) O(n 2 ) time because for each character, we expand outward
 * until the palindrome condition breaks. It uses 𝑂 ( 1 ) O(1) space.
 */

public class LongestPalindromSubstring {
    // Variables to track the start and end indices of the longest palindrome
    static int start = 0, end = 0;

    // Method to find the longest palindromic substring
    private static String longestPalindrome(String s) {
        // Iterate over each character in the string
        for (int i = 0; i < s.length(); i++) {
            // Try to expand around a single character center (odd-length palindrome)
            expandAroundCenter(s, i, i);

            // Try to expand around a two-character center (even-length palindrome)
            expandAroundCenter(s, i, i + 1);
        }

        // Return the longest palindrome substring
        return s.substring(start, end + 1);
    }

    // Helper method to expand around the given center
    private static void expandAroundCenter(String s, int left, int right) {
        // Expand as long as the characters at the left and right indices are equal
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--; // Move left pointer outward
            right++; // Move right pointer outward
        }

        // Correct the indices to point to the valid palindrome substring
        left++;
        right--;

        // Update the start and end if the current palindrome is longer
        if (end - start + 1 < right - left + 1) {
            start = left; // Update start index
            end = right; // Update end index
        }
    }

    public static void main(String[] args) {
        // Test case
        System.out.println(longestPalindrome("babacd")); // Output: "aba"
    }
}

