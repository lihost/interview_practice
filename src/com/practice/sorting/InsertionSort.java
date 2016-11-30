package com.practice.sorting;

import java.util.Arrays;
/**
 * https://en.wikipedia.org/wiki/Insertion_sort
 *
 */
public class InsertionSort {
	
	public static int[] insertionSort(int[] arr){
		int len = arr.length;
		
		for(int i = 1; i<len; i++){
			int temp = arr[i];
			int j;
			
			/**
			 * Iterating over sublist arr[0..i-1] identifying any
			 * element > key, if 'yes' then keep swapping so that
			 * minimum number reaches to its position
			 */
			for(j=i-1; j>=0 && temp < arr[j]; j--){
				arr[j+1] = arr[j];
			}
			arr[j+1] = temp;			
		}
		return arr;
	}
	
	public static void main(String[] args){
		int[] arr = {38,27,43,3,9,82,10};
		
		System.out.println("Sorted arr: "+Arrays.toString(insertionSort(arr)));
	}
}
