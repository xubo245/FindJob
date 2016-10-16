package prepare.code.nowCoder.problem;

//import java.util.*;

public class LongestSubstring {
	public int findLongest(String A, int n, String B, int m) {
		String strA;
		String strB;
		int lenA;
		int lenB;
		if (A.length() > B.length()) {
			strA = A;
			strB = B;
			lenA = n;
			lenB = m;
		} else {
			strA = B;
			strB = A;
			lenA = m;
			lenB = n;
		}
		// System.out.println("strA:" + strA);
		// System.out.println("strB:" + strB);
		// System.out.println("lenA:" + lenA);
		// System.out.println("lenB:" + lenB);

		int strPI = 0;
		int max = 0;
		@SuppressWarnings("unused")
		int maxi = 0;
		for (int i = 0; i < lenB; i++) {
			// System.out.println("*************************************i:" + i
			// + " max:" + max);
			// System.out.println("*************************************i:" + i
			// +" \nStrA:"+strA+" \nlenA:"+ lenA+" \nStrB:"+strB.substring(i,
			// lenB)+" \nlenB:"+(lenB-i));
			strPI = findLongestLCP(strA, lenA, strB.substring(i, lenB), lenB
					- i);
			if (max < strPI) {
				max = strPI;
				maxi = i;
			}
		}
		// System.out.println("maxi:"+maxi);
		// for(int i=0;i<maxi;i++){
		// System.out.println(strB.substring(maxi,maxi+max));
		// }
		return max;
	}

	public int findLongestLCP(String A, int n, String B, int m) {
		// write code here
		int q = 0;
		// int[] strPI = new int[m];
		int[] strPI = computePrefix(B);
		// for(int i1=0;i1<strPI.length;i1++){
		// System.out.print(strPI[i1]+" ");
		// }
		int max = 0;
		// System.out.println("m:"+m+" PIlen:"+strPI.length+" lenA:"+n);
		for (int i = 0; i < n; i++) {
			// System.out.println("i:"+i);
			while (q > 0 && (B.charAt(q) != A.charAt(i))) {
				// System.out.println("while:" + i+" q:"+q);
				q = strPI[q - 1];
			}
			if (B.charAt(q) == A.charAt(i)) {
				// System.out.println("if:" + i+" q="+q);
				q = q + 1;
			}
			if (max < q)
				max = q;
			// System.out.println("i:" + i + " max:" + max);
			if (max == m) {
				// System.out.println("max");
				return max;
			}
		}
		// System.out.println("******");
		return max;
	}

	public int[] computePrefix(String str) {
		int m = str.length();
		int[] strPI = new int[str.length()];
		strPI[0] = 0;
		int k = 0;
		for (int q = 1; q < m; q++) {
			while (k > 0 && (str.charAt(k) != str.charAt(q))) {
				k = strPI[k - 1];
			}
			if (str.charAt(k) == str.charAt(q)) {
				k = k + 1;
			}
			// System.out.println("q="+q+" k="+k);
			strPI[q] = k;
		}
		return strPI;
	}
}

/*
 * 
 * 
 * 题目描述
 * 
 * 对于两个字符串，请设计一个时间复杂度为O(m*n)的算法(这里的m和n为两串的长度)，求出两串的最长公共子串的长度。这里的最长公共子串的定义为两个序列U1,
 * U2,..Un和V1,V2,...Vn，其中Ui + 1 == Ui+1,Vi + 1 == Vi+1，同时Ui == Vi。
 * 
 * 给定两个字符串A和B，同时给定两串的长度n和m。 测试样例：
 * 
 * "1AB2345CD",9,"12345EF",7
 * 
 * 返回：4
 */