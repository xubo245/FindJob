/**
 * @author xubo
 * status AC
 * reference http://www.cnblogs.com/pinxiong/p/4082592.html
 */
package prepare.code.hiho.problem.otherVersion;
import java.util.Scanner;

public class hiho1052Version2 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        while (T > 0) {
            String gene = scanner.next();
            int K = scanner.nextInt();
            int interval = gene.length() - K;
            int sum = 0;
            for (int i = 0; i < interval; i++) {
                int[] count = new int[4];//用来统计出现的次数
                for (int j = i; j < gene.length(); j += interval) {
                    if (gene.charAt(j) == 'A') {
                        count[0]++;
                    } else if (gene.charAt(j) == 'T') {
                        count[1]++;
                    } else if (gene.charAt(j) == 'C') {
                        count[2]++;
                    } else if (gene.charAt(j) == 'G') {
                        count[3]++;
                    }
                }
                int total = 0, max = 0;
                for (int j = 0; j < 4; j++) {
                    total += count[j];
                    max = max > count[j] ? max : count[j];
                }
                sum += total - max;
            }
            System.out.println(sum);
            T--;
        }
        scanner.close();
    }
}