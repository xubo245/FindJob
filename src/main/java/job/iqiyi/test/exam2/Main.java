package job.iqiyi.test.exam2; /**
 * @author xubo
 */

import java.util.Scanner;

class Test {
}


public class Main {
    public static void main(String args[]) {
        Scanner cin = new Scanner(System.in);
        while (cin.hasNext()) {
            int n, m;
            n = cin.nextInt();
            m = cin.nextInt();
            double sum=0;
            double num=n;
            for (int i=0;i<m;i++){
                sum=sum+num;
                num=Math.sqrt(num);
            }
            System.out.printf("%.2f",sum);

        }
    }

    public static int compute() {
        int sum = 0;
        return sum;
    }
}
                       