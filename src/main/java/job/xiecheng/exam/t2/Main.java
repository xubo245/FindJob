package job.xiecheng.exam.t2;//注意不要添加包名称，否则会报错。
//暴风降临的龙母丹妮莉丝·坦格利安要骑着她的龙以最快的速度游历各国，她的谋士们纷纷献策规划路线。作为她的谋士之一和仰慕者的你，决定冒险穿越到21世纪借助计算机来寻求最优路线。请设计一段程序，读取各国两两之间的距离，距离以邻接矩阵表示，并计算出遍历各国的最短路径长度。
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
//        boolean flag = false;
//        int index = 0;
//        int out = 0;
//        boolean indexFlag = false;

        if (min == max && a[min] == m) {
            return min;
//            if (a[min]==m){
//                return min;
//            }else if(min>m){
//                return min
//            }
        } else if (min == max && a[min] < m) {
            return -1 - (min + 1);
        } else if (min == max && a[min] > m) {
            return -1 - min;
        }

        if (a[a.length] == m) {
            return a.length;
        }
        if (a[0] == m) {
            return 0;
        }

        if (a[(min + max) / 2] == m) {
            return (min + max) / 2;
        } else if (a[(min + max) / 2] < m) {
            if (m > a[a.length]) {
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
