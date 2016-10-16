package job.sohu.test11;

import java.math.BigInteger;

/**
 * Created by xubo on 2016/9/21.
 */
public class test2 {
    public static void main(String[] args) {
        BigInteger b=new BigInteger("123456789123456789123456789");
        byte[] a=b.toByteArray();
        System.out.println(a.length);
        System.out.println(b.bitLength());
        System.out.println(b.shiftLeft(1));
//        for (byte x:a){
//            System.out.println(x);
//        }
    }
}
