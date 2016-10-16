package job.mi.exam1;//package main
//注意不要添加包名称，否则会报错。

import java.util.Scanner;

class Test {
}

public class Main {
    public static void main(String args[]) {
        Scanner cin = new Scanner(System.in);
        while (cin.hasNext()) {
            String input= cin.nextLine().toString();
            String[] a=input.split(" ");
            StringBuffer stringBuffer=new StringBuffer();
            for (int i=a.length-1;i>0;i--){
                stringBuffer.append(a[i]).append(" ");
            }
            stringBuffer.append(a[0]);
            System.out.println(stringBuffer.toString());
        }
    }
}
                       