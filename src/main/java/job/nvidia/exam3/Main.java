package job.nvidia.exam3;//package main
//注意不要添加包名称，否则会报错。

import java.math.BigInteger;
import java.util.Scanner;

class Test {
}

public class Main {
    public static void main(String args[]) {
        Scanner cin = new Scanner(System.in);
        BigInteger a, b;
        while (cin.hasNext()) {
            String input=cin.nextLine().toString();
            String[] input1=input.split(" ");

            a = new BigInteger(input1[0]);
            b = new BigInteger(input1[1]);
            System.out.println(a.multiply(b));

        }
    }
}
                       