package job.baidu;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * n个数组的笛卡尔集
 *
 */
class  Test{
    Main main1=new Main();
    Double[][] doubles=new Double[0][0];


}
public class Main {
    public static void main(String args[]) {
        Scanner cin = new Scanner(System.in);
        int n;
        while (cin.hasNext()) {
            n = Integer.valueOf(cin.nextLine().toString());
            ArrayList<String[]> list = new ArrayList<String[]>();
            //输入
            for (int i = 0; i < n; i++) {
                String input = cin.nextLine();
                String[] inputArr = input.split(" ");
                list.add(inputArr);
            }
            compute(list);
        }
    }

    //计算
    public static void compute(ArrayList<String[]> list) {
        int n = list.size();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = list.get(i).length;
        }

        List<List<Object>> out = new LinkedList<List<Object>>();

        int flag = 0;
        //遍历所有情况，排列组合
        do {
            List<Object> objs = new LinkedList<Object>();
            for (int i = 0; i < list.size(); i++) {
                objs.add(list.get(i)[arr[i]-1]);
            }
            flag = getNext(arr, list);
            out.add(objs);
        } while (flag != 1);

        for (List list1 : out) {
            System.out.println(list1);
        }
    }

    //获取下一个位置list
    public static int getNext(int[] arr, ArrayList<String[]> list) {
        int flag = 0;
        for (int i = list.size() - 1; i >= 0; i--) {
            if (arr[i] - 1 == 0) {
                flag=1;
                arr[i] = list.get(i).length;
            } else {
                arr[i] = arr[i] - 1;
                flag = 0;
                return 0;
            }
        }
        if (flag == 1)
            return 1;
        else
            return 0;
    }
}
