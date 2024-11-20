package javaa.problems;

public class StringReversal {
    public static String reverseStringRecursive(String str) {
        if (str.isEmpty()) {
            return "";
        } else {
            // Recursive calls - take h, take e, take l etc
            // Stack unwind - take d, take l, take r etc
            return reverseStringRecursive(str.substring(1)) + str.charAt(0);
        }
    }

    public static String reverseStringIterative(String str) {
        StringBuilder rStr = new StringBuilder();
        for (int i = str.length() - 1; i >= 0; i--) {
            rStr.append(str.charAt(i));
        }

        return rStr.toString();
    }

    // Using Two pointers
    public static String reverseStringIterative2(String str) {
        char[] charArr = str.toCharArray();
        int left = 0, right = charArr.length - 1;

        while (left < right) {
            char temp = charArr[left];
            charArr[left] = charArr[right];
            charArr[right] = temp;

            left++;
            right--;
        }

        return new String(charArr);
    }

    public static void main(String[] args) {
        System.out.println(reverseStringRecursive("hello world"));
        System.out.println(reverseStringIterative("hello world"));
        System.out.println(reverseStringIterative2("hello world"));
    }
}
