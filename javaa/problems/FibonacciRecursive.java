package javaa.problems;

public class FibonacciRecursive {

    public static int findFibonacciRecursive(int num) {
        if (num < 2)
            return num;

        return findFibonacciRecursive(num - 1) + findFibonacciRecursive(num - 2);
    }

    public static int findFibonacciIterative(int num) {
        if (num < 0) {
            throw new IllegalArgumentException("Fibonacci is undefined for negative numbers.");
        }
        if (num == 0)
            return 0;
        if (num == 1)
            return 1;

        int prev1 = 1, prev2 = 0, curr = 0;
        for (int i = 2; i <= num; i++) {
            curr = prev1 + prev2; // Fibonacci formula: F(n) = F(n-1) + F(n-2)
            prev2 = prev1; // Move prev1 to prev2
            prev1 = curr; // Move curr to prev1
        }
        return curr;
    }

    public static int findFibonacciIterative2(int num) {
        if (num < 0) {
            throw new IllegalArgumentException("Fibonacci is undefined for negative numbers.");
        }
        if (num == 0) {
            return 0;
        }
        if (num == 1) {
            return 1;
        }

        int[] series = new int[num + 1];
        series[0] = 0;
        series[1] = 1;

        for (int i = 2; i <= num; i++) {
            series[i] = series[i - 2] + series[i - 1];
        }

        return series[num];
    }

    public static int findFibonacciMemoized(int n, int[] memo) {
        if (memo[n] != 0)
            return memo[n];
        if (n == 1 || n == 2)
            return 1;
        else {
            memo[n] = findFibonacciMemoized(n - 1, memo) + findFibonacciMemoized(n - 2, memo);
            return memo[n];
        }
    }


    public static void main(String[] args) {
        // 0, 1, 1, 2, 3, 5, 8, 13, 21 = 2
        System.out.println(findFibonacciRecursive(3));
        System.out.println(findFibonacciRecursive(0));
        System.out.println(findFibonacciRecursive(8));
        System.out.println(findFibonacciIterative(3));
        System.out.println(findFibonacciIterative(0));
        System.out.println(findFibonacciIterative(8));
        System.out.println(findFibonacciIterative2(3));
        System.out.println(findFibonacciIterative2(0));
        System.out.println(findFibonacciIterative2(8));

        int n = 10;
        int[] memo = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            System.out.print(findFibonacciMemoized(i, memo) + " ");
        }
    }
}
