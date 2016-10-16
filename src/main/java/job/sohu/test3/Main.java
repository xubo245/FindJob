package job.sohu.test3; /**
 * Created by xubo on 2016/8/6.
 */

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {//注意while处理多个case
            int n = in.nextInt();
            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = in.nextInt();
            }
            int result = compute(a);
            System.out.println(result);
        }
    }

    public static int compute(int[] a) {
        int sum = 0;
        int locat = 0;
        int i = 0;
        boolean flag = true;
        while (flag) {
            if (a[i] == 0) {
                return -1;
            }
            i = i + a[i];
            sum = sum + 1;
            if (i >= a.length) {
                return sum;
            }
        }
        return sum;
    }
}