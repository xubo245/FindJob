package job.microsoft.exam.exam1;//package main
//注意不要添加包名称，否则会报错。

import java.util.Scanner;

class Test {
}

public class Main {
    public static void main(String args[]) {
        Scanner cin = new Scanner(System.in);
        int n;
        while (cin.hasNextInt()) {
            n = cin.nextInt();
            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = cin.nextInt();
            }
            int result = compute(a);
            System.out.println(result);
        }
    }

    public static int compute(int[] a) {
        int sum1 = 0;
        int sum2 = 0;

        for (int i = 0; i < a.length; i++) {
            if (a[i] % 2 == 0) {
                sum2++;
            } else {
                sum1++;
            }
        }
        return Math.abs(sum1 - sum2);
    }
}
                       