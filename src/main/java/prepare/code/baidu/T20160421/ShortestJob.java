package prepare.code.baidu.T20160421;
// IMPORT LIBRARY PACKAGES NEEDED BY YOUR PROGRAM
// SOME CLASSES WITHIN A PACKAGE MAY BE RESTRICTED
// DEFINE ANY CLASS AND METHOD NEEDED
// CLASS BEGINS, THIS CLASS IS REQUIRED
public class ShortestJob
{
  // METHOD SIGNATURE BEGINS, THIS METHOD IS REQUIRED
  public static float waitingTimeSJF(int[] requestTimes, int[] durations)
  {
    // INSERT YOUR CODE HERE
    float returnF=0;
    int requestTimesLegnth=requestTimes.length;
    int durationsLegnth=durations.length;
    int[] arr1=new int[requestTimesLegnth];
    int[] arr2=new int[durationsLegnth+1];
    for(int i=0;i<requestTimesLegnth;i++){
    	arr1[i]=1;
    	arr2[i]=0;
    }
    
    for(int i=0;i<requestTimesLegnth;i++){
//    	 requestTimes.
    	int min=10000;
    	int minJ=0;
    	
    	 for(int j=0;j<requestTimesLegnth;j++){
    	    	if(arr1[j]==1 && requestTimes[j]<=arr2[i]){
    	    		if(durations[j]<min){
    	    			min=durations[j];
    	    			minJ=j;
    	    		}
    	    	}
    	    }
//    	 System.out.println(i+":"+min+":"+(arr2[i]-requestTimes[minJ])+" return :"+returnF);
    	 arr1[minJ]=0;
    	 arr2[i+1]=arr2[i]+min;
    	 returnF=returnF+arr2[i]-requestTimes[minJ];
    }
    
    return returnF/requestTimesLegnth;
  }
  // METHOD SIGNATURE ENDS
}