package prepare.code.hiho.problem;
/**
 * @author xubo
 * @time 20160407
 * @num 1015
 * @name KMP algorithms
 * status:AC
 */
import java.util.Scanner;

public class hiho1015 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int flag = in.nextInt();
		while (flag > 0) {
			// System.out.println("falg:"+flag);
			String a = in.next();
			String b = in.next();
			System.out.println(findSum(b, a));
			// System.out.println(a + b);
			--flag;
		}
		in.close();
	}

	public static int findSum(String A, String B) {
		int q = 0;
		int[] strPI = computePrefix(B);
		int sum = 0;
		int n = A.length();
		int m = B.length();
		int max = 0;
		// System.out.println(B+"==="+A);
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
			if (max < q) {
				max = q;
			}
			// System.out.println("i:" + i + " max:" + max);
			if (max == m) {
				// System.out.println("max");
				// return max;
				++sum;
				max = 0;
				q = strPI[q - 1];
			}
		}
		// System.out.println("******");
		return sum;
	}

	public static int[] computePrefix(String str) {
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
			strPI[q] = k;
		}
		return strPI;
	}
}