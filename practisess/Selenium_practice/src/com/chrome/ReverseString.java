package com.chrome;

public class ReverseString {

	
	
	public static void main(String args[])
	{
		String n="It IS";
		String x=" ";
		
		for(int i=n.length()-1; i>=0;i--)
		{
			x= x + n.charAt(i);
			
		}
		System.out.println(x);
	}
}
