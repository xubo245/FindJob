package job.google.time20161016.exam2.small;

import java.io.*;

/**
 * Created by dieeasy on 2016/9/11.
 */
public class Main {
    public static void main(String[] args) {

        String filename = "F:\\B-small-attempt2.in";
        File out = new File("F:\\B-small-attempt2.out");
        File file = new File(filename);
        BufferedReader bufferedReader = null;
        BufferedWriter bufferedwriter = null;
        try {
            bufferedReader = new BufferedReader(new FileReader(file));
            bufferedwriter = new BufferedWriter(new FileWriter(out));
            int sum = 0;
            String tmpString = null;
            if ((tmpString = bufferedReader.readLine()) != null) {
                sum = Integer.valueOf(tmpString);
            }
            tmpString = null;
            for (int i = 0; i < sum; i++) {
                int[] a = new int[2];

                if ((tmpString = bufferedReader.readLine()) != null) {
                    a[0] = Integer.valueOf(tmpString.split(" ")[0]);
                    a[1] = Integer.valueOf(tmpString.split(" ")[1]);
                }

                compute(a, i + 1, bufferedwriter);

            }

            bufferedReader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    public static void compute(int[] a, int num, BufferedWriter bufferedwriter) {
        boolean finish = true;
        if (finish) {
            int sum = Math.max(maxNum(a[0], a[1]),maxNum2(a[0], a[1]));
            int sum2 = Math.max(maxNum(a[1], a[0]),maxNum2(a[1], a[0]));
            sum=Math.max(sum,sum2);
            System.out.println("Case #" + num + ": " + sum);
            String outString = "Case #" + num + ": " + sum;
            try {
                bufferedwriter.write(outString + "\n");
                bufferedwriter.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }
            finish = true;
        }

    }

    public static int maxNum(int n, int m) {

        boolean[][] arr = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (i < 2) {
                    arr[i][j] = (((j + 1) % 3+(1-i))%3 != 0);
                } else if (j < 2) {
                    arr[i][j] = (((i + 1) % 3+(-j))%3 != 0);
                } else {
                    boolean flag = false;
                    if (arr[i][j - 1] == true && arr[i][j - 2] == true || arr[i - 1][j] == true && arr[i - 2][j] == true) {
                        flag = false;
                    } else {
                        flag = true;
                    }
                    arr[i][j] = flag;
                }
            }
        }
        int sum = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (arr[i][j]==true){
                    sum++;
                }
            }
        }

        return sum;
    }

    public static int maxNum2(int n, int m) {

        boolean[][] arr = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (i < 2) {
                    arr[i][j] = ((j + 1) % 3 != 0);
                } else if (j < 2) {
                    arr[i][j] = ((i + 1) % 3 != 0);
                } else {
                    boolean flag = false;
                    if (arr[i][j - 1] == true && arr[i][j - 2] == true || arr[i - 1][j] == true && arr[i - 2][j] == true) {
                        flag = false;
                    } else {
                        flag = true;
                    }
                    arr[i][j] = flag;
                }
            }
        }
        int sum = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (arr[i][j]==true){
                    sum++;
                }
            }
        }

        return sum;
    }

    public static int maxNum3(int n, int m) {

        int[][] arr = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                for (int k=1;k<3;k++){

                }
            }
        }
        int sum=0;
        return sum;
    }

}
