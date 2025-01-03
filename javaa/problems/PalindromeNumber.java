package javaa.problems;

/*
 * LeetCode: #9 Given an integer x, return true if x is a palindrome, and false otherwise. Input: x
 * = 121; Output: true Input: x = -121; Output: false Hint: Without converting it to string
 */
public class PalindromeNumber {
    private static boolean findIsPalindromeNum(int num) {
        if (num < 0)
            return false;

        if (num != 0 && num % 10 == 0)
            return false;

        int reverse = 0;
        while (num > reverse) { // To stop when we are in the middle of splitting
            int lastDigit = num % 10;
            reverse = reverse * 10 + lastDigit;
            num = num / 10;
            System.out.println("Num " + num);
            System.out.println("Reverse " + reverse);
        }

        return (num == reverse) || (num == reverse / 10); // If odd num, then reverse might have
                                                          // extra digit
    }

    public static void main(String[] args) {
        System.out.println(findIsPalindromeNum(121));
        System.out.println(findIsPalindromeNum(1212));
        System.out.println(findIsPalindromeNum(4));
    }
}
