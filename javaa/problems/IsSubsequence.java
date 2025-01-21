package javaa.problems;

/*
 * LeetCode: #40 IsSubsequence
 * 
 * Given two strings s and t, return true if s is a subsequence of t, or false otherwise.
 * 
 * A subsequence of a string is a new string that is formed from the original string by deleting
 * some (can be none) of the characters without disturbing the relative positions of the remaining
 * characters. (i.e., "ace" is a subsequence of "abcde" while "aec" is not).
 * 
 * Example 1: Input: s = "abc", t = "ahbgdc" Output: true
 * 
 * Example 2: Input: s = "axc", t = "ahbgdc" Output: false
 * 
 * Constraints:
 * 
 * 0 <= s.length <= 100 0 <= t.length <= 104 s and t consist only of lowercase English letters.
 */
public class IsSubsequence {
    private static boolean isSubsequence(String s, String t) {
        int left = 0, right = 0;
        while (left < s.length() && right < t.length()) {
            if (s.charAt(left) == t.charAt(right)) {
                left++;
                right++;
            } else {
                right++;
            }
        }
        return left == s.length();
    }

    public static void main(String[] args) {
        System.out.println(isSubsequence("abc", "ahbgdc"));
        System.out.println(isSubsequence("axc", "ahbgdc"));
    }
}
