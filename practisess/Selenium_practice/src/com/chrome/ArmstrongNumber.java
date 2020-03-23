package com.chrome;

import java.util.Scanner;

public class ArmstrongNumber {

	//static int num=9474;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
Scanner sc=new Scanner(System.in);
System.out.println("enter num");
int num=sc.nextInt();
		
		String numString=String.valueOf(num);
		int len=numString.length();
		System.out.println(len);
		
		//String numString = String.valueOf(num);
if(len==3)
{
		int num1 = Integer.parseInt(numString.substring(0, 1));
		int num2 = Integer.parseInt(numString.substring(1, 2));
		int num3 = Integer.parseInt(numString.substring(2, 3));
		int num4 = Integer.parseInt(numString.substring(3, 4));
		int a= num1*num1*num1*num1;
		int b=num2*num2*num2*num2;
		int c=num3*num3*num3*num3;
		int d=num4*num4*num4*num4;
		int tot= a+b+c+d;
		if(num==tot)
		{
			System.out.println("num is armstrong num :" + num);
		}
		
		else
		{
			System.out.println("num is not an armstrong num :" + num);
		}
				
		
	}

}
}
