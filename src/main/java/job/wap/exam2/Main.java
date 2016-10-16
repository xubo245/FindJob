package job.wap.exam2;
/**
 * @author xubo
 * <p/>
 * [Exam2] Wireless Routers
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

class Test {
}

public class Main {
    public static void main(String args[]) {
        Scanner cin = new Scanner(System.in);
        int N, M;
        while (cin.hasNext()) {
            N = cin.nextInt();
            M = cin.nextInt();
            int[] arr = new int[N];
            for (int i = 0; i < N; i++) {
                arr[i] = cin.nextInt();
            }
            HashMap<Integer, ArrayList<Integer>> map = new HashMap<Integer, ArrayList<Integer>>();
            for (int i = 0; i < N - 1; i++) {
                int a = cin.nextInt();
                int b = cin.nextInt();
                if (map.get(a) != null) {
                    map.get(a).add(b);
                } else {
                    ArrayList<Integer> list = new ArrayList<Integer>();
                    list.add(b);
                    map.put(a, list);
                }

                if (map.get(b) != null) {
                    if (map.get(b).contains(a) == false) {
                        map.get(b).add(a);
                    }
                } else {
                    ArrayList<Integer> list = new ArrayList<Integer>();
                    list.add(a);
                    map.put(b, list);
                }

            }

            compute(map, arr, N, M);
        }
    }

    /**
     * calculate the maximum satisfaction point
     *
     * @param map every room map adjacent
     * @param arr rooms satisfaction point
     * @param N   rooms number
     * @param M   number of wireless routers
     */
    public static void compute(HashMap<Integer, ArrayList<Integer>> map, int[] arr, int N, int M) {
        int[] score = new int[N];
        for (int i = 0; i < N; i++) {
            int key = i + 1;
            score[i] = arr[i];
            if (map.get(key) != null) {
                for (int x : map.get(key)) {
                    score[i] = score[i] + arr[x - 1];
                }
            }
        }

        boolean[] flag = new boolean[N];
        int result = getMax(map, arr, score, flag, N, M);
        System.out.println(result);

    }

    /**
     * get Max score  and refresh score
     *
     * @param map   every room map adjacent
     * @param arr   rooms satisfaction point
     * @param score rooms score
     * @param flag  flag
     * @param N     rooms number
     * @param M     number of wireless routers
     * @return max score
     */
    public static int getMax(HashMap<Integer, ArrayList<Integer>> map, int[] arr, int[] score, boolean[] flag, int N, int M) {
        int max = 0;
        boolean[] scoreFlag = new boolean[N];
        while (M > 0) {
            int maxScore = 0;
            int maxIndex = 0;
            for (int i = 0; i < N; i++) {
                if (flag[i] == false) {
                    if (score[i] > maxScore) {
                        maxScore = score[i];
                        maxIndex = i;

                    }
                }
            }
            score = refreshScore(map, scoreFlag, arr, N, maxIndex);
            max = max + maxScore;
            flag[maxIndex] = true;
            M--;
        }

        return max;
    }

    /**
     * refresh score
     *
     * @param map       every room map adjacent
     * @param scoreFlag score flag
     * @param arr       rooms satisfaction point
     * @param N         rooms number
     * @param index     index of wireless routers
     * @return new score by refreshing
     */
    public static int[] refreshScore(HashMap<Integer, ArrayList<Integer>> map, boolean[] scoreFlag, int[] arr, int N, int index) {
        int[] score = new int[N];
        int key = index + 1;
        scoreFlag[index] = true;
        if (map.get(key) != null) {
            for (int x : map.get(key)) {
                scoreFlag[x - 1] = true;
            }
        }

        for (int i = 0; i < N; i++) {
            int key1 = i + 1;
            if (scoreFlag[i] == false) {
                score[i] = arr[i];
            }
            if (map.get(key1) != null) {
                for (int x : map.get(key1)) {
                    if (scoreFlag[x - 1] == false) {
                        score[i] = score[i] + arr[x - 1];
                    }
                }
            }
        }
        return score;
    }
}
                       