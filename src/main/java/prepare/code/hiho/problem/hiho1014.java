/**
 * @author xubo
 * @time 20160406
 * @name hiho1014
 * @version 1
 * status：AC
 */
package prepare.code.hiho.problem;

import java.util.LinkedList;
import java.util.Scanner;

public class hiho1014 {

	private Node root;

	public hiho1014() {
		root = new Node('A');
	}

	public void insert(String word) {
//		if (search(word) == true){
//			
//			return;
//		}
//			

		Node current = root;
		for (int i = 0; i < word.length(); i++) {
			Node child = current.subNode(word.charAt(i));
			if (child != null) {
				current.count += 1;
				current = child;
			} else {
				current.childList.add(new Node(word.charAt(i)));
				current.count += 1;
				current = current.subNode(word.charAt(i));

			}
		}
		current.count += 1;
		current.isEnd = true;

	}

	public void showTrie(Node node) {
		Node current = node;
		for (Node eachChild : current.childList) {
			if (eachChild != null) {
				System.out.println("content:" + eachChild.content + " count:"
						+ eachChild.count);
				showTrie(eachChild);
			}
		}
	}

	public boolean search(String word) {
		Node current = root;

		for (int i = 0; i < word.length(); i++) {
			if (current.subNode(word.charAt(i)) == null)
				return false;
			else
				current = current.subNode(word.charAt(i));
		}

		if (current.isEnd == true)
			return true;
		else
			return false;
	}

	public int searchWordCount(String word) {
		Node current = root;
		for (int i = 0; i < word.length(); i++) {
			if (current.subNode(word.charAt(i)) == null) {
				return 0;
			} else {
				current = current.subNode(word.charAt(i));
			}
		}
		return current.count;
	}

	public void deleteWord(String word) {
		if (search(word) == false)
			return;

		Node current = root;
		for (char c : word.toCharArray()) {
			Node child = current.subNode(c);
			if (child.count == 1) {
				current.childList.remove(child);
				return;
			} else {
				child.count--;
				current = child;
			}
		}
		current.isEnd = false;
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int numWord = 0;
		int numSearch = 0;
		int i = 0;

		hiho1014 trie = new hiho1014();
		int cases = in.nextInt();

		numWord = cases;
		while (cases != 0) {
			++i;
			if (i <= numWord) {
				trie.insert(in.next().toString());
//				System.out.print("->"+i);
			} else if (i == numWord + 1) {
				numSearch = in.nextInt();
			} else {
				if (i == (numWord + numSearch + 1)) {
					cases = 0;
				}
//				System.out.print("->"+i+":");
				System.out.println(trie.searchWordCount(in.next().toString()));
			}
		}
//		trie.showTrie(trie.root);
		in.close();
	}
}

class Node {
	char content; 
	boolean isEnd; 
	int count; 
	LinkedList<Node> childList;

	public Node(char c) {
		childList = new LinkedList<Node>();
		isEnd = false;
		content = c;
		count = 0;
	}

	public Node subNode(char c) {
		if (childList != null) {
			for (Node eachChild : childList) {
				if (eachChild.content == c) {
					return eachChild;
				}
			}
		}
		return null;
	}
}
