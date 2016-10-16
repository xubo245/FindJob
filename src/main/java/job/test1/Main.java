package job.test1; /**
 * Created by xubo on 2016/8/6.
 */

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {//注意while处理多个case
            int a = in.nextInt();
//            System.out.println(fibonacci(a));
            int N=1000000;
            int num=1;

            int pre=a-1;
            int result=0;
            for (int i=1;i<=N;i++){
                num=Math.abs(a-fibonacci(i));
                if (num>pre){
                    result=pre;
                    break;
                }else{
                    pre=num;
                }

            }
            System.out.println(result);

        }
    }

    public static int compute(int a, int b) {
        return a + b;
    }

    public static int fibonacci(int n) {
        int result = 1;
        if (n == 1) {
            return 1;
        } else if (n == 2) {
            return 1;
        } else {
            return fibonacci(n - 1) + fibonacci(n - 2);
        }
    }

}