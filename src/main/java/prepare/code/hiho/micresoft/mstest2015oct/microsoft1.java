package prepare.code.hiho.micresoft.mstest2015oct;
import java.util.Scanner;

public class microsoft1 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int numString = in.nextInt();
		int end = 0;
		while (end < numString) {
			end++;
			int strLength = in.nextInt();
			String str = in.next();
			System.out.println(beautiful(strLength, str));
		}
		in.close();
	}

	public static String beautiful(int strLength, String str) {
		// TODO Auto-generated method stub

		int flag = 2;
		for (int i = 1; i < strLength; i++) {

			if (((int) str.charAt(i)) == (((int) str.charAt(i - 1)) + 1)) {
				flag--;
			} else {
				flag = 2;
			}
			if (flag == 0) {
				flag=2;
				return "YES";
			}
		}
		int[] arrR = new int[3];
		for (int i = 0; i < arrR.length; i++) {
			arrR[i] = 0;
		}
		flag=2;
		for (int i = 1; i < strLength; i++) {
			if (((int) str.charAt(i)) == (((int) str.charAt(i - 1)))) {
				arrR[2 - flag]++;
			} else if (((int) str.charAt(i)) == (((int) str.charAt(i - 1)) + 1)) {
				flag--;
			} else {
				flag = 2;
				for (int i1 = 0; i1 < arrR.length; i1++) {
					arrR[i1] = 0;
				}
			}
//			System.out.println(flag);
//			for (int i1 = 0; i1 < arrR.length; i1++) {
//				System.out.print(i1+":"+arrR[i1]+" ");
//			}
//			System.out.println();
//			System.out.println(((arrR[0]<arrR[1])||(arrR[0] ==arrR[1])));
			if ((flag == 0) && ((arrR[0] >=arrR[1]))&&(arrR[1]==arrR[2])) {
				return "YES";
			}
		}
		return "NO";
	}
}
