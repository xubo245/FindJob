/**
 * @author xubo
 * status：AC
 */
package prepare.code.hiho.problem;

import java.util.ArrayList;
import java.util.Scanner;

public class hiho1040 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int count = 0;
		ArrayList<Long> list = new ArrayList<Long>();
		ArrayList<Boolean> resultList = new ArrayList<Boolean>();
		count = in.nextInt();
		int size = count * 16 - 1;
		while (size >= 0) {
			list.add(in.nextLong());
			size--;
		}
		// 判断是否为矩形，只需判断四个角是否为直角 和是否为封闭形状

		for (int index = 0; index < count; index++) {
			ArrayList<Long> tempList = new ArrayList<Long>();
			for (int subIndex = 0; subIndex < 16; subIndex++) {
				tempList.add(list.get(index * 16 + subIndex));
			}
			if (isClosed(tempList)) {
				// 判断直角
				if (is90(tempList)) {
					resultList.add(true);
				} else {
					resultList.add(false);
				}
			} else {
				resultList.add(false);
			}
		}
		for (Boolean result : resultList) {
			if (result) {
				System.out.println("YES");
			} else {
				System.out.println("NO");
			}
		}
		in.close();
	}

	public static boolean isClosed(ArrayList<Long> list) {
		boolean result = true;
		ArrayList<TPoint> pointList = new ArrayList<TPoint>();
		for (int index = 0; index < 8; index++) {
			pointList.add(new TPoint(list.get(index * 2), list
					.get(index * 2 + 1)));
		}
		for (TPoint point : pointList) {
			int findCount = 0;
			for (int index = 0; index < 8; index++) {
				if (point.toString().equals(pointList.get(index).toString())) {
					findCount++;
				}
			}
			if (findCount != 2) {
				result = false;
				break;
			}
		}
		return result;
	}

	public static boolean is90(ArrayList<Long> list) {
		boolean result = false;
		ArrayList<Line> lineList = new ArrayList<Line>();
		for (int index = 0; index < 4; index++) {
			Line line = new Line(list.get(index * 4), list.get(index * 4 + 1),
					list.get(index * 4 + 2), list.get(index * 4 + 3));
			lineList.add(line);
		}
		int chuizhiCount = 0;
		int pingxingCount = 0;
		for (int index = 1; index < 4; index++) {
			if (lineList.get(0).y * lineList.get(index).y == -1
					* lineList.get(0).x * lineList.get(index).x) {
				chuizhiCount++;
			}
			if (lineList.get(0).y * lineList.get(index).x == lineList.get(0).x
					* lineList.get(index).y) {
				pingxingCount++;
			}
		}
		if (pingxingCount == 1 && chuizhiCount == 2) {
			result = true;
		}

		return result;
	}

}

class Line {
	Long x;
	Long y;
	Long xABS;
	Long yABS;
	Long length2;

	Line(Long x1, Long y1, Long x2, Long y2) {
		this.x = x2 - x1;
		this.y = y2 - y1;
		this.xABS = Math.abs(x2 - x1);
		this.yABS = Math.abs(y2 - y1);
		length2 = (xABS * xABS + yABS * yABS);
	}

	public Long getLength() {
		return length2;
	}

}

class TPoint {
	Long x;
	Long y;

	TPoint(long x, long y) {
		this.x = x;
		this.y = y;
	}

	public String toString() {
		return "(" + x + "," + y + ")";
	}
}