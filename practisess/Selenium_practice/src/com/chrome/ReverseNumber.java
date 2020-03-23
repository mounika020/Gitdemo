package com.chrome;

public class ReverseNumber {

	int n=12345;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int n=12345; String x="";
		String s = Integer.toString(n);
		int len = s.length();
		for (int i=len-1; i>=0;i--)
		{
		x = x + s.charAt(i);
		Integer in= Integer.parseInt(x);
		
		
	}
		System.out.println(x);
		}


}
