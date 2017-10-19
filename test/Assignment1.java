package test;

/**
 * Created on 2017-01-23.
 *
 * @author Ling Tan
 */
public class Assignment1 {
    private static int[] A={1,2,5,9};
    private static int[] B={2,29,40,57};
    private static int n=4;

    public static int getCount() {
        int count = 0;
        for (int i = 0; i <= n - 1; i++) {
            int sum = 0;
            for (int j = 0; j <= n - 1; j++) {
                sum = sum + A[0];
                for (int k = 1; k <= j; k++) {
                    sum = sum + A[k];
                    System.out.println(k + "loop");
                }
            }
            if (B[i] == sum) {
                count = count + 1;
            }
        }
        return count;
    }

    public static void main(String[] args) {

        System.out.println(getCount());
    }
}
