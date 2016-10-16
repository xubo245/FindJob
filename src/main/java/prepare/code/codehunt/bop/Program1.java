package prepare.code.codehunt.bop;
public class Program1 {
	public static int[] Puzzle(float[] a) {
		int[] b = new int[a.length];
		float[] a1 = new float[a.length];
		for (int i = 0; i < a.length; i++) {
			a1[i] = a[i];
		}
		float tmp;
		int aLength = a.length;
		for (int i = 0; i < aLength; i++) {
			for (int j = aLength - 1; j > 0; j--) {
				if (a1[j] < a1[j - 1]) {
					// System.out.println(i+"changr:"+a[i]+":"+a[j]);
					tmp = a1[j];
					a1[j] = a1[j - 1];
					a1[j - 1] = tmp;
				}
			}
		}
//		for (int i = 0; i < aLength; i++) {
//			System.out.println(i+":"+a1[i]);
//		}
		for (int i = 0; i < aLength; i++) {
			for (int j = 0; j < aLength; j++) {
				if(a[i]==a1[j]){
					b[i]=j;
					break;
				}
			}
		}
		return b;
	}
}
