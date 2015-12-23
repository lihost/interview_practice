package com.practice.dynamic;

public class FiboNoRecursion {

	/**
	 *  Generate Fibonacci series without recursion
	 *  O(T) = O(n)
	 * @param args
	 */
	public static void main(String[] args){
		int first =0;
		int second = 1;
		int fib=0;
		
		for(int i=0; i<20; i++){
			fib = first + second;
			System.out.println("Series count "+i+" : "+fib);
			first=second;
			second=fib;
			
		}
	}
	
	
	
	// Single line solution
	/**
	public static void main(String[] args){
		int f=0;
		int s=1;
		int length = 20;
		
		while(--length >= 0){
			System.out.println("Fibbo for "+length+" is : "+ (f=(s= f+s) -f)*0+s);
		}
		
	}
	**/
}
