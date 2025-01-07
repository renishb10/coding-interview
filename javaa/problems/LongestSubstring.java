package javaa.problems;

import java.util.HashMap;

/*
 * LeetCode: #3 Longest Substring without Repeating Characters Eg: Input: pwwkew Output: wke
 * 
 * Initialization: len: Keeps track of the maximum length of substrings without repeating
 * characters. left: Marks the starting position of the current sliding window. map: Tracks the last
 * index of each character encountered in the string.
 * 
 * Iteration: For every character at position right: If it has been seen before (exists in map),
 * update the left pointer to skip past the last occurrence of that character to ensure no
 * duplicates. Add or update the character's index in the map. Calculate the length of the current
 * window (right - left + 1) and update len if it's larger than the previous maximum.
 * 
 * Key Edge Cases: Empty string: Returns 0. All unique characters: The entire string is the longest
 * substring. All duplicates: The longest substring will be of length 1.
 */

public class LongestSubstring {

    // Function to find the length of the longest substring without repeating characters
    private static int longestString(String s) {
        int len = 0; // Stores the maximum length of the substring found
        int left = 0; // Left pointer of the sliding window
        HashMap<Character, Integer> map = new HashMap<>(); // To track the last seen position of
                                                           // characters

        // Iterate through the string with the right pointer
        for (int right = 0; right < s.length(); right++) {
            char ch = s.charAt(right); // Current character at the right pointer

            if (map.containsKey(ch)) { // If the character is a duplicate
                // Update the left pointer to the maximum of its current position
                // or the next position after the last occurrence of the duplicate character
                left = Math.max(left, map.get(ch) + 1);
            }

            // Update the character's latest index in the map
            map.put(ch, right);

            // Calculate the length of the current substring and update the maximum length
            len = Math.max(len, right - left + 1);
        }

        return len; // Return the maximum length of substring without repeating characters
    }

    public static void main(String[] args) {
        // Test case
        System.out.println(longestString("pwwkew")); // Output: 3 ("wke")
    }
}

