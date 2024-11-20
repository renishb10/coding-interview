package javaa.problems;

public class FactorialRecursive {
    public static int findFactorial(int num) {
        if (num < 2)
            return 1;
        return num * findFactorial(num - 1);
    }

    public static void main(String[] args) {
        int result = findFactorial(5);
        System.out.println(result);
    }
}
