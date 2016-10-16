package job.nvidia.exam2; /**
 * 修改为
 */

import java.util.Scanner;

class Test {
}

/**
 * 输入一个运算行列式，如X=A+B*(C-D)/E
 * 转换表达，去括号
 * 结果类似XABCD+*E-/，不确定
 */
public class Main {
    public static void main(String args[]) {
        Scanner cin = new Scanner(System.in);
        while (cin.hasNext()) {
            String input = cin.nextLine().toString();

            System.out.println(compute(input));

        }
    }

    //    X=A+B*(C-D)/E
    public static String compute(String arr) {
        StringBuffer buffer = new StringBuffer();
        StringBuffer buffer2 = new StringBuffer();
        int index = -1;
        for (int i = 0; i < arr.length(); i++) {

            String tmp = arr.substring(i, i + 1);

            if (tmp.equals("(") || tmp.equals(")")) {
                continue;
            }
            if (!(tmp.equals("+") || tmp.equals("-") || tmp.equals("*") || tmp.equals("/") || tmp.equals("="))) {
                if (i != index) {
                    buffer.append(tmp);
                }
            } else if (tmp.equals("*") || tmp.equals("/")) {
                boolean flag = true;
                int j = i;
                while (flag) {
                    String tmp1 = arr.substring(j, j + 1);
                    if (!(tmp1.equals("+") || tmp1.equals("-") || tmp1.equals("*") ||
                            tmp1.equals("/") || tmp1.equals("=") || tmp1.equals("(") || tmp1.equals(")"))) {
                        buffer.append(tmp1);
                        index = j;
                        flag = false;
                    } else {
                        j++;
                    }
                }
                buffer2.append(tmp);
                buffer.append(buffer2);
                buffer2 = new StringBuffer();
            } else if (tmp.equals("+") || tmp.equals("-") || !tmp.equals("=")) {
                buffer2.append(arr.substring(i, i + 1));
            }
        }
        return buffer.toString();
    }
}
                       