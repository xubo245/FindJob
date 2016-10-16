package job.google.time20161016.exam2;

import java.io.*;

/**
 * Created by dieeasy on 2016/9/11.
 */
public class Main {
    public static void main(String[] args) {

        String filename="F:\\D2.in";
        File out = new File("F:\\D2.out");
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
                int lineNum = 0;
                if ((tmpString = bufferedReader.readLine()) != null) {
                    lineNum = Integer.valueOf(tmpString);
                }
                int[][] a = new int[lineNum][2];
                for (int j = 0; j < lineNum; j++) {
                    if ((tmpString = bufferedReader.readLine()) != null) {
                        a[j][0] = Integer.valueOf(tmpString.split(" ")[0]);
                        a[j][1] = Integer.valueOf(tmpString.split(" ")[1]);
                    }
                }
                compute(a, lineNum, i + 1,bufferedwriter);

            }

            bufferedReader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    public static void compute(int[][] a, int lineNum, int num, BufferedWriter bufferedwriter) {
        boolean finish = false;
        if (false) {
                System.out.println("Case #" + num + ": NO");
                String outString="Case #" + num + ": NO";
                try {
                    bufferedwriter.write(outString+"\n");
                    bufferedwriter.flush();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                finish = true;
            }

    }

    public static void print(int[][] a) {
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < 2; j++) {
                System.out.print(a[i][j] + " ");
            }
            System.out.println();
        }
    }
}
