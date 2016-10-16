package prepare.code.hiho.micresoft.mstest2016april1;
/**
 * @author xubo
 * @time 20160405
 * @num hiho1000
 * @introduce 没有完成，室友10分
 */
import java.util.Scanner;

public class microsoft3 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int m = in.nextInt();
		char[][] arr = new char[n][m];
		for (int i = 0; i < n; i++) {
			arr[i] = in.next().toCharArray();
		}
		// for (int i = 0; i < n; i++) {
		// for (int j = 0; j < m; j++) {
		// System.out.print(arr[i][j]);
		// }
		// System.out.println();
		// }

		System.out.println(compute(n, m, arr, 'r'));
		System.out.println(compute(n, m, arr, 'd'));
		// compute(n, m, arr, 'd') - 1
		// for (int i = 0; i < n; i++) {
		// int sum = 0;
		// int j;
		// for (j = 0; j < m; j++) {
		// if (arr[i][j] == 'b') {
		// ++sum;
		// }
		// }
		// for (int k = i+1; k < n; k++) {
		// if (arr[k][j] == 'b') {
		// ++sum;
		// }
		// }
		// sumMin=Math.min(sum, sumMin);
		// // System.out.println();
		// }
		// System.out.println(sumMin);
		in.close();
	}

	public static int compute(int n, int m, char[][] arr, char fx) {
		// System.out.println(n+":"+m+":"+arr[0].length+"=="+arr.length);
		if (n == 1 && m == 1) {
			if (arr[0][0] == 'b') {
				return 1;
			} else {
				return 0;
			}
		}
		int right = 0;
		int down = 0;

		if (n > 1 && m == 1) {
			// System.out.println("****n>1-m=0*****"+n+":"+m+":"+arr[0].length+"=="+arr.length);
			if (arr[1][0] == 'b') {
				down = 1;
			}
			return compute(n - 1, m, computeD(n, m, arr), 'd') + down;
		} else if (n == 1 && m > 1) {
			if (arr[0][1] == 'b') {
				right = 1;
			}
			return compute(n, m - 1, computeR(n, m, arr), 'r') + right;
		} else {
			if (arr[0][1] == 'b') {
				right = 1;
			}
			if (arr[1][0] == 'b') {
				down = 1;
			}
			// System.out.println("other:"+n+":"+m);
			char[][] arrD = computeD(n, m, arr);
			char[][] arrR = computeR(n, m, arr);
			if (fx == 'r' && right == 0) {
				return compute(n, m - 1, arrR, 'r') + right;
			} else if (fx == 'd' && down == 0) {
				return compute(n - 1, m, arrD, 'd') + down;
			} else if (down == 1 && right == 1) {
				if (fx == 'r') {
					return compute(n, m - 1, arrR, 'r') + right;
				} else {
					return compute(n - 1, m, arrD, 'd') + down;
				}
			} else if ((compute(n - 1, m, arrD, 'd') + down) > (compute(n,
					m - 1, arrR, 'r') + right)) {
				// to down
				return compute(n - 1, m, arrD, 'd') + down;
			} else {
				// to right
				return compute(n, m - 1, arrR, 'r') + right;
			}
		}
		// return 1;
	}

	public static char[][] computeD(int n, int m, char[][] arr) {
		char[][] arr1 = new char[n - 1][m];
		for (int i = 1; i < n; i++) {
			for (int j = 0; j < m; j++) {
				arr1[i - 1][j] = arr[i][j];
			}
		}
		return arr1;
	}

	public static char[][] computeR(int n, int m, char[][] arr) {
		char[][] arr1 = new char[n][m - 1];
		for (int i = 0; i < n; i++) {
			for (int j = 1; j < m; j++) {
				arr1[i][j - 1] = arr[i][j];
			}
		}
		return arr1;
	}

	public static int computeDown(int n, int m, char[][] arr) {
		if (n == 0 && m == 0) {
			if (arr[n][m] == 'b') {
				return 1;
			} else {
				return 0;
			}
		}
		char[][] arr1 = new char[n - 1][m];
		for (int i = 1; i < n; i++) {
			for (int j = 0; j < m; j++) {
				arr1[i - 1][j] = arr[i][j];
			}
		}
		if (arr[0][1] == 'b') {
			return computeDown(n - 1, m, arr1) + 1;
		} else {
			return computeDown(n - 1, m, arr1);
		}
	}

	public static int computeRight(int n, int m, char[][] arr) {
		// for (int i = 0; i < n; i++) {
		// for (int j = 0; j < m; j++) {
		// System.out.print(arr[i][j]);
		// }
		// System.out.println();
		// }
		if (n == 0 && m == 0) {
			if (arr[n][m] == 'b') {
				return 1;
			} else {
				return 0;
			}
		}
		char[][] arr1 = new char[n][m - 1];
		for (int i = 0; i < n; i++) {
			for (int j = 1; j < m; j++) {
				arr1[i][j - 1] = arr[i][j];
			}
		}
		if (arr[1][0] == 'b') {
			return computeRight(n, m - 1, arr1) + 1;
		} else {
			return computeRight(n, m - 1, arr1);
		}
	}
}