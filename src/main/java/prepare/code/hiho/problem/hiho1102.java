/**
 * @author xubo
 * status：AC
 */
package prepare.code.hiho.problem;
import java.util.Scanner;
public class hiho1102 {
public static void main(String[] args) {
	Scanner in=new Scanner(System.in);
	int paid=in.nextInt();
	double salary=0;
	if(paid<= 45){
		salary=3500+paid/0.03;
	}else if(paid>5 &&paid <=345){
		salary=(paid-45)/0.1+5000;
	}else if(paid>345 &&paid <=1200){
		salary=(paid-345)/0.2+8000;
	}
	else if(paid>1245 &&paid <=7745){
		salary=(paid-1245)/0.25+12500;
	}
	else if(paid>7745 &&paid <=13745){
		salary=(paid-7745)/0.3+38500;
	}else if(paid>13745 &&paid <=22495){
		salary=(paid-13745)/0.35+58500;
	}else if(paid>22495){
		salary=(paid-22495)/0.45+83500;
	}
	int out=(int) salary;
	System.out.println(out);
	in.close();
}
}
