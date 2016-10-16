package prepare.code.hiho.test;

//public class MR {
//
//}
import java.io.*;
import java.math.*;
import java.util.*;
import java.text.*;
public class MR {

	public static void main(String[] args) {
		Scanner cin = new Scanner(new BufferedInputStream(System.in));
		BigInteger N;
		N = cin.nextBigInteger();
		if(IsPrime(N))
		{
			System.out.println("Yes");
		}
		else
			System.out.println("No");
	}

	public static Boolean IsPrime(BigInteger num)
	{
		if(num.compareTo(BigInteger.valueOf(2)) == 0)
			return true;
		if((num.mod(BigInteger.valueOf(2)).compareTo(BigInteger.valueOf(0)) == 0) || (num.compareTo(BigInteger.valueOf(1)) == 0))
			return false;
		BigInteger num_1 = num.subtract(BigInteger.valueOf(1));
		int s = 0;
		while(num_1.mod(BigInteger.valueOf(2)).compareTo(BigInteger.valueOf(0)) == 0)
		{
			num_1 = num_1.divide(BigInteger.valueOf(2));
			++ s;
		}
		Random ran = new Random();
		for(int i = 0; i < 10; ++ i)
		{
			BigInteger a = BigInteger.valueOf(2); 
			BigInteger b = BigInteger.valueOf(Math.abs(ran.nextLong())).mod(num.subtract(BigInteger.valueOf(3)));
			a = a.add(b);
			BigInteger x = FastPowerMod(a,num_1,num);
			if(x.compareTo(BigInteger.valueOf(1)) != 0 && x.compareTo((num.subtract(BigInteger.valueOf(1)))) != 0)
			{
				Boolean flag = false;
				for(int j = 1; j < s; ++ j)
				{
					BigInteger t = x.multiply(x).mod(num);
					if(t.compareTo(num.subtract(BigInteger.valueOf(1))) == 0)
					{
						flag = true;
						break;
					}
					x = t;
				}
				if(flag)
					continue;
				return false;
			}
		}
		return true;
	}
	public static BigInteger FastPowerMod(BigInteger a,BigInteger m,BigInteger n)
	{
		BigInteger ans = BigInteger.valueOf(1);
		BigInteger tmp = a;
		while(m.compareTo(BigInteger.valueOf(0)) == 1)
		{
			if(m.mod(BigInteger.valueOf(2)).compareTo(BigInteger.valueOf(1)) == 0)
			{
				ans = ans.multiply(tmp).mod(n);
			}
			tmp = tmp.multiply(tmp).mod(n);
			m = m.divide(BigInteger.valueOf(2));
		}
		return ans.mod(n);
	}
}