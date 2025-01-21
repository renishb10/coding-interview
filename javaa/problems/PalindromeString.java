package javaa.problems;

/*
 * LeetCode: #125 Valid Palindrom (Using Two Pointers) A phrase is a palindrome if, after converting
 * all uppercase letters into lowercase letters and removing all non-alphanumeric characters, it
 * reads the same forward and backward. Alphanumeric characters include letters and numbers.
 * 
 * Given a string s, return true if it is a palindrome, or false otherwise.
 * 
 * Example 1:
 * 
 * Input: s = "A man, a plan, a canal: Panama" Output: true Explanation: "amanaplanacanalpanama" is
 * a palindrome.
 * 
 * Example 2:
 * 
 * Input: s = "race a car" Output: false Explanation: "raceacar" is not a palindrome.
 * 
 * Example 3:
 * 
 * Input: s = " " Output: true Explanation: s is an empty string "" after removing non-alphanumeric
 * characters. Since an empty string reads the same forward and backward, it is a palindrome.
 */
public class PalindromeString {
    private static boolean isPalindrome(String s) {
        if (s == null || s.length() <= 1) {
            return true;
        }

        int left = 0, right = s.length() - 1;
        while (left < right) {
            // Skip non-alphanumeric characters
            while (left < right && !Character.isLetterOrDigit(s.charAt(left))) {
                left++;
            }
            while (left < right && !Character.isLetterOrDigit(s.charAt(right))) {
                right--;
            }

            // Compare characters case-insensitively
            if (Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    // Solves the same but different style
    private static boolean isValidPalindrom(String s) {
        if (s == null || s.length() <= 1) {
            return true;
        }

        int left = 0, right = s.length() - 1;
        while (left < right) {
            // Skip non-alphanumeric characters from the left
            while (left < right && !Character.isLetterOrDigit(s.charAt(left))) {
                left++;
            }
            // Skip non-alphanumeric characters from the right
            while (left < right && !Character.isLetterOrDigit(s.charAt(right))) {
                right--;
            }

            // Compare characters case-insensitively
            if (Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))) {
                return false; // Mismatch found, not a palindrome
            }

            // Move pointers closer to the center
            left++;
            right--;
        }
        return true;
    }


    public static void main(String[] args) {
        System.out.println(isPalindrome("madam"));
        System.out.println(isPalindrome("world"));
        System.out.println(isValidPalindrom("madam"));
        System.out.println(isValidPalindrom("world"));
    }
}
