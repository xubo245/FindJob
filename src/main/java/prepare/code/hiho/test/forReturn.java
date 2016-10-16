package prepare.code.hiho.test;


public class forReturn {
public static void main(String[] args) {
	forReturn f1=new forReturn();
	int a=f1.for1(10);
	System.out.println("a="+a);
}
public int for1(int n){
	for(int i=0;i<=100;i++){
		if(i==n){
			return 0;
		}
		System.out.println(i);
	}
	return 1;
}
}
