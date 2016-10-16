package job.test4; /**
 * Created by xubo on 2016/8/6.
 */

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {//注意while处理多个case
            int a = in.nextInt();
            int[] num = new int[a];

            for (int i = 0; i < a; i++) {
                num[i] = in.nextInt();
            }
            num = sortN(num, a);
            ArrayList<Integer> list = compute(num, a);
            int[] res = new int[list.size()];
            for (int i = 0; i < list.size(); i++) {
                res[i] = list.get(i);
            }
            res = sortN(res, res.length);

            for (int i = 1; i < res.length; i++) {
//                System.out.println(i+":"+res[i]);
                if (!((res[i] - res[i - 1]) ==1 || (res[i] - res[i - 1]) == 0)) {
                    System.out.println(res[i-1] + 1);
                    break;
                }else{
                    if (i==res.length-1){
                    System.out.println(res[i]+1);}
                }

//                System.out.println(i + ":" + a + " " + num[i]);
            }

        }
    }

    public static ArrayList<Integer> compute(int[] num, int n) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        ArrayList<Integer> list2 = new ArrayList<Integer>();
        for (int i = 0; i < n; i++) {
            list = computeN(list, num[i]);
        }
        return list;
    }

    public static ArrayList<Integer> computeN(ArrayList<Integer> num, int n) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        list.add(n);
        for (int i = 0; i < num.size(); i++) {
            list.add(num.get(i));
            list.add(num.get(i) + n);
        }
        return list;
    }

    public static int[] sortN(int[] num, int n) {
        for (int i = 0; i < n; i++) {
            int min = 100000;
            int minj = 0;
            for (int j = i; j < n; j++) {
                if (num[j] < min) {
                    min = num[j];
                    minj = j;
                }
            }
            int tmp = 0;
            tmp = num[i];
            num[i] = num[minj];
            num[minj] = tmp;
        }
        return num;
    }
}