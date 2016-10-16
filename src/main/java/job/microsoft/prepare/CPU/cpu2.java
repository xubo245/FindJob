package job.microsoft.prepare.CPU;

/**
 * Created by xubo on 2016/10/7.
 */

public class cpu2 {
    static int busyTime = 100;
    static int idelTime = busyTime;
    public static void main(String[] args) throws Exception {
        long startTime = 0;
        while (true) {
            startTime = System.currentTimeMillis();
            while (System.currentTimeMillis() - startTime < busyTime)
                ;
//            Thread.sleep(idelTime);
        }
    }
}