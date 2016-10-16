/**
 * @author xubo
 * status：WA
 */
package prepare.code.hiho.problem.failed;
import java.util.Scanner;

public class hiho1103V2 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String str = "";
//		while (in.hasNext()) {
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
//				System.out.println(i+"============="+str.charAt(i));
				if (str.charAt(i) == '<' && str.charAt(i + 1) != '/') {
					// System.out.println(i);
					// System.out.println(str.substring(i + 1, i + 4));
					flagRed = 0;
					flagYellow = 0;
					flagBlue = 0;
					if (str.charAt(i + 1) == 'r') {
						// System.out.println(str.charAt(i + 1));
						// System.out.println("red:" + i);
						flagRed = 1;
						i = i + 5;
						stack[stackLength] = "red";
						stackLength++;
						// continue;
					} else if (str.charAt(i + 1) == 'b') {
						flagBlue = 1;
						i = i + 6;
						stack[stackLength] = "blue";
						stackLength++;
					} else if (str.charAt(i + 1) == 'y') {
						flagYellow = 1;
						i = i + 8;
						stack[stackLength] = "yellow";
						stackLength++;
					}
				}
				if (str.charAt(i) == '<' && str.charAt(i + 1) == '/') {
					i++;
					flagRed = 0;
					flagYellow = 0;
					flagBlue = 0;
					stack[stackLength] = "";
					stackLength--;
					if (str.charAt(i + 1) == 'r') {
						i = i + 4;
					} else if (str.charAt(i + 1) == 'b') {
						i = i + 5;
					} else if (str.charAt(i + 1) == 'y') {
						i = i + 7;
					}
					if(i>=str.length()-1){
					break;	
					}
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
					continue;
				}
				// System.out.println(flagRed+":"+flagYellow+":"+flagBlue);
				
				if (flagRed == 1) {
					if (str.charAt(i) != ' ') {
						countRed++;
					}
				} else if (flagYellow == 1) {
					if (str.charAt(i) != ' ') {
						countYellow += 1;
					}
				} else if (flagBlue == 1) {
					if (str.charAt(i) != ' ') {
						countBlue += 1;
					}
				}
//				 System.out.println(i + ":" + stackLength + ":" + " flag:"
//				 + flagRed + ":" + flagYellow + ":" + flagBlue
//				 + "***count***" + countRed + " " + countYellow + " "
//				 + countBlue);
//				 if (stackLength > 0) {
//				 System.out.println(str.charAt(i) + ":"
//				 + stack[stackLength - 1]);
//				 }
			}
			System.out.println(countRed + " " + countYellow + " " + countBlue);
//		}
		in.close();
	}
}
