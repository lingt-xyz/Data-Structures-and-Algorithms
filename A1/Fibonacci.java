/**
 * Created on 2017-01-23.
 *
 * Three algorithms for calculating Fibonacci number.
 *
 * @author Ling Tan
 */

public class Fibonacci {
    /**
     * Returns the n-th Fibonacci number (inefficiently).
     *
     * @param n the n-the Fibonacci number we want to compute
     * @return the n-th Fibonacci number
     */
    public static long BinaryFibonacci(int n) {
        if (n <= 1) {
            return n;
        } else {
            return BinaryFibonacci(n - 2) + BinaryFibonacci(n - 1);
        }
    }

    /**
     * Returns array containing the pair of Fibonacci numbers, F(n) and F(n−1).
     *
     * @param n the n-the Fibonacci number we want to compute
     * @return the array consisting of n-the Fibonacci number and the(n-1)-th Fibonacci number
     */
    public static long[] LinearFibonacci(int n) {
        if (n <= 1) {
            long[] answer = {n, 0};
            return answer;
        } else {
            long[] temp = LinearFibonacci(n - 1);           //return {Fn-1, Fn-2}
            long[] answer = {temp[0] + temp[1], temp[0]};   //we want {Fn, Fn-1}
            return answer;
        }
    }

    /**
     * FibonacciTailRecursion(2, 0, 1)
     * Returns the n-th Fibonacci number
     *
     * @param n the n-the Fibonacci number we want to compute. It means we need to calculate n times.
     * @param the smaller fibonacci number
     * @param the bigger fibonacci number
     * @return the n-th Fibonacci number
     */
    public static long FibonacciTailRecursion(int n, long first, long second) {
        if (n <= 1) {
            return first;
        } else {
            return FibonacciTailRecursion(n - 1, second, first + second);
        }
    }

}
