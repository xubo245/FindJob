/**
 * @author xubo
 * @time 20160405
 * @num hiho1000
 * status：AC
 */
package prepare.code.hiho.problem;
import java.util.Scanner;
public class hiho1000 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while(in.hasNext()) {
        	int a = in.nextInt();
        	int b = in.nextInt();
        	System.out.println(a + b);
        }
        in.close();
    }
}