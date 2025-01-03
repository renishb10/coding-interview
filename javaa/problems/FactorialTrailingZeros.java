package javaa.problems;

/*
 * LeetCode: #172 Given an integer n return the number of trailing zeroes in n!. Note that n! = n *
 * (n - 1) * (n - 2) * (n - 3) * ... * 3 * 2 * 1. Eg: Input 3, Output 0, coz 3! = 6 no trailing zero
 * Eg: Input 5, Output 1, coz 5! = 120
 */
public class FactorialTrailingZeros {
    private static int findFactorialTrailingZeros(int num) {
        // Explain: 20! = 1 * 2 * 3 * 4 * 5 * 6 * 7 * 8 * 9 * 10 * 11 * 12 * 13 * 14 * 15 * 16 * 17
        // * 18 * 19 * 20;
        // We get zero only if we multiply by 10s or 5
        // Here checking by 5 satisfies both 5 & 10.
        // So for 20! it is 4 Zeros
        // BUT for 25! it is NOT 5 Zeros as we expect, instead it is 6 Zeros. How?
        // We need to check the how many 5s (Square Roots), so here.
        // We got 5, 10, 15, 20, 25 (5 * 5) = 6 5s coz 25 is 5^2
        // So if the num is larger, we need to take the number of 5s based on num >= numberOf5s
        int count = 0;
        int currPowerOfFive = 5;
        while (num >= currPowerOfFive) {
            count = count + (num / currPowerOfFive);
            currPowerOfFive *= 5;
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(findFactorialTrailingZeros(125));
    }
}
