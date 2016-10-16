package job.xiecheng.exam.exam1;//package main
//注意不要添加包名称，否则会报错。

import java.util.Scanner;

public class Main {
    public static void main(String args[]) {
        Scanner cin = new Scanner(System.in);
        int n, m;
        while (cin.hasNextInt()) {
            m = cin.nextInt();
            n = cin.nextInt();
            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = cin.nextInt();
            }
            System.out.println(halfFind(m, a));
        }
    }

    public static int halfFind(int m, int[] a) {
        boolean flag = false;
        int index = 0;
        int out = 0;
        boolean indexFlag = false;
        for (int i = 0; i < a.length; i++) {
            if (indexFlag == false && a[i] > m) {
                indexFlag = true;
                if (i == 0) {
                    index = 0;
                } else {
                    index = i;
                }
            }
            if (a[i] == m) {
                flag = true;
                out = i;
                break;
            }
        }
        if (flag == false) {
            if (a[a.length - 1] < m) {

                //需要注意，大于最大数的时候运行情况
                index = a.length ;
            }else if(a[0]>m){
                index=0;
            }

            out = -1 - index;
        }
        return out;
    }
}
