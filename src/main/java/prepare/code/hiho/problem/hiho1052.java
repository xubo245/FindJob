package prepare.code.hiho.problem;
/**
 * @author xubo
 * @time 20160407
 * @num hiho1052
 * status：AC
 */

import java.util.Scanner;

public class hiho1052 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int sum = in.nextInt();
		int flag = 0;
		while (flag < sum) {
			String str = in.next();
			int length = in.nextInt();
			if (2 * length <= str.length()) {
				System.out.println(stringHuo(length, str));
			} else {
				System.out.println(stringSum(str,length));
			}
			++flag;
		}
		in.close();
	}

	public static int stringSum(String gene, int K) {
		int interval = gene.length() - K;
		int sum = 0;
		for (int i = 0; i < interval; i++) {
			int[] count = new int[4];// 用来统计出现的次数
			for (int j = i; j < gene.length(); j += interval) {
				if (gene.charAt(j) == 'A') {
					count[0]++;
				} else if (gene.charAt(j) == 'T') {
					count[1]++;
				} else if (gene.charAt(j) == 'C') {
					count[2]++;
				} else if (gene.charAt(j) == 'G') {
					count[3]++;
				}
			}
			int total = 0, max = 0;
			for (int j = 0; j < 4; j++) {
				total += count[j];
				max = max > count[j] ? max : count[j];
			}
			sum += total - max;
		}
		return sum;
	}

	/*
	 * stringOther  is error
	 */
//	public static int stringOther(int length, String str) {
//		// TODO Auto-generated method stub
//		// String str1 = str;
//		char[] char1 = str.toCharArray();
//
//		for (int i = 0; i < 2 * length - str.length(); i++) {
//			// System.out.println(str.charAt(i)+":"+str.charAt(str.length()-length+i));
//			// char a1=str.charAt(i);
//			// char a2= str.charAt(str.length() - length + i);
//			// char a3=str.charAt(2 * (str.length() - length) + i);
//			char a1 = char1[i];
//			char a2 = char1[str.length() - length + i];
//			char a3 = char1[2 * (str.length() - length) + i];
//			if ((a1 != a2) && (a3 != a2) && (a1 != a3)) {
//				char1[i] = a2;
//				char1[2 * (str.length() - length) + i] = a2;
//				// System.out.println(i+":"+sum);
//			} else if ((a1 != a2) && (a3 != a2) && (a1 == a3)) {
//				char1[str.length() - length + i] = a1;
//			} else if ((a1 == a2) && (a3 != a2) && (a1 != a3)) {
//				char1[2 * (str.length() - length) + i] = a1;
//			} else if ((a1 != a2) && (a3 == a2) && (a1 != a3)) {
//				char1[i] = a2;
//			}
//		}
//		for (int i = 2 * length - str.length(); i < length; i++) {
//			if (str.charAt(i) != str.charAt(str.length() - length + i)) {
//				// System.out.println(i+":"+sum);
//				char1[str.length() - length + i] = char1[i];
//			}
//		}
//		int sum = 0;
//
//		for (int i = 0; i < str.length(); i++) {
//			System.err.println(char1[i] + "***" + str.charAt(i));
//			if (char1[i] != str.charAt(i)) {
//				++sum;
//			}
//		}
//		return sum;
//	}

	public static int stringHuo(int length, String str) {
		// TODO Auto-generated method stub
		int sum = 0;
		for (int i = 0; i < length; i++) {
			// System.out.println(str.charAt(i)+":"+str.charAt(str.length()-length+i));
			if (str.charAt(i) != str.charAt(str.length() - length + i)) {
				// System.out.println(i+":"+sum);
				sum++;
			}
		}
		return sum;
	}
}