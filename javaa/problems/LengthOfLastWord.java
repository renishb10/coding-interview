package javaa.problems;

/*
 * LeetCode: #58 Find the length of the last word in a sentence
 */
public class LengthOfLastWord {
    private static int lengthOfLastWord(String s) {
        int right = s.length() - 1;
        while (right >= 0 && s.charAt(right) == ' ') {
            right--;
        }
        int left = right;
        while (left >= 0 && s.charAt(left) != ' ') {
            left--;
        }

        return right - left;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLastWord(" the sky is blue  "));
        System.out.println(lengthOfLastWord("the"));
    }
}
