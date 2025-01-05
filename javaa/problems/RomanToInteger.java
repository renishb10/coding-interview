package javaa.problems;

import java.util.HashMap;
import java.util.Map;

/*
 * LeetCode: #13 Roman to Integer I = 1, V = 5, X = 10, L = 50, C = 100, D = 500, M = 1000 Eg:
 * Input: III Output: 3 Eg: Input: IV Output: 4 (here if left roman digit is lesser than right, then
 * it becomes negative value) Eg: Input: MCMXCIV Output: 1994
 */
public class RomanToInteger {
    private static int romanToInteger(String s) {
        Map<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);

        int result = 0;
        int len = s.length();
        for (int i = 0; i < len; i++) {
            if ()
        }
    }

    public static void main(String[] args) {
        System.out.println(romanToInteger("IV"));
        System.out.println(romanToInteger("MCMXCIV"));
    }
}
