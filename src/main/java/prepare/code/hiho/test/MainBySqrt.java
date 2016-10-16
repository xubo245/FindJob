/**
 * @author xubo
 * Miller-Rabin质数测试
 */
package prepare.code.hiho.test;

import java.util.Scanner;

public class MainBySqrt {
	// public static String sushu(Long a){
	// for(Long i=2;i<=Math.sqrt(a);i++){
	// if((a%i)==0){
	// return "NO";
	// }
	// }
	// return "YES";
	// }
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		// System.out.println(input);
		Long num = 0L;
		boolean flag = true;
		Long start = 0L;
		int i = 0;
		int length=50;
		String[] string1=new String[50];
//		System.out.println(string1.length);
		while (input.hasNext()) {
			if (start == 0) {
				// System.out.print("请输入第" + (i + 1) + "个数字:");
				num = input.nextLong();
				start = num;
			} else {
				
				// System.out.print("请输入第" + (i + 1) + "个数字:");
				num = input.nextLong();
				// System.out.println(sushu(num));
				String sOutput = null;
				Long j = 0L;
				for (j = 2L; j <= Math.sqrt(num); j++) {
					if ((num % j) == 0) {
						sOutput = "NO";
						break;
					}
				}
				if (j > Math.sqrt(num)) {
					sOutput = "YES";
					if(num<2){sOutput = "NO";}
				}

				string1[i-1]=sOutput;
			}
			i++;
			if (i == start + 1) {
				flag = false;
				break;
			
			}
			
		}
		for(int i1=0;i1<i-1;i1++){
			System.out.println(string1[i1]);
		}
		input.close();
	}
}
