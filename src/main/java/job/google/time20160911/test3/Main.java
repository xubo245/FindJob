package job.google.time20160911.test3;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

/**
 * Created by dieeasy on 2016/9/11.
 */
public class Main {
    public static void main(String[] args) {

        String filename = "C:\\Users\\dieeasy\\IdeaProjects\\job\\src\\1.in";
        File file = new File(filename);
        InputStream inputStream = null;
        try {
            inputStream = new FileInputStream(file);
            int tempbyte;
            while ((tempbyte = inputStream.read()) != -1) {
                System.out.println();
                System.out.write(tempbyte);
            }
            inputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
