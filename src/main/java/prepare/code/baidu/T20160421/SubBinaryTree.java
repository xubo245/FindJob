package prepare.code.baidu.T20160421;
// IMPORT LIBRARY PACKAGES NEEDED BY YOUR PROGRAM
// SOME CLASSES WITHIN A PACKAGE MAY BE RESTRICTED
// DEFINE ANY CLASS AND METHOD NEEDED
// TNode CLASS IS DEFINED BY DEFAULT
// CLASS BEGINS, THIS CLASS IS REQUIRED
public class SubBinaryTree {
	// METHOD SIGNATURE BEGINS, THIS METHOD IS REQUIRED
	public static int isSubTree(TNode root1, TNode root2) {
		// INSERT YOUR CODE HERE
		TNode root11=search(root1,root2);
		
		if(root11.value==root2.value){
			isSubTree(root11.left,root2.left);
			isSubTree(root11.left,root2.left);
		}else{
			return -1;
		}		
		return 1;
	}
	
	public static TNode search(TNode root1, TNode root2){
//		TNode t1;
		if(root1.value==root2.value){
			return root1;
		}else{
			search(root1.left,root2);
			search(root1.right,root2);
		}
		return null;
	}
	// METHOD SIGNATURE ENDS
}

