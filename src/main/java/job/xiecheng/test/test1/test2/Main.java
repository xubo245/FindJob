package job.xiecheng.test.test1.test2;//package main
//注意不要添加包名称，否则会报错。

import java.util.Scanner;

public class Main {
    public static void main(String args[]) {
        Scanner cin = new Scanner(System.in);
        int n, m;
        while (cin.hasNextInt()) {
            m = cin.nextInt();
            n = cin.nextInt();
            boolean flag = false;
            for (int i = m; i <= n; i++) {
                int y1 = i / 100;
                int y2 = (i % 100) / 10;
                int y3 = (i % 10);
//                System.out.println(y1+":"+y2+":"+y3);
//                System.out.println(i == (Math.pow(y1, 3) + Math.pow(y2, 3) + Math.pow(y3, 3)));
                if (i == (Math.pow(y1, 3) + Math.pow(y2, 3) + Math.pow(y3, 3))) {
                    System.out.print(i + " ");
                    flag = true;
                }
            }
            if (flag == false) {
                System.out.println("no");
            } else {
                System.out.println();
            }

//            System.out.println(String.format("%1$.2f",sum));
        }
    }
}
