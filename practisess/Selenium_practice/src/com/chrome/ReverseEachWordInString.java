package com.chrome;

public class ReverseEachWordInString {

	
	public static void main(String args[])
	{
		String s="It is happening";
		String[] a=s.split(" ");
		 System.out.print(a.length);
		String r="";
		for (int i = 0; i < a.length; i++) {
            for (int j = a[i].length() - 1; j >= 0; j--) {
                r =r+ a[i].charAt(j);
            }
            System.out.print(r + " ");
           // r = "";
	}
	}
	
	
}
