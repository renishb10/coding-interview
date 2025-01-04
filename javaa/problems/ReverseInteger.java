package javaa.problems;

/*
 * LeetCode: #7 Given a signed 32bit integer x, return x with its digits reversed. If x causes the
 * value to go outside of signed 32 bit integer range, then return 0. Environment does not allow
 * 64bit Eg: Input: 123, Output 321 Eg: Input: -123, Output -321
 */
public class ReverseInteger {
    private static int reverseInt(int val) {
        int min = Integer.MIN_VALUE;
        int max = Integer.MAX_VALUE;

        if (val == min || val == max)
            return 0;

        int rev = 0;
        while (val != 0) {
            int lastDigit = val % 10;
            if (rev > max / 10)
                return 0;
            if (rev < min / 10)
                return 0;
            rev = rev * 10 + lastDigit;
            val = val / 10;
        }

        return rev;
    }

    public static void main(String[] args) {
        System.out.println(reverseInt(-2147483647));
    }
}
