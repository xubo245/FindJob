package job.google.time20161016.before;

import java.io.*;

/**
 * Created by dieeasy on 2016/9/11.
 */
public class Main {
    public static void main(String[] args) {

//        String filename = "C:\\Users\\dieeasy\\IdeaProjects\\job\\src\\1.in";
        String filename="F:\\D-large.in";
        File file = new File(filename);
        File out = new File("F:\\D-large.out");
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
        //        print(a);
        boolean finish = false;
        for (int i = 0; i < a.length; i++) {
            boolean flagMax = true;
            for (int j = 0; j < a.length; j++) {
                if (j != i && a[j][0] <= a[i][0] && a[j][1] <= a[i][1]) {
                } else if (j != i) {
                    flagMax = false;
                    break;
                }

            }
            if (flagMax == true) {
                System.out.println("Case #" + num + ": YES");
                String outString="Case #" + num + ": YES";
                try {
                    bufferedwriter.write(outString+"\n");
                    bufferedwriter.flush();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                finish = true;
                break;
            }
        }
        if (finish == false) {
            boolean allMax = true;
            for (int i = 0; i < a.length; i++) {
                boolean flagMax = true;
                for (int j = 0; j < a.length; j++) {
                    if (j != i && (a[j][0] > a[i][0])) {
                        flagMax = false;
                    }
                }
//                System.out.println(i+":a[0]:"+flagMax);
                if (flagMax == true) {
                    continue;
                } else {
                    flagMax = true;
                }

                for (int j = 0; j < a.length; j++) {
                    if (j != i && (a[j][1] > a[i][1])) {
//                        System.out.println(a[j][1]+":"+a[i][1]);
                        flagMax = false;
                    }
                }
//                System.out.println(i+":a[1]:"+flagMax);
                if (flagMax == true) {
                    continue;
                } else {
                    allMax = false;
                }

            }
            if (allMax == true) {
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

        if (finish == false) {
            int a0=0;
            int sum0=0;
            int a1=0;
            int sum1=0;
            for (int i = 0; i < a.length; i++) {
                if (a[i][0]>a0){
                    a0=a[i][0];
                }
                if (a[i][1]>a1){
                    a1=a[i][1];
                }
            }
            for (int i = 0; i < a.length; i++) {
                if (a[i][0]==a0){
                    sum0=sum0+1;
                }
                if (a[i][1]==a1){
                    sum1=sum1+1;
                }
            }
            int[][] b=new int[a.length-sum0-sum1][2];
            int index=0;
            for (int i = 0; i < a.length; i++) {
              if (a[i][0]!=a0 && a[i][1]!=a1){
                  b[index][0]=a[i][0];
                  b[index][1]=a[i][1];
                  index++;
              }
            }
//            System.out.println("a:"+a.length);
//            System.out.println("b:"+b.length);
            compute(b,b.length,num,bufferedwriter);


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
