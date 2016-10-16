package prepare.code.nowCoder.problem;

public class fork1 {
//	int main(){fork()||fork();}
	int sum=0;
	int ack(int m,int n)
	{   
		System.out.println(m+":"+n);
//		sum++;
//		System.out.println("***"+sum+"***");
	    if(m==0)
	    {
	    return n+1;
	    }
	    else if(n==0)
	    {
	        return ack(m-1,1);
	    }
	    else
	    {
//	    	System.out.println(m+":"+n);
	        return ack(m-1,ack(m,n-1));
	    }
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		fork1 f1=new fork1();
		System.out.println(f1.ack(3,3));
	}
	

}
