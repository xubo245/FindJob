package prepare.code.hiho;

import java.math.BigInteger;
import java.util.Random;

public class test1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BigInteger bb1=new BigInteger("100");
		System.out.println(bb1);
		System.out.println(bb1.compareTo(new BigInteger("100")));
		System.out.println(bb1.compareTo(new BigInteger("101")));
		System.out.println(bb1.compareTo(new BigInteger("99")));
		Random ran = new Random(100);
		System.out.println("Long2BigInt:"+BigInteger.valueOf(Long.MAX_VALUE));
		System.out.println("Long MAX:"+Long.MAX_VALUE);
		for (int i = 0; i < 10; i++) {
			long long1=Math.abs(ran.nextLong());
			System.out.println(long1);
		}
//		int num=0;
		int bit=0;
		long l1=Long.MAX_VALUE;
//		long l1=9;
		boolean flag=true;
		while(flag){
			if((l1/10)>0){
				l1=l1/10;
				bit=bit+1;
			}else{
				flag=false;
			}	
		}
		System.out.println("bit:"+bit);

	}

}
