package prepare.code.codehunt.bop;
public class program3 {
	public static int Puzzle(int[] a) {
		int aLength = a.length;
		int returnI = 0;
		int tmp;

		for (int i = 0; i < aLength; i++) {
			for (int j = aLength - 1; j > 0; j--) {
				if (a[j] < a[j - 1]) {
					// System.out.println(i+"changr:"+a[i]+":"+a[j]);
					tmp = a[j];
					a[j] = a[j - 1];
					a[j - 1] = tmp;
				}
			}
		}
		// for (int i = 0; i < aLength; i++) {
		// System.out.println(i+":"+a[i]);
		// }
		int x = (int) (aLength+1) / 2;
		if (aLength == 1){
			returnI = a[aLength - 1];
		}else if(aLength%2==0){
			returnI=(a[0]+a[aLength-1])/2;
		}else {
			returnI=a[x-1];
		}
		return returnI;
	}
}
