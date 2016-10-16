package prepare.code.codehunt.bop;

public class test1 {
	public static void main(String[] args) {
		Program1 p1=new Program1();
//		float[] a={(float) 7.5398,(float) 6.5398,1,1};
//		float[] a={-1, 0, 0};
		float[] a={(float) 11.3, 2, (float) 11.3, 1};
		int[] b=p1.Puzzle(a);
		for(int i=0;i<b.length;i++){
			System.out.println(b[i]);
		}
	}
}
