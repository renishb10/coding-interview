package javaa.problems;

/*
 * LeetCode: #12 Integer to Roman I = 1, V = 5, X = 10, L = 50, C = 100, D = 500, M = 1000 Eg:
 * Input: 2 Output: II Eg: Input: 10 Output: X Eg: Input: 9 Output: IX
 */
public class IntegerToRoman {
    private static String integerToRoman(int n) {
        int[] ints = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] romans = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        String result = "";

        for (int i = 0; i < ints.length; i++) {
            while (n >= ints[i]) {
                result += romans[i];
                n -= ints[i];
            }
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(integerToRoman(1994));
    }
}
