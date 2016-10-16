package prepare.code.nowCoder.problem;

//public class LongeetSubstring2 {
//
//}

//import java.util.*;

public class LongeetSubstring2 {
    public int findLongest(String A, int n, String B, int m) {
         char[] query = A.toCharArray();
        char[] text = B.toCharArray();
        //模拟二位矩阵
        int[][]c = new int [n][m];
        int count = 0;
        for(int i = 0; i < n;i++) {
            for(int j = m-1; j>=0;j--) {
                if(query[i] == text[j]) {
                    if(i==0||j==0) {
                        c[i][j] = 1;
                    } else {
                        c[i][j] = c[i-1][j-1]+1;
                    }
                } else {
                    c[i][j] = 0;
                }
                if(c[i][j] > count) {
                   count = c[i][j] ;
                }
            }
        }
        return count;
    }
}