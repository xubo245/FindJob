package prepare.code.nowCoder.problem;

//public class LongetSubstring1 {
//
//}

//import java.util.*;

public class LongestSubstring1 {
	public int findLongest(String A, int n, String B, int m) {
		if (n <= 0 || m <= 0) {
			return 0;
		}
		char a1[] = A.toCharArray();
		char b1[] = B.toCharArray();
		int c[][] = new int[n][m];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (a1[i] == b1[j]) {
					if (i == 0 && j == 0) {
						c[i][j] = 1;
					} else {
						if (i == 0 || j == 0) {
							c[i][j] = 1;
						} else {
							c[i][j] = c[i - 1][j - 1] + 1;
						}
					}
				} else {
					c[i][j] = 0;
				}
			}
		}
		int maxlen = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				maxlen = maxlen > c[i][j] ? maxlen : c[i][j];
			}
		}
		return maxlen;
	}
}
