package prepare.code.hiho.micresoft.mstest2016april1;
/**
 * @author xubo
 * @time 20160405
 * @num hiho1000
 */

import java.util.Scanner;

public class microsoft1 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
//		while (in.hasNext()) {
			int cases = in.nextInt();
			int tag = 0;

			while (tag < cases) {
				int[] arr = new int[4];
				for (int i = 0; i < 4; i++) {
					arr[i] = in.nextInt();
				}
				int sMin = Math.min(arr[2], arr[3]);
				int[] size = new int[arr[0]];
				for (int j = 0; j < arr[0]; j++) {
					size[j] = in.nextInt();
				}
				int s = 0;
				int sumLine = 0;
				int pageOut = 0;
				int sOut = 0;
				// System.out.println("start="+sMin);
				for (s = 1; s <= sMin; s++) {
					// System.out.println("s="+s);
					sumLine=0;
					for (int i = 0; i < arr[0]; i++) {
						int a = arr[2] / s;
						int b = size[i] / a;
						if (size[i] % a > 0) {
							++b;
						}
						sumLine +=b;
//						System.out.println(i+":"+sumLine);
					}
					
					int hLine = arr[3] / s;
					int page = sumLine / hLine;
					// System.out.println("page=:"+page);
					if (sumLine % hLine > 0) {
						++page;
					}
//					System.out.println("tag:"+tag+" s="+ s+" sumLine:"+sumLine+" hLine="+hLine+" page="+page);
				
					if (page > arr[1]) {
						break;
					}
					sOut = s;
					pageOut = page;
				}
				// System.out.println("end:");
				System.out.println(sOut);
				++tag;
			}
//		}
		in.close();
	}
}