/**
 * @author xubo
 * status：WA
 */
package prepare.code.hiho.problem.failed;
import java.util.Scanner;

public class hiho1103 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String str = "";
		while (in.hasNext()) {
			// String str= in.nextLine();
			str = in.nextLine();
			int countRed = 0;
			int countBlue = 0;
			int countYellow = 0;
			int flagRed = 0;
			int flagYellow = 0;
			int flagBlue = 0;
			String[] stack = new String[30];
			int stackLength = 0;
			for (int i = 0; i < str.length(); i++) {
				if (str.charAt(i) == '<' && str.charAt(i + 1) != '/') {
					// System.out.println(i);
					// System.out.println(str.substring(i + 1, i + 4));
					if (str.substring(i + 1, i + 4).equals("red")) {
						// System.out.println("red:"+i);
						flagRed = 1;
						flagYellow = 0;
						flagBlue = 0;
						i = i + 5;
						stack[stackLength] = "red";
						stackLength++;
						// continue;
					}
					if (str.substring(i + 1, i + 5).equals("blue")) {
						flagBlue = 1;
						flagRed = 0;
						flagYellow = 0;
						i = i + 6;
						stack[stackLength] = "blue";
						stackLength++;
					}
					if (str.substring(i + 1, i + 7).equals("yellow")) {
						flagYellow = 1;
						flagRed = 0;
						flagBlue = 0;
						i = i + 8;
						stack[stackLength] = "yellow";
						stackLength++;
					}
				}
				if (str.charAt(i) == '<' && str.charAt(i + 1) == '/') {
					i++;
					if (str.substring(i + 1, i + 4).equals("red")) {
						// System.out.println("end red:"+i);
						flagRed = 0;
						flagYellow = 0;
						flagBlue = 0;
						i = i + 4;
						stackLength--;
						if (stackLength > 0) {
							if (stack[stackLength - 1].equals("red")) {
								flagRed = 1;
							}
							if (stack[stackLength - 1].equals("yellow")) {
								flagYellow = 1;
							}
							if (stack[stackLength - 1].equals("blue")) {
								flagBlue = 1;
							}
						}
					} else if (str.substring(i + 1, i + 5).equals("blue")) {
						// System.out.println("/blue:"+i);
						flagRed = 0;
						flagYellow = 0;
						flagBlue = 0;
						i = i + 5;
						--stackLength;
						// System.out.println("stackLength:"+stackLength);
						if (stackLength > 0) {
							if (stack[stackLength - 1].equals("red")) {
								flagRed = 1;
							}
							if (stack[stackLength - 1].equals("yellow")) {
								flagYellow = 1;
							}
							if (stack[stackLength - 1].equals("blue")) {
								flagBlue = 1;
							}
						}
					} else if (str.substring(i + 1, i + 7).equals("yellow")) {
						// System.out.println("red:"+i);
						flagRed = 0;
						flagYellow = 0;
						flagBlue = 0;
						i = i + 7;
						stackLength--;
						if (stackLength > 0) {
							if (stack[stackLength - 1].equals("red")) {
								flagRed = 1;
							}
							if (stack[stackLength - 1].equals("yellow")) {
								flagYellow = 1;
							}
							if (stack[stackLength - 1].equals("blue")) {
								flagBlue = 1;
							}
						}
					}
				}
				// System.out.println(flagRed+":"+flagYellow+":"+flagBlue);
				if (flagRed == 1) {
					if (str.charAt(i) != '<' && str.charAt(i) != '>'
							&& str.charAt(i) != ' ') {
						countRed++;
					}
				} else if (flagYellow == 1) {
					if (str.charAt(i) != '<' && str.charAt(i) != '>'
							&& str.charAt(i) != ' ') {
						countYellow += 1;
					}
				} else if (flagBlue == 1) {
					if (str.charAt(i) != '<' && str.charAt(i) != '>'
							&& str.charAt(i) != ' ') {
						countBlue += 1;
					}
				}
				// System.out.println(i+":"+stackLength+":"+" flag:"+flagRed+":"+flagYellow+":"+flagBlue+"***count***"+countRed
				// + " " + countYellow + " " + countBlue);
				// if(stackLength>0){System.out.println(str.charAt(i)+":"+stack[stackLength-1]);}
			}
			System.out.println(countRed + " " + countYellow + " " + countBlue);
			// System.out.println();
			// System.out.println(flagRed+":"+flagYellow+":"+flagBlue);
			// System.out.println(":"+stackLength+":"+str.length());
		}

		in.close();
	}
}
