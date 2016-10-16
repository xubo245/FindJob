package job.microsoft.exam.test4;//package main
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
            N = Integer.valueOf(n);
            String str = cin.nextLine().toString();
            String m = cin.nextLine().toString();
            M = Integer.valueOf(m);
//            HashMap<Integer, ArrayList<Integer>> count = new HashMap<Integer, ArrayList<Integer>>();

            HashMap<String, Integer> map = new HashMap<String, Integer>();
            for (int i = 0; i < M; i++) {
                String tmp = cin.nextLine().toString();
                if (map.get(tmp) == null) {
                    map.put(tmp, 1);
                } else {
                    map.put(tmp, map.get(tmp) + 1);
                }
            }
            int result = 0;
            boolean flag = false;
            if (N > 10000) {
                int index=0;
                for (int i = 1; i < N - 2; i++) {
                    String tmp1 = str.substring(i, i + 2);
                    String tmpReverse1 = tmp1.substring(1, 2) + tmp1.substring(0, 1);
                    String tmp2 = str.substring(i - 1, i + 1);
                    String tmpReverse2 = tmp2.substring(1, 2) + tmp2.substring(0, 1);
                    String tmp3 = str.substring(i - 1, i) + str.substring(i + 1, i + 2);
                    String tmpReverse3 = tmp3.substring(1, 2) + tmp3.substring(0, 1);
                    if (map.get(tmp1) != null || map.get(tmpReverse1) != null || map.get(tmp2) != null || map.get(tmpReverse2) != null || map.get(tmp3) != null || map.get(tmpReverse3) != null) {
                        result = result +compute(str.substring(index,i+1),map);
                        index=i;
                    }
                }
            } else {
                result = compute(str, map);
            }
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
                }else{
                    return compute(str.substring(i+1,str.length()),map);
                }
            }

        }

        return sum;
    }
}
                       