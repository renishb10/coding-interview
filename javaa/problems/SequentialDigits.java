package javaa.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * LeetCode: #1291 Sequential Digits - An integer has sequential digits if and only if each digit in
 * the number is one more than the previous digit.
 * 
 * Return a sorted list of all the integers in the range [low, high] inclusive that have sequential
 * digits.
 * 
 * Example 1:
 * 
 * Input: low = 100, high = 300 Output: [123,234]
 * 
 * Example 2:
 * 
 * Input: low = 1000, high = 13000 Output: [1234,2345,3456,4567,5678,6789,12345]
 */
public class SequentialDigits {
    private static List<Integer> sequentialIntegers(int low, int high) {
        List<Integer> result = new ArrayList<>();
        String digits = "123456789";

        int minLength = String.valueOf(low).length(); // if low is 100, start with 100
        int maxLength = String.valueOf(high).length(); // if high is 1000, end with 1000

        for (int length = minLength; length <= maxLength; length++) {
            for (int start = 0; start + length <= digits.length(); start++) {
                String sub = digits.substring(start, start + length);
                int num = Integer.parseInt(sub);

                if (num >= low && num <= high) {
                    result.add(num);
                }
            }
        }

        return result;

    }

    public static void main(String[] args) {
        System.out.println(sequentialIntegers(100, 300).toString());
        System.out.println(sequentialIntegers(1000, 13000).toString());
    }
}
