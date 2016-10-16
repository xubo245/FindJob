package prepare.code.myLib;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class FileRead {

	public FileRead() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) throws IOException {
		File f1 = new File("file/1.txt");
		InputStreamReader i1 = null;
		int i2 = 0;
		String s1=null;
		if (f1.exists()) {
				i1 = new InputStreamReader(new FileInputStream(f1));
			while ((i2 = i1.read()) != -1) {
				System.out.print((char) i2);
			}
			i1.close();
		}
		System.out.println("\nreadBuffer:");
		InputStreamReader in2=new InputStreamReader(new FileInputStream(f1));
		BufferedReader b1=null;
		b1=new BufferedReader(in2);
		while((s1=b1.readLine())!=null){
			System.out.println(s1+"**");
		}
		b1.close();
	}
}
