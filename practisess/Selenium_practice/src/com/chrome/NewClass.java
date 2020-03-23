package com.chrome;

public class NewClass {
	

		public static void main(String[] args) {
			// TODO Auto-generated method stub
			
			int abc[][]={{1,0,2},{3,2,10}};
			//int[][] b=new int[2][2];
			
			 int mincoloumn = 0;
			
			int min=abc[0][0];
	for(int i=0;i<2;i++)
	{
		for(int j=0;j<3;j++)
		{
			if(abc[i][j]<min)
			{
				min=abc[i][j];
		     mincoloumn = j;   
		}
		}
		}


	//System.out.println(i);
	System.out.println(mincoloumn);

	int max=abc[0][mincoloumn];
	int k=0;
	while(k<2)
	{
		
	if (abc[k][mincoloumn] > max)
	{
		max=abc[k][mincoloumn];
	}
	k++;

	}
	System.out.println(max);
	//System.out.println(min);
	////System.out.println(i);
	////System.out.println(j);

		}
}
