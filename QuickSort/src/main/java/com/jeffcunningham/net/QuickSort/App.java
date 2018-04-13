package com.jeffcunningham.net.QuickSort;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
    }
    
    public static void quicksort(int[] array, int left, int right) {
    		if (left>right) {
    			return;
    		}
    		int pivot = array[left + right]/2;
    		int index = partition(array, left, right, pivot);
    		quicksort(array, left, index-1);
    		quicksort(array, index, right);
    }
    
    public static int partition(int[] array, int left, int right, int pivot) {
    		while(left<=right) {
    			while(array[left]<pivot) {
    				left++;
    			}
    			
    			while(array[right]>pivot){
    				right--;
    			}
    			if(left<=right) {
    				swap(array,left,right);
    				left++;
    				right--;
    			}
    		}
    		return left;
    }
    
    private static void swap(int[] array, int indexA, int indexB) {
		int temp;
		temp = array[indexA];
		array[indexA] = array[indexB];
		array[indexB] = temp;
}
}
