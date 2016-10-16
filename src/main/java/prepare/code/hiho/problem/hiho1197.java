/**
 * @author xubo
 * status：AC
 */
package prepare.code.hiho.problem;
import java.util.Scanner;

public class hiho1197 {

    public static void main(String[] args) {
        Scanner sin = new Scanner(System.in);

        while (sin.hasNext()) {
            String tmp = sin.nextLine().trim();
            int pre = 0;
            int i = tmp.indexOf(".", pre);

            while (i != tmp.length()-1 && i != -1) {
                String sente = tmp.substring(pre, i + 1);
                giveTextBack2(sente.trim());
                System.out.print(" ");
                pre = i + 1;
                i = tmp.indexOf(".", pre);
            }
            if (i != -1) {
                String sente = tmp.substring(pre, i + 1);
                giveTextBack2(sente.trim());
                pre = i+1;
                System.out.println();
            }
        }
        sin.close();
    }

    private static void giveTextBack2(String sentence) {
        StringBuilder res = new StringBuilder();
        res.append(Character.toUpperCase(sentence.charAt(0)));
        int i = 1;
        boolean in = true;
        while (i < sentence.length()) {
            if ( (sentence.charAt(i) >= 'a'&& sentence.charAt(i) <='z')
                || (sentence.charAt(i) >= 'A'&& sentence.charAt(i) <='Z')) {
                res.append(Character.toLowerCase(sentence.charAt(i)));
                in = true;
            } else if (sentence.charAt(i) == ' ') {
                if (in) {
                    res.append(" ");
                    in = false;
                }
            } else if (sentence.charAt(i) == ',') {
                if (in) {
                    res.append(",");
                    res.append(" ");
                    in = false;
                } else {
                    res.deleteCharAt(res.length()-1);
                    res.append(",");
                    res.append(" ");
                    in = false;
                }
            } else if (sentence.charAt(i) == '.') {
                if (in) {
                    res.append(".");
                    in = false;
                } else {
                    res.deleteCharAt(res.length()-1);
                    res.append(".");
                    in = false;
                }
            }
            i++;
        }
        System.out.print(res.toString().trim());
    }
}