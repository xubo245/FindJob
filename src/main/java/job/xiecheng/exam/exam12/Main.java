package job.xiecheng.exam.exam12;//注意不要添加包名称，否则会报错。

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
            System.out.println(halfFind(m, a, 0, a.length));
        }
    }

    public static int halfFind(int m, int[] a, int min, int max) {

        if (min == max && a[min] == m) {
            return min;
        } else if (min == max && a[min] < m) {
            return -1 - (min + 1);
        } else if (min == max && a[min] > m) {
            return -1 - min;
        }

        if (a[0] == m) {
            return 0;
        }
        if (a[a.length-1] == m) {
            return a.length;
        }

        if (a[(min + max) / 2] == m) {
            return (min + max) / 2;
        } else if (a[(min + max) / 2] < m) {
            if (m > a[a.length-1]) {
                return -1-a.length;
            }

            return halfFind(m, a, (min + max) / 2 + 1, max);
        } else {
            if (m < a[0]) {
                return -1;
            }
            return halfFind(m, a, min, (min + max) / 2 - 1);
        }
//        for (int i = min; i < max; i++) {
//            if (indexFlag == false && a[i] > m) {
//                indexFlag = true;
//                if (i == 0) {
//                    index = 0;
//                } else {
//                    index = i;
//                }
//            }
//            if (a[i] == m) {
//                flag = true;
//                out = i;
//                break;
//            }
//        }
//        if (flag == false) {
//            if (a[a.length - 1] < m) {
//                index = a.length - 1;
//            }else if(a[0]>m){
//                index=0;
//            }
//            out = -1 - index;
//        }
//        return out;
    }
}
