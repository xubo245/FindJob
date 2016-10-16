/**
 * @author xubo
 */
package job.indeed.exam3;

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
            int[] a=new int[n];
            for (int i=0;i<n;i++){
                a[i]=cin.nextInt();
            }

            System.out.println(compute(a,m));

        }
    }

    public static int compute(int[] a,int m) {
        int sum = 0;
        return sum;
    }
}
                       