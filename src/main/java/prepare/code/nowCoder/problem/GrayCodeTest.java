package prepare.code.nowCoder.problem;

public class GrayCodeTest {
//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//
//	}
	public static void main(String[] arg) {
		GrayCode g = new GrayCode();
//		System.out.println((g.getGray(3))[1]);
		int n=10;
		String[] str1=g.getGray(n);
		for(int i=0;i<Math.pow(2, n);i++){
			System.out.println(str1[i]);
		}
		}

}
