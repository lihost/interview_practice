package sorting;

import java.util.Arrays;

/**
 * https://en.wikipedia.org/wiki/Selection_sort
 *
 */
public class SelectionSort {
	
	public static int[] selectionSort(int[] arr){
		int len = arr.length;
		
		for(int i=0; i<len; i++){
			int min = i;
			int j;
			
			for(j=i+1; j<len; j++){
				if(arr[j] < arr[min]){
					min = j;
				}
			}
			
			int temp = arr[min];
			arr[min] = arr[i];
			arr[i] = temp;
		}
		return arr;
		
	}
	public static void main(String[] args){
		int[] arr = {38,27,43,3,9,82,10};
		
		System.out.println("Sorted arr: "+Arrays.toString(selectionSort(arr)));
	}

}
