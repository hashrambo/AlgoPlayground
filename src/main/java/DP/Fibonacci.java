package DP;

/**
 * Created by hashrambo on 3/26/17.
 */
public class Fibonacci {


    /**
     * Fibonnaci function with memotization.
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     * @param n
     * @param mem
     * @return
     */
    public static int fib(int n, int [] mem) {

        if (n == 0)
            return 0;
        else if (n == 1)
            return 1;
        else {
            // memomtization is applied here to store the calculated fibonacci values
            // to avoid repeated calculations.
            mem[n] = fib(n-1, mem) + fib(n-2, mem);
            return mem[n];
        }
    }

    /**
     * Typical recursive fibonnaci function.
     * Time Complexity: O(2^n)
     * Space Complexity: O(n)
     * @param n
     * @return
     */
    public static int fib(int n) {
        if (n == 0)
            return 0;
        else if (n == 1)
            return 1;
        else
            return fib(n-1) + fib(n - 2);
    }


    public static void main(String[] args) {
        System.out.println(fib(10));

        final int [] mem = new int[11];
        System.out.println(fib(10, mem));

    }
}
