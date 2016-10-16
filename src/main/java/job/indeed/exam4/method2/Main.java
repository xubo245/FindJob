package job.indeed.exam4.method2; /**
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
            boolean[] flag = new boolean[n];
            double result = compute(n, flag);
            System.out.println(result);
        }
    }

    public static double compute(int n, boolean[] flag) {
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
        }

        double sum = 0;
        if (!judge(flag)) {

        }

////        Random random = new Random();
////        int i = random.nextInt(n) + 1;
//        int i = (n + 1) / 2;
//        sum = (1 + compute(i - 2) + compute(n - i - 1)) / n;
//        sum = sum + ((n - 1) / (double)n) * ((1 / 3.0) * ((2 + compute(n - (i + 2)) + compute(i - 3)) + (2 + compute(n - (i + 3)) + compute(i - 3)) + (2 + compute(n - (i + 2)) + compute(i - 4))));
        return sum;
    }

    public static boolean judge(boolean[] flag) {
        for (int i = 1; i < flag.length - 1; i++) {
            if (flag[i] == false && flag[i - 1] == false && flag[i + 1] == false) {
                return false;
            }
        }
        if (flag[0] == false && flag[1] == false || flag[flag.length - 2] == false && flag[flag.length - 1] == false) {
            return false;
        }
        return true;
    }
}
                       