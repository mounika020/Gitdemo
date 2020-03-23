package com.chrome;

public class Armstrong2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int n=371;;double d=0.0;
		String s =Integer.toString(n);
		int x =s.length();
		for(int i=x-1;i>=0;i--)
		{
			char x1=s.charAt(i);
			Integer in = Integer.parseInt(String.valueOf(x1));
			System.out.println(in);
			 d =d + Math.pow(in, x);
			 //System.out.println(d);
			
		}
		System.out.println(d);
		if (n==d)

	{System.out.println("armstrong");
			}
		else
		{
			System.out.println(" not armstrong");
		}
	}

}
