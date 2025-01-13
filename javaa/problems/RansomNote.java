package javaa.problems;

import java.util.HashMap;

/*
 * LeetCode: #383 Given two strings ransomNote and magazine, return true if ransomNote can be
 * constructed by using the letters from magazine and false otherwise.
 * 
 * Each letter in magazine can only be used once in ransomNote.
 * 
 * Example 1:
 * 
 * Input: ransomNote = "a", magazine = "b" Output: false
 * 
 * Example 2:
 * 
 * Input: ransomNote = "aa", magazine = "ab" Output: false
 * 
 * Example 3:
 * 
 * Input: ransomNote = "aa", magazine = "aab" Output: true
 */
public class RansomNote {
    // Instead of maintaining two HASHMAPs, we can go for Array of size 26
    private static boolean checkRansomNote(String ransom, String magazine) {
        int[] frequency = new int[26]; // by default int array has all 0s
        for (int i = 0; i < magazine.length(); i++) {
            char c = magazine.charAt(i);
            frequency[c - 'a']++; // ascii of a is 97, so 97 - 97 gives 0
        }
        for (int i = 0; i < ransom.length(); i++) {
            char c = ransom.charAt(i);
            if (frequency[c - 'a'] == 0)
                return false;

            frequency[c - 'a']--;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(checkRansomNote("aa", "ab"));
        System.out.println(checkRansomNote("aa", "aab"));
    }
}
