package prepare.code.nowCoder.problem;

public class AscentSequence {
	public int findLongest(int[] A, int n) {
    int max=0;
    int[] length=new int[n];    
     for(int i=0;i<n;i++){
    	 length[i]=1;
    	 for(int j=i-1;j>=0;j--){    		 
    		 if(A[i]>A[j]){
    			 length[i]=length[j]+1>length[i]?(length[j]+1):length[i];
    		 }
    	 }
    	 if(max<length[i]) max=length[i];
     }
    return max;
	}
}

/*
 * 
 * 题目描述
 * 
 * 对于一个数字序列，请设计一个复杂度为O(nlogn)的算法，返回该序列的最长上升子序列的长度，这里的子序列定义为这样一个序列U1，U2...，其中Ui <
 * Ui+1，且A[Ui] < A[Ui+1]。
 * 
 * 给定一个数字序列A及序列的长度n，请返回最长上升子序列的长度。 测试样例： [2,1,4,3,1,5,6],7 返回：4 *
 */