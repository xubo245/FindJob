//package sohu.test1; /**
// * Created by xubo on 2016/8/6.
// */
//
//import java.math.BigInteger;
//import java.util.Scanner;
//
//public class Main {
//    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        while (in.hasNext()) {//注意while处理多个case
//            BigInteger a = in.nextBigInteger();
//
//            int n = String.valueOf(a).length();
//            int m = in.nextInt();
//            int i = n - m;
//            String value = compute(a, n, m, i);
//            System.out.println(Integer.valueOf(value));
//        }
//    }
//
//    public static String compute(int a, int n, int m, int i) {
//
//        if (m == 0) {
//            return String.valueOf(a);
//        }
//        int max = 0;
//        int maxIndex = 0;
//        for (int j = 0; j <= m; j++) {
//            int aj =  (a / ((int) Math.pow(10, n - j - 1))) % 10;
//            if (max < aj) {
//                max = aj;
//                maxIndex = j;
//            }
//        }
//        String value;
//        String b;
//        if (maxIndex == 0) {
//            a = a % ((int) Math.pow(10, n - 1));
//            value = compute(a, n - 1, m - maxIndex, i);
//        } else {
//            a = a % ((int) Math.pow(10, n - maxIndex));
//            value = compute(a, n - maxIndex, m - maxIndex, i);
//        }
//        if (m - maxIndex == 0) {
//            b =value;
//        } else {
//
//            b = String.valueOf(max) + value;
//        }
//        i++;
//
//        return b;
//    }
//
//
//}