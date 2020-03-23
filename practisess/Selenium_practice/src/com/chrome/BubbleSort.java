package com.chrome;

public class BubbleSort {

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] a = {1,9,5,7,4}; int c=0;
		
		for (int i=0;i<=a.length-1;i++)
		{
			for(int j=i+1;j<a.length;j++)
			{
				if(a[i]<a[j])
				{
					a[i]=a[j];
					a[j]=a[c];
					a[c]=a[i];
					
				}
			System.out.println(a[c]);
			}
				
		}
		
		
		
		
	}

}
