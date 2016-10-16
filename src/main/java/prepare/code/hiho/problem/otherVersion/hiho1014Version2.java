/**
 * @author xubo
 * @time 20160406
 * @name hiho1014
 * @version 2
 * reference http://blog.csdn.net/u013983741/article/details/50902747
 * status：AC
 */
package prepare.code.hiho.problem.otherVersion;

//import java.util.ArrayList;
import java.util.Scanner;

public class hiho1014Version2 {

	// }
	// public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		// n为词典条目数
		int n = 0;
		n = scanner.nextInt();
		// 词典
		String dictionary[] = new String[n];
		int index1 = 0;
		while (index1 < n) {
			dictionary[index1] = scanner.next();
			index1++;
		}
		// m 为查询条目数
		int m = 0;
		m = scanner.nextInt();
		// 检查词前缀
		String search[] = new String[m];
		long[] searchResult = new long[m];
		int index2 = 0;
		while (index2 < m) {
			search[index2] = scanner.next();
			index2++;
		}

		// 创建根节点
		Node rootNode = new Node('A');

		// 创建词典
		for (int index = 0; index < n; index++) {
			String dicWord = dictionary[index];
			int wordLength = dicWord.length();
			char[] dicChars = dicWord.toCharArray();
			Node tempNode = rootNode;
			// 将某一个词放入词典
			for (int innerIndex = 0; innerIndex < wordLength; innerIndex++) {
				tempNode = tempNode.getNextNode(dicChars[innerIndex]);
			}
		}

		// 使用Trie树 从search[]读取
		for (int index = 0; index < m; index++) {
			long appearCount = 0;
			String searchWord = search[index];
			int wordLength = searchWord.length();
			char[] searchChars = searchWord.toCharArray();
			Node tempNode = rootNode;
			for (int innerIndex = 0; innerIndex < wordLength; innerIndex++) {
				tempNode = tempNode.findNextNode(searchChars[innerIndex]);
				if (tempNode != null) {
					appearCount = tempNode.T;
				}
				if (tempNode == null) {
					appearCount = 0;
					break;
				}
			}
			// 储存结果
			searchResult[index] = appearCount;
			System.out.println(searchResult[index]);

		}
		scanner.close();

	}
}

class Node {

	char text;
	long T;
	Node[] nextNodeList;

	Node(char text) {
		this.text = text;
		T = 0;
		nextNodeList = new Node[26];
	}

	Node getNextNode(char c) {
		Node newNode;
		int index = c - 'a';
		if (nextNodeList[index] == null) {
			newNode = new Node(c);
			nextNodeList[index] = newNode;
			newNode.addT();
		} else {
			newNode = nextNodeList[index];
			newNode.addT();
		}
		return newNode;
	}

	void addT() {
		T++;
	}

	Node findNextNode(char c) {
		Node newNode;
		int index = c - 'a';
		if (nextNodeList[index] == null) {

			return null;
		} else {
			newNode = nextNodeList[index];
		}
		return newNode;
	}

}
