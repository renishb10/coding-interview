package javaa.problems;

/*
 * LeetCode: #50 Implement pow(x, n), which calculates x raised to the power n (i.e., x^n).
 * 
 * Example 1: Input: x = 2.00000, n = 10 Output: 1024.00000
 * 
 * Example 2: Input: x = 2.00000, n = -2 Output: 0.25000 Explanation: 2-2 = 1/22 = 1/4 = 0.25
 */
public class FindPowerOfN {
    private static double findPower(double x, int n) {
        long num = Math.abs((long) n);
        double result = 1.0;

        // Logic
        /*
         * Eg: 2^10 (where x = 2.0 and n = 10) Instead of looping 10 times We do a math logic, like
         * splitting/dividing the n by 2 so we can solve in logarthmic steps 2^10 can be 4^5 - here
         * we divide 10/2 and 2*2 i.e n/2 and x * x now 4^5 can be 16^2 - since n is Odd this time,
         * we subtract 1 and then divide it by 2, then x*x Each time on subtract, we multiply x to
         * the result variable now 16^2 can be 256^1, now 256^0, we exit
         */
        while (num != 0) {
            System.out.println(num);
            // If the num is an Odd number, we subtract by 1 to make it even
            if (num % 2 == 1) {
                result = result * x;
                num = num - 1;
            }
            x = x * x;
            num = num / 2; // when 2^1 num is 1, so 1/2 is 0, so the loop exits.
        }

        return n < 0 ? 1.0 / result : result;
    }

    public static void main(String[] args) {
        System.out.println(findPower(2.00000, 10));
        System.out.println(findPower(2.00000, -2));
        System.out.println(findPower(8.00000, 4));
    }
}
