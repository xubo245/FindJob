package prepare.code.codehunt.bop;
public class Program {
	public static int[] Puzzle(float[] a) {
		int aLength = a.length;
		int[] b = new int[aLength];
		float min = 100000;
		float max = -100000;
		// int minI = 0;
		for (int i = 0; i < aLength; i++) {
			if (a[i] < min) {
				min = a[i];
			}
			if (a[i] > max) {
				max = a[i];
			}
			b[i] = 0;
		}
		// System.out.println("max:" + max + " min:" + min);
		int bb = 0;
		for (int i = 0; i < aLength; i++) {
			if (a[i] == min) {
				b[i] = 0;
			} else if (a[i] < max) {
				// b[i] = Math.abs((int) a[i] / 3);
				if (a[i] - min > 2) {
					b[i]=2;
				} else {
					b[i]=1;
				}
				bb = b[i];

			}
		}
		for (int i = 0; i < aLength; i++) {
			if (a[i] == max && max > min) {
				b[i] = bb + 1;
			}
		}
		return b;
	}
}