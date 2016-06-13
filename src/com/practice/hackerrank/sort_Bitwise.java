package com.practice.hackerrank;

import java.util.List;

/**
 * Hamming weight related problem but exact implementation of Hamming weight is not required. A program to sort an array of integer
 * in an increasing order of count of 1s in each number's binary representation. If 2 numbers have same count of 1s then they need 
 * to be compared with their integer representation.
 * 
 * @author sohil
 *
 */
public class sort_Bitwise {
		
	   static void swap_array(int[] a) {
	        
	        for(int i=0; i<a.length; i++) {
	            int min = i;
	            
	            
	            for(int j=i+1; j<a.length; j++){
	                
	                if(Integer.bitCount(a[j]) < Integer.bitCount(a[min])) {
	                    min = j;
	                } else if(Integer.bitCount(a[j]) == Integer.bitCount(a[min])) {
	                    if(a[j] < a[min]) {
	                       min = j;
	                    } 
	                }
	            }
	            int temp = a[min];
	            a[min] = a[i];
	            a[i] = temp;
	        }

	        for(int i=0; i<a.length; i++){
	            System.out.println(a[i]);
	        }

	    }
	   
	   /**
	    * NOTE - works with JDK8 only
	    * 
	    * with lambda expressions
	    * @param a
	    */
	   static void swap_array2(List<Long>a){
		   //a.sort((x,y)->bitCount(x)-bitCount(y));
		   }
	   
	   
	   public static void main(String[] args){
			int[] arr = {0,14,5,31,14,15,7,2};
			
			swap_array(arr);
		}

}
