package com.practice.bits;

/**
 * Bitwise Swap using XOR.
 * 
 * @author Sohil
 *
 */
public class BitwiseSwap {
	
	public static void main(String[] args) {
	       int a = 5; //0101 
	       int b = 10; //1010
	       
	       a = a ^ b; //1111
	       b = a ^ b; //0101
	       a = a ^ b; //1010
	    
	    System.out.println(a);
	    System.out.println(b);
	    
	  }
}
