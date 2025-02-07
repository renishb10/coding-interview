package javaa.problems;

/*
 * LeetCode: #9 Given an integer x, return true if x is a palindrome, and false otherwise. Input: x
 * = 121; Output: true Input: x = -121; Output: false Hint: Without converting it to string
 */
public class PalindromeNumber {
    private static boolean findIsPalindromeNum(int num) {
        if (num < 0)
            return false;

        if (num != 0 && num % 10 == 0) // Numbers that ends with 0
            return false;

        int reversedHalf = 0;
        while (num > reversedHalf) { // To stop when we are in the middle of splitting
            int lastDigit = num % 10;
            reversedHalf = reversedHalf * 10 + lastDigit;
            num = num / 10;
        }

        return (num == reversedHalf) || (num == reversedHalf / 10); // If odd num, then reverse
                                                                    // might have
        // extra digit
    }

    public static void main(String[] args) {
        System.out.println(findIsPalindromeNum(121));
        System.out.println(findIsPalindromeNum(2112));
        System.out.println(findIsPalindromeNum(4));
    }
}
