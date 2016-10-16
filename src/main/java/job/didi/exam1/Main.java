package job.didi.exam1;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {//注意while处理多个case
            int n = in.nextInt();
            int ans = 0;
            for (int i = 1; i <= n; i++) {
                if (i % 5 == 0 ) {

                    ans++;
                }else if(i % 25 == 0){
                    ans++;
                }else if(i % 125 == 0){
                    ans++;
                }else if(i % 625 == 0){
                    ans++;
                }
            }
            System.out.println(ans);
//            BigInteger sum = BigInteger.valueOf(1);
//            for (int i = 1; i <= n; i++) {
//                sum = (BigInteger.valueOf(i)).multiply(sum);
//            }
//            int index = 10;
//            int length0 = 0;
//            while (sum.multiply(BigInteger.valueOf(10)).divideAndRemainder(BigInteger.valueOf(10))[0].equals(BigInteger.valueOf(0))) {
//                System.out.println(sum+":"+length0);
//                if (sum.divideAndRemainder(BigInteger.valueOf(index))[1].equals(BigInteger.valueOf(0))) {
//                    length0 = length0 + 1;
//                    index=index*10;
//                }else {
//                    break;
//                }
//
//            }
//            System.out.println(length0);
//            int b = in.nextInt();
//            System.out.println(a + b);
        }
    }
}