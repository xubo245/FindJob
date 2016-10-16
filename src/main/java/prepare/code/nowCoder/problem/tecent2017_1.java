package prepare.code.nowCoder.problem;
import java.util.Scanner;
public class tecent2017_1 {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		while(sc.hasNext()){
			String str=sc.next();
			int returnInt=dochange(str);
			System.out.println(returnInt);
		}	
	}
	
	public static  int dochange(String str){
		int numN=1000;
		int[][] f=new int[numN][numN];
		for(int i=0;i<numN;i++)
		{
			for(int j=0;j<numN;j++)
			{
				f[i][j]=0;
			}
		}
		
		char[] s1=new char[2002];
		char[] s=str.toCharArray();
		for(int k=0;k<s1.length;k++)
		{
			if(k<s.length){
			s1[k]=s[k];
			}else{
				s1[k]='0';
			}
		}
		int n=str.length();
		for(int k=0;k<n;k++)
		{
			f[0][k]=0;
			f[1][k]=0;
		} 
		
		for(int i=2;i<=n;i++)
		{	for(int j=0;j<n;j++)
			{
				if(s1[j]==s1[i+j-1])
				{
					f[i][j]=f[i-2][j+1];
				}
				else{
					if(f[i-1][j]<f[i-1][j+1])
					{
						f[i][j]=f[i-1][j]+1;
					}else
					{
						f[i][j]=f[i-1][j+1]+1;
					}
				}
			}
		}
		return f[n][0];
	}
}


//给定一个字符串s，你可以从中删除一些字符，使得剩下的串是一个回文串。如何删除才能使得回文串最长呢？
//输出需要删除的字符个数。
//
//输入描述:
//
//
//输入数据有多组，每组包含一个字符串s，且保证:1<=s.length<=1000.
//  
//
//
//
//输出描述:
//
//
//对于每组数据，输出一个整数，代表最少需要删除的字符个数。
//
//
//输入例子:
//
//abcda
//google
//
//
//输出例子:
//
//2
//2

