/*
 * @auth
 * hiho 1039
 * status：AC
 */
package prepare.code.hiho.problem;

//import java.util.ArrayList;
//import java.util.List;
import java.util.Scanner;

public class hiho1039 {
	// public class Main {
	// }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner scanner = new Scanner(System.in);
		int cases = scanner.nextInt();
		while (cases != 0) {
			String str = scanner.next();
			int maxScore = game(str);
			System.out.println(maxScore);
			cases--;
		}
		scanner.close();
	}

	private static int game(String str) {
		// TODO Auto-generated method stub

		StringBuffer preBuffer;
		String[] ABC = { "A", "B", "C" };
		int length = str.length();
		int score, maxScore = -1;
		for (int i = 0; i <= length; i++) {
			for (int j = 0; j < 3; j++) {
				preBuffer = new StringBuffer(str.substring(0, i));
				preBuffer.append(ABC[j]);
				preBuffer.append(str.substring(i));
				// System.out.println(i+"\t"+j+"\t"+preBuffer);
				score = eliminate(preBuffer);
				// System.out.println(score);
				if (score > maxScore) {
					maxScore = score;
				}
			}

		}

		return maxScore;
	}

	private static int eliminate(StringBuffer preBuffer) {
		// TODO Auto-generated method stub
		boolean changed = true;
		int start = 0, end = 0;
		int count = 0;

		while (changed) {
			changed = false;
			int n = preBuffer.length();
			int i = n - 1;
			while (i >= 0) {
				start = i + 1;
				end = i + 1;
				while (i >= 1 && preBuffer.charAt(i) == preBuffer.charAt(i - 1)) {
					changed = true;
					start--;
					i--;
				}

				if (start != end) {
					start = i;
					count += end - start;
					preBuffer.delete(start, end);

				}

				i--;
			}
		}

		return count;
	}

}
