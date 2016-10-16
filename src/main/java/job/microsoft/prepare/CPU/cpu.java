package job.microsoft.prepare.CPU;

/**
 * Created by xubo on 2016/10/7.
 */
public class cpu {
    public static void main(String[] args) throws InterruptedException {
//        for (; ; ) {
        int index=0;
        while(true){
            int j;
            for (int i = 0; i < 92000000; i++)
                j=i+1;
            Thread.sleep(10);
            index++;
            System.out.println(index);
        }
    }
}
