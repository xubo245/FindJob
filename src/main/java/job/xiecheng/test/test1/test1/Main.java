package job.xiecheng.test.test1.test1;//package main
//注意不要添加包名称，否则会报错。

import java.util.Scanner;

class Test {
}

public class Main
{
    public static void main(String args[])
    {
        Scanner cin = new Scanner(System.in);
        int n, m;
        while(cin.hasNextInt())
        {
            n = cin.nextInt();
            m = cin.nextInt();
            double x=(double)n;
            double sum=0;
            for(int i=0;i<m;i++){
                sum=sum+x;
                x=Math.sqrt(x);
            }
            System.out.println(String.format("%1$.2f",sum));
        }
    }
}
