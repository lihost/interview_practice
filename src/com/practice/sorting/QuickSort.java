package com.practice.sorting;

public class QuickSort {
	
	/**
	 * Divide - Dividing array recursively with pivot item
	 * @param arr
	 * @param low
	 * @param high
	 */
	public void qSort(int[] arr, int low, int high) {
		int pivot;
		
		if(high > low) {
			pivot = partition(arr, low, high);
			
			qSort(arr, low, pivot-1);
			qSort(arr, pivot+1, high);
		}
	}
	
	/**
	 * Conquer - partitioned arrays gets sorted
	 * @param arr
	 * @param low
	 * @param high
	 * @return
	 */
	public int partition(int[] arr, int low, int high) {
		int left = low;
		int right = high;
		int pivot_item = arr[low];
		
		while(left < right) {
			
			// checking arr.length to escape arrayIndexOutOfBound exception
			while((left < arr.length) && (arr[left] <= pivot_item))
				left++;
			
			while((right >= 0) && (arr[right] > pivot_item))
				right--;
			
			if(left < right){
				swap(arr, left, right);
			}
		}
		
		arr[low] = arr[right];
		arr[right] = pivot_item;
		return right;		
	}
	
	/**
	 * swapping items according to pivot element.
	 * @param arr
	 * @param left
	 * @param right
	 */
	public void swap(int[] arr, int left, int right){
		int temp = arr[left];
		arr[left] = arr[right];
		arr[right] = temp;
	}
	
	/**
	 * utility funtion
	 * @param arr
	 */
	public static void printArray(int arr[])
    {
        int n = arr.length;
        for (int i=0; i<n; ++i)
            System.out.print(arr[i] + " ");
        System.out.println();
    }
	
	public static void main(String[] args) {
		int[] arr = {38,27,43,3,9,82,10};
		
		System.out.println("Input Array: ");
		printArray(arr);
		
		QuickSort qs = new QuickSort();
		qs.qSort(arr, 0, arr.length-1);
		
		System.out.println("\nOutput Sorted Array: ");
		printArray(arr);
		
		
		
		
	}
}
