package job;

import java.math.BigInteger;

/**
 * Created by xubo on 2016/9/30.
 * 题目：
 * 斐波那契数列，在第1至1000个斐波那契数中有多少个可以整除7？？
 *
 *
 * 1 1 2 3 5 8 13 21 34 55。。。
 * 第8个可以整除7
 *
 * 定理：
 质数质量
 斐波那契数列的整除性与素数生成性
 每3个连续的数中有且只有一个被2整除，
 每4个连续的数中有且只有一个被3整除，
 每5个连续的数中有且只有一个被5整除，
 每6个连续的数中有且只有一个被8整除，
 每7个连续的数中有且只有一个被13整除，
 每8个连续的数中有且只有一个被21整除，
 每9个连续的数中有且只有一个被34整除，
 .......
 我们看到第5、7、11、13、17、23位分别是素数：5，13，89，233，1597，28657（第19位不是）
 *
 */

public class FibonacciPrime {
    public static void main(String[] args) {
        BigInteger a = BigInteger.valueOf(1);
        BigInteger b = BigInteger.valueOf(1);
        BigInteger f = BigInteger.valueOf(0);

        int sum=0;
        for(int i=3; i<=1000; i++){
            f=a.add(b);
            a=b;
            b=f;
            BigInteger xx=f.divideAndRemainder( BigInteger.valueOf(7))[1];
            System.out.println(i+":"+f+"=length"+f.bitLength()+"="+(f.divideAndRemainder( BigInteger.valueOf(7)))[1]);
            if (xx.equals(BigInteger.valueOf(0))){
                sum++;
            }
        }
        System.out.println(sum);
        System.out.println(Math.pow(2,694));
    }

}
