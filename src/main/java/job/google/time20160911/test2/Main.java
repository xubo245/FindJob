package job.google.time20160911.test2;

import java.util.Scanner;

/**
 * Created by dieeasy on 2016/9/11.
 */
public class Main {
    public static void main(String args[]) {
        Scanner cin = new Scanner(System.in);
        int n, m;
        while (cin.hasNextInt()) {
            m = cin.nextInt();
            n = cin.nextInt();
//            int[] a = new int[n];
//            for (int i = 0; i < n; i++) {
//                a[i] = cin.nextInt();
//            }
            System.out.println(m+n);
        }
    }
}
