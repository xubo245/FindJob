package job.sohu.test11; /**
 * Created by xubo on 2016/8/6.
 */

import java.math.BigInteger;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {//注意while处理多个case
            String a = in.nextLine().toString();
            BigInteger input=in.nextBigInteger();
//            new StringBuffer()
//            int n = String.valueOf(a).length();
//            int m = in.nextInt();
            String intput2 = in.nextLine().toString();
            int m = Integer.valueOf(intput2);
            int i = a.length() - m;
            String value = compute(a, a.length(), m, i);
            if (m>=a.length()){
                System.out.println(0);
            }else{
            System.out.println(Integer.valueOf(value));}
        }
    }

    public static String compute(String a, int n, int m, int i) {

        if (m == 0) {
            return String.valueOf(a);
        }
        int max = 0;
        int maxIndex = 0;
        for (int j = 0; j <= m; j++) {
//            int aj = (a / ((int) Math.pow(10, n - j - 1))) % 10;
            String tmp = String.valueOf(a.charAt(j));

            int aj = Integer.valueOf(tmp);
            if (max < aj) {
                max = aj;
                maxIndex = j;
            }
        }
        String value;
        String b;
        if (maxIndex == 0) {
//            a = a % ((int) Math.pow(10, n - 1));
            a = a.substring(1, a.length());
            value = compute(a, n - 1, m - maxIndex, i);
        } else {
//            a = a % ((int) Math.pow(10, n - maxIndex));
            a = a.substring(maxIndex, a.length());
            value = compute(a, n - maxIndex, m - maxIndex, i);
        }
        if (m - maxIndex == 0) {
            if (value == null) {
                b = String.valueOf(max);

            } else {
                b = value;

            }
        } else {

            b = String.valueOf(max) + value;
        }
        i++;

        return b;
    }


}