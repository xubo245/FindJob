package job.nvidia.exam1;//package main
//注意不要添加包名称，否则会报错。

import java.util.Scanner;

class Test {
}

public class Main {
    public static void main(String args[]) {
        Scanner cin = new Scanner(System.in);
        while (cin.hasNext()) {
            String input = cin.nextLine().toString();
            String[] a = input.split(" ");
            int[] b = new int[a.length];
            for (int i = 0; i < a.length; i++) {
                b[i] = Integer.valueOf(a[i]);
            }
            String result = compute(b);
            System.out.println(result);


        }
    }

    public static String compute(int[] arr) {


        for (int i = 0; i < arr.length; i++) {
            int index = i;
            int maxInt = arr[i];
            for (int j = i + 1; j < arr.length; j++) {
                if (compare(String.valueOf(arr[j]) , String.valueOf(maxInt))){
                    index = j;
                    maxInt = arr[j];
                }
            }
            arr[index]=arr[i];
            arr[i]=maxInt;
        }
        StringBuffer max=new StringBuffer();
        for (int i = 0; i < arr.length; i++) {
            max.append(arr[i]);
        }
        return max.toString();
    }

    public static boolean compare(String a, String b) {
        String x1 = a + b;
        String x2 = b + a;
        if (Integer.valueOf(x1) > Integer.valueOf(x2)) {
            return true;
        } else {
            return false;
        }
    }
}
                       