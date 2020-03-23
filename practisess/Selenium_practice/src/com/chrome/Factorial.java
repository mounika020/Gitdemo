package com.chrome;

//class Factorial {
//
//		public static void main(String args[])
//		{
//			int n=5,fact=1;
//			
//		 for(int i=1; i<=n;i++)
//		 {
//			fact=fact*i;
//		 }
//			System.out.println(fact);
//		}  
//		}  


public class Factorial {  
    static int factorial(int n){      
          if (n == 1)      
            return 1;      
          else      
            return(n * factorial(n-1));      
    }      
  
public static void main(String[] args) {  
System.out.println("Factorial of 5 is: "+factorial(5));  
}  
}  
