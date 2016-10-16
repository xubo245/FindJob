package prepare.code.nowCoder.problem;

public class GrayCode {
	public String[] getGray(int n) {
//		System.out.println(n);
//		try {
//			Thread.sleep(100);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}		
		String[] str0 = new String[(int) Math.pow(2, n)];		
		if (n == 1) {
			str0[0] = "0";
			str0[1] = "1";				
		} else if(n<1){}else{
			String[] aa = getGray(n - 1);
			for (int i = 0; i < (int)Math.pow(2, n - 1); i++) {
				str0[i] = "0".concat(aa[i]);
			}
			for (int i = (int) Math.pow(2, n - 1); i <(int) Math.pow(2, n); i++) {
//				String[] aa = getGray(n - 1);
				str0[i] = "1".concat(aa[(int) Math.pow(2, n) - i - 1]);
			}
		}		
		return str0;	
	}
}
