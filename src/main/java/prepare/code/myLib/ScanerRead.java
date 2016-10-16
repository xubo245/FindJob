package prepare.code.myLib;

import java.util.Scanner;

public class ScanerRead {
public static void main(String[] args) {
	Scanner input=new Scanner(System.in);
//	System.out.println(input);
	int[]num = new int[2];
	for(int i=0;i<2;i++){
		System.out.print("请输入第" + (i+1) +"个数字:");
		num[i] = input.nextInt();
	}
	for(int getNum: num){
		System.out.println("输入的数字为：" + getNum);
	}
	input.close();
}
}
