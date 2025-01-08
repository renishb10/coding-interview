package javaa.problems;

/*
 * LeetCode: #273 Integers to Words Eg: Input 273; Output: Two Hundred Seventy Three Eg: Input
 * 5123456789; Output: Five Billion One Hundred Twenty Three Million Four Hundred Fifty Six Thousand
 * Seven Hundred Eighty Nine
 */

public class NumberToWords {
    // Arrays to store words for numbers
    private static final String[] BELOW_TWENTY = {"", "One", "Two", "Three", "Four", "Five", "Six",
            "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen",
            "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
    private static final String[] TENS =
            {"", "", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
    private static final String[] THOUSANDS =
            {"", "Thousand", "Million", "Billion", "Trillion", "Quadrillion", "Quintillion"};

    private static String numberToWords(long num) {
        if (num == 0)
            return "Zero";

        StringBuilder result = new StringBuilder();
        int i = 0;

        // process each group of three digits
        while (num > 0) {
            if (num % 1000 != 0) {
                result.insert(0, helper((int) (num % 1000)) + THOUSANDS[i] + " ");
            }
            num /= 1000;
            i++;
        }

        return result.toString().trim();
    }

    // Helper function to convert numbers less than 1000 (3 digits)
    private static String helper(int num) {
        if (num == 0) {
            return "";
        } else if (num < 20) {
            return BELOW_TWENTY[num] + " ";
        } else if (num < 100) {
            return TENS[num / 10] + " " + helper(num % 10);
        } else {
            return BELOW_TWENTY[num / 100] + " Hundred " + helper(num % 100);
        }
    }

    public static void main(String[] args) {
        // Test cases
        System.out.println(numberToWords(273)); // Output: Two Hundred Seventy Three
        System.out.println(numberToWords(5123456789L)); // Output: Five Billion One Hundred Twenty
                                                        // Three Million Four Hundred Fifty Six
                                                        // Thousand Seven Hundred Eighty Nine
        System.out.println(numberToWords(0)); // Output: Zero
        System.out.println(numberToWords(1000000000000L)); // Output: One Trillion
        System.out.println(numberToWords(9223372036854775807L));// Output: Nine Quintillion Two
                                                                // Hundred Twenty Three Quadrillion
                                                                // Two Hundred Three Trillion Six
                                                                // Hundred Eighty Five Billion Four
                                                                // Hundred Seventy Seven Million
                                                                // Five Hundred Eighty Thousand
                                                                // Seven
    }
}
