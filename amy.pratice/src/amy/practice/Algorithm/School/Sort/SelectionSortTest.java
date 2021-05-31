package amy.practice.Algorithm.School.Sort;

import java.util.Arrays;

public class SelectionSortTest {
	
	public int[] selectionSort(int[] array) {
		long start = System.nanoTime();
		int cnt = 0;
		int i = 0;
		while (i < array.length-1) {
			int minIdx = i;
			int min = array[i];
			for(int j = i+1; j < array.length; j++) {
				cnt++;
				if( min > array[j] ) {
					minIdx = j; 
					min = array[j];
				}
			}
			if(i != minIdx) {
				swap( array, i, minIdx);
			}
			i++;
		}
		long end = System.nanoTime();
		System.out.println("선택정렬 "+ (end-start)+"나노초가 걸렸습니다. 비교횟수 :"+cnt);
		return array;
	}
	
	 private void swap (int[] array,int  i, int j) {
		   int tmp = array[j];
		   array[j] = array[i];
		   array [i] = tmp;
	   }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] array = {50,10,20,40,30}; 
		SelectionSortTest s = new SelectionSortTest();
		System.out.println(Arrays.toString(s.selectionSort(array)));
		System.out.println("-------------------------------------------");
		int[] array2 = {10,20,30,40,50}; 
		System.out.println(Arrays.toString(s.selectionSort(array2)));
		System.out.println("-------------------------------------------");
		int[] array3 = {50,40,30,20,10}; 
		System.out.println(Arrays.toString(s.selectionSort(array3)));
		System.out.println("-------------------------------------------");

	}

}
