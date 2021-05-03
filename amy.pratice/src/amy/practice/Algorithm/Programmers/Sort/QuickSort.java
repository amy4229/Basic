package amy.practice.Algorithm.Programmers.Sort;

import java.util.Arrays;

public class QuickSort {
	

	public int[] quickSort(int[] array, int start, int end) {
		if(start < end) {
			int pivot = partition(array,start,end);
				quickSort(array, start, pivot-1);
				quickSort(array,pivot+1,end);
		}
		return array;
	}
	
	private int partition(int[] array, int start, int endIndex) {
		int  pivotIndex= (start+endIndex)/2;
		int pivot = array[pivotIndex];
		while(start<endIndex) {
			while(array[start] < pivot) start++;
			while(array[endIndex] > pivot ) endIndex--;
			if(start< endIndex) {
				swap(start, endIndex, array);
			}
		}
		return start;
	}
	
	private void swap(int index1, int index2, int[] array) {
		int temp = array[index1];
		array[index1] = array[index2];
		array[index2] = temp;
	}
	
	public static void main(String[] args) {
		int[] input = new int[] {100,50,80,20,90,10};
		int[] actual = new QuickSort().quickSort(input,0,input.length-1);
		System.out.println(Arrays.toString(actual));
	}

}
