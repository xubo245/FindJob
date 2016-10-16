package game163; /**
 * Created by xubo on 2016/8/6.
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static int flag = 0;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {//注意while处理多个case
            int n = in.nextInt();
            int[][] a = new int[n][2];
            for (int i = 0; i < n; i++) {
                a[i][0] = in.nextInt();
                a[i][1] = in.nextInt();
            }
            int m = in.nextInt();
            int[][] b = new int[m][2];
            for (int i = 0; i < m; i++) {
                b[i][0] = in.nextInt();
                b[i][1] = in.nextInt();
            }

//            for (int i = 0; i < m; i++) {
//                System.out.println(b[i][0] + ":" + b[i][1]);
//            }

            ArrayList<Data> dataA = new ArrayList<Data>();

            for (int i = 0; i < n; i++) {
                dataA.add(new Data(a[i][0], a[i][1]));
            }
            boolean[] flagA = new boolean[n];

            ArrayList<Data> dataArrayList = new ArrayList<Data>();

            for (int i = 0; i < m; i++) {
                dataArrayList.add(new Data(b[i][0], b[i][1]));
            }

            ArrayList<ArrayList> lists = new ArrayList<ArrayList>();
            ArrayList list = new ArrayList();
            list.add(b[0][0]);
            list.add(b[0][1]);
            lists.add(list);
            dataArrayList.remove(0);
//            System.out.println(lists.size());
            constrain(dataArrayList, lists);
//            for (int j = 0; j < lists.get(0).size(); j++) {
//                System.out.println(j+"=="+lists.get(0).get(j));
//            }

            compute(dataA, dataArrayList, lists, flagA, m);


        }
    }

    public static void compute(ArrayList<Data> dataA, ArrayList<Data> dataArrayList, ArrayList<ArrayList> lists, boolean[] flagA, int m) {
        ArrayList<Integer> list = lists.get(0);
        ArrayList<Time> time = new ArrayList<Time>();
        time.add(new Time(dataA.get(list.get(0) - 1).i, dataA.get(list.get(0) - 1).i - dataA.get(list.get(0) - 1).j, dataA.get(list.get(0) - 1).i, dataA.get(list.get(0) - 1).j));
        //        dataA.remove(list.get(0));
        flagA[list.get(0) - 1] = true;


        for (int i = 1; i < list.size(); i++) {
            int index = list.get(i);
//            System.out.println(dataA.size());
            int finishTime = time.get(i - 1).finishTime + dataA.get(index - 1).i;
            time.add(new Time(finishTime, finishTime - dataA.get(index - 1).j, dataA.get(index - 1).i, dataA.get(index - 1).j));
            flagA[list.get(i) - 1] = true;
        }
        ArrayList<Data> other = new ArrayList<Data>();
        for (int i = 0; i < flagA.length; i++) {
            if (flagA[i] == false) {
                other.add(new Data(dataA.get(i).i, dataA.get(i).j));
            }
        }

        sortList(other);
        for (int i = 0; i < other.size(); i++) {
            int finishTime = time.get(time.size() - 1).finishTime + other.get(i).i;
            time.add(new Time(finishTime, finishTime - other.get(i).j, other.get(i).i, other.get(i).j));
        }

        int max = findMax(time);

        int moveMax = Integer.MAX_VALUE;

        moveMax = findMax(move(time, m));
        while (moveMax < max) {
            max = moveMax;
            m++;
            moveMax = findMax(move(time, m));
        }
        System.out.println(Math.min(max, moveMax));
    }

    public static ArrayList<Time> move(ArrayList<Time> time, int m) {
        ArrayList<Time> newTime = new ArrayList<Time>();
        int max = findMax(time);
        Time maxTime = null;
        int maxIndex = 0;
        boolean flag = true;
        int index = 0;

        for (int i = 0; i < time.size(); i++) {
            newTime.add(time.get(i));
            if (time.get(i).yuanbao == max) {
                maxTime = time.get(i);
                maxIndex = i;
            }
            if (time.get(i).finishTime > max && flag == true) {
                flag = false;
                index = i;
            }
        }

        int minValue = 0;
        int minValueIndex = 0;
        for (int i = 0; i < index; i++) {
            int value = time.get(i).finishTime - time.get(i).i + maxTime.i - maxTime.j;
            int tmpValue = findMax((List<Time>) time.subList(i, index)) + maxTime.i;
            if (minValue < Math.min(value, tmpValue)) {
                minValue = Math.min(value, tmpValue);
                minValueIndex = i;
            }
            //            if (value)
        }

        index = minValueIndex;


        if (index < maxIndex && maxIndex > m) {
            for (int i = maxIndex; i > index; i--) {
                newTime.get(i).finishTime = newTime.get(i - 1).finishTime + maxTime.i;
                newTime.get(i).i = newTime.get(i - 1).i;
                newTime.get(i).j = newTime.get(i - 1).j;
                newTime.get(i).yuanbao = newTime.get(i - 1).yuanbao + maxTime.i;
            }
            newTime.get(index).finishTime = newTime.get(index).finishTime - newTime.get(index).i + maxTime.i;
            newTime.get(index).i = maxTime.i;
            newTime.get(index).j = maxTime.j;
            newTime.get(index).yuanbao = newTime.get(index).finishTime - maxTime.j;

        }
        return newTime;
    }

    public static int findMax(List<Time> time) {
        int max = 0;
        for (int i = 0; i < time.size(); i++) {
            if (max < time.get(i).yuanbao) {
                max = time.get(i).yuanbao;
            }
        }
        return max;
    }

    public static void sortList(ArrayList<Data> list) {
        for (int i = 0; i < list.size(); i++) {
            int max = 0;
            Data maxData = null;
            int maxIndex = 0;
            for (int j = i; j < list.size(); j++) {
                if (max < list.get(j).j) {
                    max = list.get(j).j;
                    maxIndex = j;
                    maxData = list.get(j);
                }
            }
            if (maxData != null) {
                list.get(maxIndex).i = list.get(i).i;
                list.get(maxIndex).j = list.get(i).j;
                list.get(i).i = maxData.i;
                list.get(i).j = maxData.j;
            }
//            list.remove(maxIndex);
//            list.add(maxIndex, list.get(i));
//            list.remove(i);
//            list.add(i, maxData);
        }
    }

    public static int inListLocation(ArrayList list, int num) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).equals(num)) {
                return i;
            }
        }
        return -1;
    }

    public static void constrain(ArrayList<Data> dataArrayList, ArrayList<ArrayList> lists) {
        flag = dataArrayList.size();
        int sum = 0;
        int sumIndex = 0;
        int sumMax = 0;
        int sumMaxIndex = 0;
        for (int i = 0; i < dataArrayList.size(); i++) {
            if (lists.get(0).get(0).equals(dataArrayList.get(i).j)) {
                sum++;
                sumIndex = i;
            }
            if (lists.get(0).get(lists.get(0).size() - 1).equals(dataArrayList.get(i).i)) {
                sumMax++;
                sumMaxIndex = i;
            }
        }

        if (sum == 1) {
            lists.get(0).add(0, dataArrayList.get(sumIndex).i);
            dataArrayList.remove(sumIndex);
            sum = 0;
        } else if (sum > 1) {

        }

        if (sumMax == 1) {
            lists.get(0).add(lists.get(0).size(), dataArrayList.get(sumIndex).j);
            dataArrayList.remove(sumMaxIndex);
            sumMax = 0;
        } else if (sumMax > 1) {

        }

        if (dataArrayList.size() != 0) {
            if (flag != dataArrayList.size()) {
                constrain(dataArrayList, lists);
            }
        }
    }

}

class Data {
    int i;
    int j;

    public Data(int i, int j) {
        this.i = i;
        this.j = j;
    }
}

class Time {
    int finishTime;
    int yuanbao;
    int i;
    int j;

    public Time(int finishTime, int yuanbao, int i, int j) {
        this.finishTime = finishTime;
        this.yuanbao = yuanbao;
        this.i = i;
        this.j = j;
    }
}