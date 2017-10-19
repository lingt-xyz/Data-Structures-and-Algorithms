import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;

/**
 * Created on 2017-01-29.
 *
 * Main class for testing Fibonacci calculator algorithms.
 * @author Ling Tan
 */
public class Drvier {

    public static void main(String[] args) {
        PrintWriter pw = null;
        try {
            pw = new PrintWriter(new FileOutputStream("out.txt"));
            long startTime, endTime, escapeTime;
            long result1, results[], result3;
            pw.println("Fibonacci\tBinary\tLinear\tTailRecursion\tResult");
            for (int i = 5; i <= 60; i += 5) {
                pw.print(i + "\t\t");
                startTime = System.currentTimeMillis();
                result1 = Fibonacci.BinaryFibonacci(i);
                endTime = System.currentTimeMillis();
                escapeTime = endTime - startTime;
                pw.print(escapeTime + "\t");
                startTime = System.currentTimeMillis();
                results = Fibonacci.LinearFibonacci(i);
                endTime = System.currentTimeMillis();
                escapeTime = endTime - startTime;
                pw.print(escapeTime + "\t");
                startTime = System.currentTimeMillis();
                result3 = Fibonacci.FibonacciTailRecursion(i, 0, 1);
                endTime = System.currentTimeMillis();
                escapeTime = endTime - startTime;
                pw.print(escapeTime + "\t\t");
                pw.println((result1 == results[0] && result1 == result3) ? result1 : "Error");
            }
        } catch (FileNotFoundException e) {
            System.out.printf("Unable to create out.txt, program will be terminated.");
        } finally {
            pw.close();
        }

    }
}
