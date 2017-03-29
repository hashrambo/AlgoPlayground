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
    private static int fib(int n, int [] mem) {

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
    private static int fib(int n) {
        if (n == 0)
            return 0;
        else if (n == 1)
            return 1;
        else
            return fib(n-1) + fib(n - 2);
    }


    /**
     * Bottom up dynamic programming iterative solution.
     * Exact same computation.
     * Topological sort of subproblem dependency DAG.
     *
     *             +-------------------v
     * F_n-3 --> F_n-2 --> F_n-1 --> F_n
     *  +---------------------^
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     * @param n
     * @return
     */
    private static int fibBottomUp(int n) {

        int fib [] = new int [n];

        for (int i=0; i<n; i++) {
            if (i < 2)
                fib[i] = 1;
            else {
                fib [i] = fib[i - 1] + fib[i - 2];
            }
        }
        return fib[n-1];
    }


    public static void main(String[] args) {
        System.out.println(fib(10));

        final int [] mem = new int[11];
        System.out.println(fib(10, mem));

        System.out.println(fibBottomUp(10));

    }
}
