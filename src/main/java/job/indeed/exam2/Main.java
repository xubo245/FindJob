package job.indeed.exam2; /**
 * @author xubo
 */

import java.util.Scanner;

class Test {
}


public class Main {
    public static void main(String args[]) {
        Scanner cin = new Scanner(System.in);
        while (cin.hasNext()) {
            int n, m, k;
            n = cin.nextInt();
            m = cin.nextInt();
            k = cin.nextInt();
            int[][] a = new int[n][m];
            int[][] b = new int[m][k];
            int[][] out = new int[n][k];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    a[i][j] = cin.nextInt();
                }
            }
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < k; j++) {
                    b[i][j] = cin.nextInt();
                }
            }
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < k; j++) {
                    for (int x = 0; x < m; x++) {
                        out[i][j] = out[i][j] + a[i][x] * b[x][j];
                    }
                    if (j == k - 1) {
                        System.out.print(out[i][j]);
                    } else {
                        System.out.print(out[i][j] + " ");
                    }
                }
                System.out.println();
            }
        }
    }

}
                       