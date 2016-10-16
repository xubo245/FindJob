package job.xiecheng.exam.exam2;//package main
//注意不要添加包名称，否则会报错。

import java.util.Scanner;

public class Main {
    public static void main(String args[]) {
        Scanner cin = new Scanner(System.in);

        while (cin.hasNext()) {
            String m = cin.nextLine();
            String[] n = m.toString().split(",");
            int[] a = new int[n.length];

            for (int i = 0; i < n.length; i++) {
                a[i] = Integer.valueOf(n[i]);
            }
            System.out.println(compute(a));

//            for (int i : a) {
//                System.out.println(i);
//            }

        }
    }

    public static int compute(int[] a) {
        int[] b=new int[a.length-1];
        for (int i=0;i<a.length-1;i++){
            b[i]=a[i+1]-a[i];
        }
        int sum=0;
        int max=0;
        for (int i=0;i<b.length;i++){

            if (sum<0){
                sum=0;
            }else{
                sum=sum+b[i];
            }

            if (max<sum){
                max=sum;
            }


        }
        return max;
    }
}
