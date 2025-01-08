package javaa.problems;

/*
 * LeetCode: #151 Reverse words in the given sentence, remove extra spaces Step1: Reverse entire
 * string Step2: Reverse each word Step3: Clean up
 */
public class ReverseWordsInString {
    private static String reverseWordsInString(String s) {
        char[] str = s.toCharArray();

        // Step1: Reverse entire string
        reverseString(str, 0, str.length - 1);

        // Step2: Reverse each word
        reverseWords(str);

        // Step3: Clean spaces
        return cleanSpaces(str);
    }

    // Start two pointers. Left on 0 and Right on last Index
    private static void reverseString(char[] str, int left, int right) {
        while (left < right) {
            char tmp = str[left];
            str[left] = str[right];
            str[right] = tmp;
            left++;
            right--;
        }
    }

    // Start two pointers. Left and Right both from the beginning
    private static void reverseWords(char[] str) {
        int left = 0;
        int right = 0;
        while (left < str.length) {
            while (left < str.length && str[left] == ' ')
                left++;
            right = left;
            while (right < str.length && str[right] != ' ')
                right++;
            reverseString(str, left, right - 1);
            left = right;
        }
    }

    private static String cleanSpaces(char[] str) {
        int left = 0;
        int right = 0;
        while (right < str.length) {
            while (right < str.length && str[right] == ' ')
                right++;
            while (right < str.length && str[right] != ' ') {
                str[left] = str[right];
                left++;
                right++;
            }
            while (right < str.length && str[right] == ' ')
                right++;
            if (right < str.length) {
                str[left] = ' ';
                left++;
            }
        } // 0 to left - 1
        return new String(str).substring(0, left);
    }

    public static void main(String[] args) {
        System.out.println(reverseWordsInString(" the sky is  blue  "));
    }
}
