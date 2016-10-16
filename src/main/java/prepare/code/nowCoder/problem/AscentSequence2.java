package prepare.code.nowCoder.problem;

//import java.util.*;

public class AscentSequence2 {
    public int findLongest(int[] A, int n) {
       int[] result = new int[n];
        for (int i = 0; i < n; i++) {
            result[i] = 1;
        }
        for (int i = 0; i < n; i++) {
            int length = result[i];
            for (int j = i - 1; 0 <= j; j--) {
                if (A[i] > A[j]) {
                    int temp = result[j] + 1;
                    if (temp > length) {
                        length = temp;
                    }
                }
            }
            result[i] = length;
        }
         
        int max=0;
        for(int i=0;i<n;i++){
            if(result[i]>max){
              max=result[i];               
            }
        }
        return max;
    }
}