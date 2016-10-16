package prepare.code.nowCoder.problem;

public class test1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WildMatch a1=new WildMatch();
		System.out.println(a1.chkWildMatch("abcd",4,".*",2)); //true
		System.out.println(a1.chkWildMatch("bwrxr",5,"b.*xr",5)); 
		System.out.println(a1.chkWildMatch("qxajhumxjodz",12,"Dxajhumxjod.",12));//false
		System.out.println(a1.chkWildMatch("mcgzomxmfmm",11,"mcgzom.*m",9));//true
		System.out.println(a1.chkWildMatch("aaaabcd",7,"a*abcd",6));//true
				
	}

}
