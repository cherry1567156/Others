package Test;

import java.util.ArrayList;

import java.util.Scanner;

/**
 * 
 * <p>Copyright: Copyright (c) 2017</p>
 * <p>succez</p>
 * @author cherry
 * @createdate 2017年11月3日
 */

public class Pritice2 {
	public static String IntToHex(int a)
	{
		String t=null;
		if(a<0)
		{
			a=-a;
			t="-";
		}
		ArrayList<Integer> list=new ArrayList<Integer>();
		StringBuffer s=new StringBuffer();
		while(a!=0)
		{
			list.add(a%16);
			a=a/16;
		}
		for(int i=list.size()-1;i>=0;i--)
		{
			if(list.get(i)<10)
				s.append(list.get(i).toString());
			else 
			{
				switch (list.get(i)) {
					case 10:
						s.append("A");
						break;
					case 11:
						s.append("B");
						break;
					case 12:
						s.append("C");
						break;
					case 13:
						s.append("D");
						break;
					case 14:
						s.append("E");
						break;
					case 15:
						s.append("F");
						break;
					default:
						break;
				}
			}
		}
		return t+s.toString();
	}
	
	public static void main(String args[])
	{
		Scanner sc=new Scanner(System.in);
		int a=sc.nextInt();
		System.out.println(IntToHex(a));
	}
}
