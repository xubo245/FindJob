package prepare.code.nowCoder.problem;
//import java.util.*;

public class Gift {
    public int getValue(int[] gifts, int n) {
        // write code here
//    	int[] length1=gifts.
//    	int a;
   
    	for(int i=0;i<gifts.length;i++){
    	 	int sum=0;
    		for(int j=0;j<gifts.length;j++){
    			if(gifts[i]==gifts[j]){
    				sum++;
    			}
    		}
    		if(sum>n/2){
    			return gifts[i];
    		}
    	}
    	return 0;
    }
}