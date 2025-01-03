package javaa.problems;

import java.util.Arrays;

/*
 * LeetCode #412 Given an integer n, return a string Array answer (1-indexed) where
 * 
 * Eg: answer[1] = "1" answer[3] = "Fizz"
 */

public class FizzBuzz {
    private static String[] printFizzBuzz(int num) {
        String[] result = new String[num];

        for (int i = 0; i < num; i++) {
            int j = i + 1;
            String val = Integer.toString(j);

            if (j % 3 == 0 && j % 5 == 0) {
                val = "FizzBuzz";
            } else if (j % 3 == 0) {
                val = "Fizz";
            } else if (j % 5 == 0) {
                val = "Buzz";
            }

            result[i] = val;
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(printFizzBuzz(15)));
    }
}
