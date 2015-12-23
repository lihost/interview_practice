/**
 * Fibonacci Series - recursive
 * 
 * by - Normal recursive and Dynamic programming approach
 * 
 */

package com.practice.dynamic;

public class NthFibbonacci {
	/**
	 * Normal Recursive way to get solution - with O(2^n)
	 * @param num
	 * @return
	 */
	public static int getNthFibbo(int num) {
		
		if(num == 0) return 0;
		if(num==1) return 1;
		
		
		num = getNthFibbo(num-1)+getNthFibbo(num-2);
		return num;
		
	}
	
	/**
	 * Dynamic programming by TOP DOWN approach - seems inefficient than Normal recursive style since this involves recursion and
	 * array traversal.
	 * @param num
	 * @return
	 */
	public static int fiboByDynamicProTopDown(int num){
		int[] fib = new int[num+1];
		
		if(num == 1) return 1;
		if(num == 2) return 1;
		if(fib[num] != 0) return fib[num];
		return fib[num] = fiboByDynamicProTopDown(num-1) + fiboByDynamicProTopDown(num-2);
	}
	
	/**
	 * Dynamic programming by Bottom Up approach - Most Efficient way
	 * Time  - O(n)
	 * Space - O(n)
	 * @param num
	 * @return
	 */
	public static int fiboByDynamicProBottomUp(int num){
		int[] fib = new int[num+1];
		
		if(num == 0 || num == 1) return 1;
		fib[0] = 1;
		fib[1] = 1;
		for(int i=2; i<num; i++){
			fib[i] = fib[i-1] + fib[i-2];
		}
		return fib[num-1];
	}
	
	
	public static void main(String[] args){
		int n=40;
		
		long[] start = new long[3];
		long[] end = new long[3];
		
		System.out.println("Fibbo for : "+ n);

		
		start[0] = System.currentTimeMillis();		
		System.out.println("Result : "+getNthFibbo(n));		
		end[0] = System.currentTimeMillis();
				
		System.out.println("Time taken to compute fibo by recursion: "+ (end[0] - start[0])+"ms.");
		
		
		
		start[1] = System.currentTimeMillis();
		System.out.println("Result : "+fiboByDynamicProTopDown(n));
		end[1] = System.currentTimeMillis();
		
		System.out.println("Time taken to compute fibo by Dynamic Programming Top Down: "+(end[1]-start[1])+"ms.");
		
		
		
		start[2] = System.currentTimeMillis();
		System.out.println("Result : "+fiboByDynamicProBottomUp(n));
		end[2] = System.currentTimeMillis();
		
		System.out.println("Time taken to compute fibo by Dynamic Programming Bottom Up: "+(end[2]-start[2])+"ms.");
		
		
		
	}

}
