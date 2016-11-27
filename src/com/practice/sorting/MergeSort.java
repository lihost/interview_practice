package com.practice.sorting;


public class MergeSort
{
    /**
     * Dividing array recursively and calling merge operation
     * @param arr
     * @param left
     * @param right
     */
	public void mergeSort(int[] arr, int left, int right) {
    	if(left < right) {
    		int mid = (left+right)/2;
    		
    		mergeSort(arr, left, mid);
    		mergeSort(arr, mid+1, right);
    		
    		merge(arr, left, mid+1, right);
    	}
    }
    
	/**
	 * Merge operation
	 * @param arr
	 * @param left
	 * @param mid
	 * @param right
	 */
    public void merge(int[] arr, int left, int mid, int right) {
    	int[] temp = new int[arr.length];
    	int temp_pos = left;
    	int left_end = mid-1;
    	int size = right - left +1;
    	
    	while((left <= left_end) && (mid <= right)) {
    		if(arr[left] <= arr[mid]) {
    			temp[temp_pos++] = arr[left++];
    		} else {
    			temp[temp_pos++] = arr[mid++];
    		}
    	}
    	
    	while(left <= left_end) {
    		temp[temp_pos++] = arr[left++];
    	}
    	
    	while(mid <= right) {
    		temp[temp_pos++] = arr[mid++];
    	}
    	
    	
    	for(int i=0; i<size; i++) {
    		arr[right] = temp[right];
    		right--;
    	}
    }
 
    /**
     * Printing array
     * @param arr
     */
    public static void printArray(int arr[])
    {
        int n = arr.length;
        for (int i=0; i<n; ++i)
            System.out.print(arr[i] + " ");
        System.out.println();
    }
 

    public static void main(String args[])
    {
        int arr[] = {38,27,43,3,9,82,10};
 
        System.out.println("Input Array: ");
        printArray(arr);
 
        MergeSort ob = new MergeSort();
        ob.mergeSort(arr, 0, arr.length-1);
        
        System.out.println("\nOutput Sorted Array:");
        printArray(arr);
    }
}