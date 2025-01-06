package javaa.problems;

/*
 * LeetCode: #242 Given two strings s and t, return true if t is an anagram of s, and false
 * otherwise.
 */

// Method 1: Works only for lowercase chars
public class ValidAnagram {
    private static boolean isValidAnagram(String s, String t) {
        if (s.length() != t.length())
            return false;

        int[] counter = new int[26];
        for (int i = 0; i < s.length(); i++) {
            counter[s.charAt(i) - 'a']++;
            counter[t.charAt(i) - 'a']--;
        }

        for (int count : counter) {
            if (count != 0)
                return false;
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println(isValidAnagram("aaac", "accc"));
        System.out.println(isValidAnagram("anagram", "nagaram"));
    }
}
