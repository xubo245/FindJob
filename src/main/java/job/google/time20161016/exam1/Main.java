package job.google.time20161016.exam1;

import java.io.*;
import java.text.DecimalFormat;

/**
 * Created by dieeasy on 2016/9/11.
 */
public class Main {
    public static void main(String[] args) {

        String filename="F:\\A-large.in";
        File out = new File("F:\\A-large.out");
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
                compute(a,i+1,bufferedwriter);
            }
            bufferedReader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    public static void compute(int[] a,int n,  BufferedWriter bufferedwriter) {
                double out=((double)a[0]- (double) a[1])/((double)a[0]+ (double) a[1]);
                System.out.printf("Case #%d: %.8f\n",n,out);
                DecimalFormat df=new DecimalFormat("######0.00000000");
                String outString="Case #" + n + ": "+df.format(out);
                try {
                    bufferedwriter.write(outString+"\n");
                    bufferedwriter.flush();
                } catch (IOException e) {
                    e.printStackTrace();
                }


    }

}
