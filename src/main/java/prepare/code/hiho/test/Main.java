/**
 * @author xubo
 * Miller-Rabin质数测试
 */
package prepare.code.hiho.test;

import java.math.BigInteger;
import java.util.Random;
import java.util.Scanner;
import java.io.*;
import java.math.*;
import java.util.*;
import java.text.*;

public class Main {
	// public static String sushu(Long a){
	// for(Long i=2;i<=Math.sqrt(a);i++){
	// if((a%i)==0){
	// return "NO";
	// }
	// }
	// return "YES";
	// }
	public static void main(String[] args) {
		Scanner input = new Scanner(new BufferedInputStream(System.in));
		// System.out.println(input);
		BigInteger num = new BigInteger("0");
		int start = 0;
		int i = 0;
		String[] string1 = new String[50];
		while (input.hasNext()) {
			if (start == 0) {
				num = input.nextBigInteger();
				start = num.intValue();
			} else {
				num = input.nextBigInteger();
				if (num.intValue() < 2) {
					string1[i - 1] = "NO";
				} else {
					if (num.intValue() < 100) {
						if (sushu(num.intValue())) {
							string1[i - 1] = "YES";
						} else {
							string1[i - 1] = "NO";
						}
					} else {
						if (IsPrime(num)) {
							string1[i - 1] = "YES";
						} else {
							string1[i - 1] = "NO";
						}
					}
				}
			}
			i++;
			if (i == start + 1) {
				break;
			}

		}
		for (int i1 = 0; i1 < i - 1; i1++) {
			System.out.println(string1[i1]);
		}
		input.close();
	}

	public static boolean sushu(int a) {
		for (int i = 2; i <= Math.sqrt(a); i++) {
			if ((a % i) == 0) {
				return false;
			}
		}
		return true;
	}

	public static Boolean IsPrime(BigInteger num) {
		if (num.compareTo(BigInteger.valueOf(2)) == 0)
			return true;
		if ((num.mod(BigInteger.valueOf(2)).compareTo(BigInteger.valueOf(0)) == 0)
				|| (num.compareTo(BigInteger.valueOf(1)) == 0))
			return false;
		BigInteger num_1 = num.subtract(BigInteger.valueOf(1));
		int s = 0;
		while (num_1.mod(BigInteger.valueOf(2))
				.compareTo(BigInteger.valueOf(0)) == 0) {
			num_1 = num_1.divide(BigInteger.valueOf(2));
			++s;
		}
		Random ran = new Random();
		for (int i = 0; i < 10; ++i) {
			BigInteger a = BigInteger.valueOf(2);
			BigInteger b = BigInteger.valueOf(Math.abs(ran.nextLong())).mod(
					num.subtract(BigInteger.valueOf(3)));
			a = a.add(b);
			BigInteger x = FastPowerMod(a, num_1, num);
			if (x.compareTo(BigInteger.valueOf(1)) != 0
					&& x.compareTo((num.subtract(BigInteger.valueOf(1)))) != 0) {
				Boolean flag = false;
				for (int j = 1; j < s; ++j) {
					BigInteger t = x.multiply(x).mod(num);
					if (t.compareTo(num.subtract(BigInteger.valueOf(1))) == 0) {
						flag = true;
						break;
					}
					x = t;
				}
				if (flag)
					continue;
				return false;
			}
		}
		return true;
	}

	public static BigInteger FastPowerMod(BigInteger a, BigInteger m,
			BigInteger n) {
		BigInteger ans = BigInteger.valueOf(1);
		BigInteger tmp = a;
		while (m.compareTo(BigInteger.valueOf(0)) == 1) {
			if (m.mod(BigInteger.valueOf(2)).compareTo(BigInteger.valueOf(1)) == 0) {
				ans = ans.multiply(tmp).mod(n);
			}
			tmp = tmp.multiply(tmp).mod(n);
			m = m.divide(BigInteger.valueOf(2));
		}
		return ans.mod(n);
	}
}
