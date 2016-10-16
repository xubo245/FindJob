package job.sohu.test2; /**
 * Created by xubo on 2016/8/6.
 */

import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {//注意while处理多个case
            String a = in.nextLine().toString();
            int max = 0;
            int sum = 0;

            for (int i = 0; i < a.length(); i++) {
                if (a.substring(i, i + 1) == "A") {

                }
            }
            Random r = new Random();
            System.out.println(r.nextInt(a.length()));

        }
    }


}