package job.toutiao;//Java 语言
//package main
//注意不要添加包名称，否则会报错。

import java.util.Arrays;
import java.util.Scanner;

class Test {
}

public class Main {
    public static void main(String args[]) {
        Scanner cin = new Scanner(System.in);
        while (cin.hasNextInt()) {
            int n = cin.nextInt();
            int[] b = new int[n];
            for (int i = 0; i < n; i++) {
                b[i] = cin.nextInt();
            }
            Arrays.sort(b);
            boolean[] flag = new boolean[n];
            int result=compute(0,b.length,b, flag, 0);
            System.out.println(result);


//            for (int i = 0; i < n; i++) {
//                System.out.println(b[i]);
//            }
        }
    }

    public static int compute(int start,int end,int[] b, boolean[] flag, int sum) {
        for (int i=start;i<end;i++){
            if(i<end-1){
                if (b[i+1]-b[i]>10){
                    return (compute(start,i+1,b,flag,sum)+compute(i+1,end,b,flag,sum));
                }
            }else if(end-start>1){
                if (b[i]-b[i-1]>10){
                    return (compute(start,i+1,b,flag,sum)+2);
                }else {
                    return (3-(end-start)%3)%3;
                }
            }else {
                return 2;
            }
        }

//        for (int i = 0; i < b.length; i++) {
//            if (i < b.length - 2) {
//                if (b[i + 1] - b[i] <= 10 && flag[i] == false && flag[i + 1] == false) {
//                    if (b[i + 2] - b[i + 1] <= 10 && flag[i + 2] == false && flag[i + 1] == false) {
//                        flag[i] = true;
//                        flag[i + 1] = true;
//                        flag[i + 2] = true;
//                    } else if(b[i + 2] - b[i + 1] > 10 && flag[i + 2] == false && flag[i + 1] == false) {
//                        flag[i] = true;
//                        flag[i + 1] = true;
//                        sum++;
//                    }
//                } else if (b[i + 1] - b[i] > 10 && flag[i] == false && flag[i + 1] == false) {
//                    flag[i] = true;
//                    sum = sum + 2;
//                }
//            }
//        }
        return sum;
    }
}
                       