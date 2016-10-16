/**
 * @author xubo
 * 
 * 题目：
 * 题目描述
对于字符串A，其中绝对不含有字符’.’和’*’。再给定字符串B，其中可以含有’.’或’*’，’*’字符不能是B的首字符，并且任意两个’*’字符不相邻。exp中的’.’代表任何一个字符，B中的’*’表示’*’的前一个字符可以有0个或者多个。请写一个函数，判断A是否能被B匹配。
给定两个字符串A和B,同时给定两个串的长度lena和lenb，请返回一个bool值代表能否匹配。保证两串的长度均小于等于300。
测试样例：
"abcd",4,".*",2
返回：true
From:http://www.nowcoder.com/practice/28acd1134e344040ad105b3786a79e7a?tpId=49&tqId=29355&rp=1&ru=/ta/2016test&qru=/ta/2016test/question-ranking
 */
package prepare.code.nowCoder.problem;
//import java.util.*;
public class WildMatch {
	public boolean chkWildMatch(String A, int lena, String B, int lenb) {
        // write code here
//		System.out.println(A.contains(".")||A.contains("."));
        if (A.contains(".")||A.contains(".")){
        	 return false;
        }
        if(B.charAt(0)=='*'){
//        	System.out.println("B can not");
        	return false;
        }
        int flag=0;
//        int flagChar=0;
        for(int i=0;i<lenb;i++){
//        	if(!(B.charAt(i)=='*'||B.charAt(i)=='.')){flagChar=1; return false;}
        	if(flag==1 && (B.charAt(i)=='*')) {return false;}
        	if(B.charAt(i)=='*') {flag=1;} else{flag=0;}        	
        }
        int j=0;
        int flagLength=lena-lenb;
        for(int i=0;i<lena;i++){
//        	System.out.println("i:"+i+" j:"+j);
        	if(B.charAt(j)=='.') {
        		j++;
        		flagLength--;
        		continue;
        	}
        	if(B.charAt(j)=='*') {
        		if(j<lenb-1){
        		if(B.charAt(j-1)=='.' && A.charAt(i)!=B.charAt(j+1)) {
        			flagLength--;
        			continue;
        		}
//        		if(B.charAt(j-1)=='.' && A.charAt(i)!=B.charAt(j+1)) {
//        			flagLength--;
//        			continue;
//        		}
        		if(flagLength!=0){flagLength--;continue;}
                j++;
                continue;
        		}else{
        			flagLength--;
        			continue;
        		}
        	}
        	if(A.charAt(i)==B.charAt(j)){
        		j++;
        		continue;
        	}else{
        		return false;
        	}
        }
//        System.out.println(B.charAt(0));
        return true;
    }
}
