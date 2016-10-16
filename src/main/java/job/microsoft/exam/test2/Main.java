package job.microsoft.exam.test2;//package main
//注意不要添加包名称，否则会报错。

import java.util.HashMap;
import java.util.Scanner;

class Test {
}

public class Main {
    public static void main(String args[]) {
        Scanner cin = new Scanner(System.in);
        while (cin.hasNext()) {
            int N, M;
            String n = cin.nextLine().toString();
//            N = Integer.valueOf(n);
            String str = cin.nextLine().toString();
            String m = cin.nextLine().toString();
            M = Integer.valueOf(m);
//            HashMap<Integer, ArrayList<Integer>> count = new HashMap<Integer, ArrayList<Integer>>();

            HashMap<String, Integer> inputMap = new HashMap<String, Integer>();
            for (int i = 0; i < M; i++) {
                String tmp = cin.nextLine().toString();
                if (inputMap.get(tmp) == null) {
                    inputMap.put(tmp, 1);
                } else {
                    inputMap.put(tmp, inputMap.get(tmp) + 1);
                }
            }
            int result = compute(str, inputMap);
            System.out.println(result);

        }
    }

    public static int compute(String str, HashMap<String, Integer> map) {
        int sum = 0;
        if (str.length() <= 1) {
            return 0;
        } else if (str.length() == 2) {
            String tmpReverse = str.substring(1, 2) + str.substring(0, 1);
            if (map.get(str) != null || map.get(tmpReverse) != null) {
                return 1;
            }
        }

        for (int i = 0; i < str.length() - 1; i++) {
            String tmp = str.substring(i, i + 2);
            String tmpReverse = tmp.substring(1, 2) + tmp.substring(0, 1);
            if (i < str.length() - 2) {
                if (map.get(tmp) != null || map.get(tmpReverse) != null) {
                    sum = Math.min(compute(str.substring(i + 1, str.length()), map), compute(str.substring(i, i + 1) + str.substring(i + 2, str.length()), map));
                    return sum + 1;
                }
            } else {
                if (map.get(tmp) != null || map.get(tmpReverse) != null) {
                    return 1;
                }
            }

        }

        return sum;
    }
}
                       