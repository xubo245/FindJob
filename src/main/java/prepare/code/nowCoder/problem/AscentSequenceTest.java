package prepare.code.nowCoder.problem;

public class AscentSequenceTest {
     public static void main(String[] args) {
    	 AscentSequence a1=new AscentSequence();
    	 AscentSequence2 a2=new AscentSequence2();
    	 int[] inta={46,200,83,24,211,86,61,67};
//    	 [46,200,83,24,211,86,61,67],8
//    	 2,1,4,3,1,5,6
    	 System.out.println(a1.findLongest(inta,8));
    	 System.out.println(a2.findLongest(inta,8));
	}
}
