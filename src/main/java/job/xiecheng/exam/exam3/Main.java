package job.xiecheng.exam.exam3;//注意不要添加包名称，否则会报错。
//暴风降临的龙母丹妮莉丝·坦格利安要骑着她的龙以最快的速度游历各国，
// 她的谋士们纷纷献策规划路线。作为她的谋士之一和仰慕者的你，
// 决定冒险穿越到21世纪借助计算机来寻求最优路线。
// 请设计一段程序，读取各国两两之间的距离，距离以邻接矩阵表示，
// 并计算出遍历各国的最短路径长度。
//第一行:国家数量,假设为n 后续n行是国家间距离的邻接矩阵表示
//求最短路径
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
        }
    }
}
