package test.test3; /**
 * @author xubo
 */

import java.util.Scanner;

class Test {
}


public class Main {
    public static void main(String args[]) {
        Scanner cin = new Scanner(System.in);
        while (cin.hasNext()) {
            String str = cin.nextLine().toString();
            System.out.println(str.replace("ra",""));
        }
    }

//    public static void compute(String str) {
//        int max = 0;
//        int length = 0;
//        int result = 0;
//        int index = 0;
//        StringBuffer out = new StringBuffer();
//        for (int i = 0; i < str.length(); i++) {
////            str.replace("")
//            if (str.substring(i, i + 1).equals("r")) {
//                max++;
//            } else if (str.substring(i, i + 1).equals("a") && max > 0) {
//                length++;
//            } else {
//                result = Math.min(max, length);
//                if (result == 1) {
//                    out.append(str.substring(i, i + 1));
//                } else {
//
//                }
//
//                max = 0;
//                length = 0;
//                index = i;
//            }
//        }
//    }
}
                       