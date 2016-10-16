package prepare.code.hiho.test;


import java.math.BigInteger;
import java.util.Scanner;

public class isProbablePrime {
public static void main(String[] args) {
//	System.out.println(Long.MAX_VALUE);
//	System.out.println(BigInteger.);
	Scanner input = new Scanner(System.in);
	BigInteger num=new BigInteger("0");
	@SuppressWarnings("unused")
	boolean flag = true;
	int start=0;
	int i = 0;
	@SuppressWarnings("unused")
	int length=50;
	String[] string1=new String[50];
	while (input.hasNext()) {
		if (start ==0) {
			// System.out.print("请输入第" + (i + 1) + "个数字:");
			num = input.nextBigInteger();
			start = num.intValue();
		} else {
			num = input.nextBigInteger();
			if(num.isProbablePrime(1)){
				string1[i-1]="YES";
//				System.out.println("Yes");
			}else{
//				System.out.println("NO");
				string1[i-1]="NO";
			}
			}
			i++;
			if (i == start + 1) {
				flag = false;
				break;
			}
		}
		for(int i1=0;i1<i-1;i1++){System.out.println(string1[i1]);}
		
	input.close();

}
}
