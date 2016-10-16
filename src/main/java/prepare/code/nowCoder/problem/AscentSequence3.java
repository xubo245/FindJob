package prepare.code.nowCoder.problem;
//package job;
//
//public class AscentSequence3 {
//	  public int findLongest(int[] A, int n) {
//		  int max;
//	       int[] result = new int[n];
//	        for (int i = 0; i < n; i++) {
//	            result[i] = 1;
//	        }
//	        for (int i = 0; i < n; i++) {
//	            int length = result[i];
//	            for (int j = i - 1; 0 <= j; j--) {
//	                if (A[i] > A[j]) {
//	                    int temp = result[j] + 1;
//	                    if (temp > length) {
//	                        length = temp;
//	                    }
//	                }
//	            }
//	            result[i] = length;
//	        }
//	        return max;
//	  }
//}
