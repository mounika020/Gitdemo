package com.chrome;

import java.util.ArrayList;

public class PrintUniqueNumbers {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int a[]={5,3,5,4,9,0,9,3};
		ArrayList<Integer> al= new ArrayList<Integer>();
			for(int i=0;i<a.length;i++)
		{
			int count=0;
			if(!al.contains(a[i]))
			{
				al.add(a[i]);
			count++;
			for(int j=i+1;j<a.length;j++)
			{
				if(a[i]==a[j])
						{
					count++;
					
						}}
			System.out.println(a[i]);
			System.out.println(count);
			if(count==1)
			System.out.println(a[i]+"is unique");
			}
			
		}}}

