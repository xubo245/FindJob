package prepare.code.nowCoder.problem;
//import java.util.*;
public class LCS {
    public int findLCS(String A, int n, String B, int m) {
        int[][]dp=new int[n+1][m+1];
        for(int i=0;i<n+1;i++){
            dp[i][0]=0;
        }
        for(int j=0;j<m+1;j++){
            dp[0][j]=0;
        }
        for(int i=1;i<n+1;i++){
            for(int j=1;j<m+1;j++){
                if(A.charAt(i-1)==B.charAt(j-1)){
                    dp[i][j]=dp[i-1][j-1]+1;
                }else{
                    dp[i][j]=dp[i-1][j]>dp[i][j-1]?dp[i-1][j]:dp[i][j-1];
                }
            }
        }
        return dp[n][m];
    }
}

/*
 
题目描述

对于两个字符串，请设计一个高效算法，求他们的最长公共子序列的长度，这里的最长公共子序列定义为有两个序列U1,U2,U3...Un和V1,V2,V3...Vn,其中Ui&ltUi+1，Vi&ltVi+1。且A[Ui] == B[Vi]。

给定两个字符串A和B，同时给定两个串的长度n和m，请返回最长公共子序列的长度。保证两串长度均小于等于300。
测试样例：

"1A2C3D4B56",10,"B1D23CA45B6A",12

返回：6
 */