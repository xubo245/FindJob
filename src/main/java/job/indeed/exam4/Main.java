package job.indeed.exam4; /**
 * @author xubo
 */

import java.util.Scanner;

class Test {
}


public class Main {
    public static void main(String args[]) {
        Scanner cin = new Scanner(System.in);
        while (cin.hasNext()) {
            int n, m;
            n = cin.nextInt();
            double result = compute(n);
            System.out.println(result);
        }
    }

    public static double compute(int n) {
        if (n <= 0) {
            return 0;
        } else if (n == 1) {
            return 1.0;
        } else if (n == 2) {
            return 1.0;
        } else if (n == 3) {
            return 5 / 3.0;
        } else if (n == 4) {
            return 2.0 / 1.0;
        }else if (n == 5) {
            return 9.0 / 5.0;
        }

        double sum = 0;
//        Random random = new Random();
//        int i = random.nextInt(n) + 1;
        int i = (n + 1) / 2;
        sum = (1 + compute(i - 2) + compute(n - i - 1)) / n;
        sum = sum + ((n - 1) / (double)n) * ((1 / 3.0) * ((2 + compute(n - (i + 2)) + compute(i - 3)) + (2 + compute(n - (i + 3)) + compute(i - 3)) + (2 + compute(n - (i + 2)) + compute(i - 4))));
        return sum;
    }
}
                       