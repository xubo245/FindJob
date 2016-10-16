package job.iqiyi.test.exam1; /**
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
            boolean flag=false;
            for (int i=n;i<=m;i++){

                if (i==  Math.pow(i/100,3)+ Math.pow((i/10)%10,3)+ Math.pow(i%10,3)){
                    System.out.print(i+" ");
                    flag=true;
                }
            }
//            System.out.println();
            if (flag==false){
                System.out.println("no");;
            }

        }
    }

    public static int compute() {
        int sum = 0;
        return sum;
    }
}
                       