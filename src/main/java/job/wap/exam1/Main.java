package job.wap.exam1; /**
 * @author xubo
 *
 * [Exam1] Magic Cube
 */

import java.util.ArrayList;
import java.util.Scanner;

class Test {
}

public class Main {
    public static void main(String args[]) {
        Scanner cin = new Scanner(System.in);
        int M, N, P;
        while (cin.hasNextInt()) {
            M = cin.nextInt();
            N = cin.nextInt();
            P = cin.nextInt();
            int[][][] arr = new int[M][M][M];
            for (int i = 0; i < M; i++) {
                for (int j = 0; j < M; j++) {
                    for (int k = 0; k < M; k++) {
                        arr[i][j][k] = cin.nextInt();
                    }
                }
            }
            ArrayList<int[][][]> lists = new ArrayList<int[][][]>();
            for (int ii = 0; ii < N; ii++) {
                int a = cin.nextInt();
                int[][][] arr2 = new int[a][a][a];
                for (int i = 0; i < a; i++) {
                    for (int j = 0; j < a; j++) {
                        for (int k = 0; k < a; k++) {
                            arr2[i][j][k] = cin.nextInt();
                        }
                    }
                }
                lists.add(arr2);
            }
            compute(arr, lists, M, N, P);
        }
    }

    /**
     * compute magic cube
     *
     * @param arr big cube
     * @param lists N small cube
     * @param M length of big cude
     * @param N N number of small cube
     * @param P mod P
     */
    public static void compute(int[][][] arr, ArrayList<int[][][]> lists, int M, int N, int P) {
        for (int i = 0; i < N; i++) {
            int[] out = getLocation(arr, lists.get(i), M, lists.get(i).length, P);
            System.out.println(out[0] + " " + out[1] + " " + out[2]);
        }
    }

    /**
     * get location small cube in big cube
     * @param arr  big cube
     * @param n small cube
     * @param M length of big cude
     * @param N N number of small cube
     * @param P mod P
     * @return location of small cube
     */
    public static int[] getLocation(int[][][] arr, int[][][] n, int M, int N, int P) {
        int[] out = new int[3];
        for (int i = 0; i <= M - N; i++) {
            for (int j = 0; j <= M - N; j++) {
                for (int k = 0; k <= M - N; k++) {
                    if ((arr[i][j][k] + n[0][0][0]) % P == 0) {
                        boolean outFlag = true;
                        for (int i1 = 0; i1 < N; i1++) {
                            for (int j1 = 0; j1 < N; j1++) {
                                for (int k1 = 0; k1 < N; k1++) {
                                    if ((arr[i + i1][j + j1][k + k1] + n[i1][j1][k1]) % P != 0) {
                                        outFlag = false;
                                        break;
                                    }
                                }
                                if (outFlag == false) {
                                    break;
                                }
                            }
                            if (outFlag == false) {
                                break;
                            }
                        }
                        if (outFlag) {
                            for (int i1 = 0; i1 < N; i1++) {
                                for (int j1 = 0; j1 < N; j1++) {
                                    for (int k1 = 0; k1 < N; k1++) {
                                        arr[i + i1][j + j1][k + k1] = 0;
                                    }
                                }
                            }
                            out[0] = i;
                            out[1] = j;
                            out[2] = k;
                            return out;
                        }
                    } else {
                        continue;
                    }
                }
            }
        }
        return out;
    }

}
                       