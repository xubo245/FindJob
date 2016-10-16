package prepare.code.myLib;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class printFile {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		File f1=new File("file/2.txt");
		PrintWriter p1=null;
		try {
			p1 = new PrintWriter(f1);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		p1.append("hello");
		p1.append("java");
		p1.close();
		System.out.println("success");
	}

}
