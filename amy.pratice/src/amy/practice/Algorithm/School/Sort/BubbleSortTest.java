package amy.practice.Algorithm.School.Sort;

import java.util.Arrays;

public class BubbleSortTest {
	
	/**
	 * 한쪽 말단 값부터 비교를 통해 자리를 바꾸며 모든 인접한 값과의 비교해 나가는 정렬방법
	 * 안정적 정렬 알고리즘, 제자리 정렬알고리즘
	 * @param array 정렬대상 배열
	 * @return 정렬된 배열
	 */
	public int[] bubbleSort(int[] array) {
		System.out.println("입력데이터 : " + Arrays.toString(array));
		long start = System.nanoTime();
		int cnt = 0;
		int [] result =Arrays.copyOf(array,array.length);
		for(int i = 0; i < array.length ; i++) {
			for(int j =array.length-1; j > i; j--) {
				cnt++;
				if(result[i] > result[j]) {
					swap(result, i, j);
				}
			}
		}
		long end = System.nanoTime();
		System.out.println("버블정렬 : "+ (end-start)+"나노초가 걸렸습니다. 비교횟수 : " + cnt);
		return result;
	}
	/**
	 * 개선된 버블정렬
	 * 한 패스내에서 정렬이 이뤄지지않은 경우 다음 패스 역시 정렬된 상태이기 때문에 
	 * 정렬 하지 않도록 함 
	 * @param array 정렬대상 배열
	 * @return result 정렬된 배열 
	 */
	public int[] upgradedbubbleSort(int[] array) {
		System.out.println("입력데이터 : " + Arrays.toString(array));
		long start = System.nanoTime();
		int cnt = 0;
		int [] result =Arrays.copyOf(array,array.length);
		boolean hasExchanged = true;
		for(int i = 0; i < array.length ; i++) {
			hasExchanged = false; 
			for(int j =array.length-1; j > i; j--) {
				cnt++;
				if(result[i] > result[j]) {
					hasExchanged = true;
					swap(result, i, j);
				}
			}
			if(!hasExchanged) {
				break;
			}
		}
		long end = System.nanoTime();
		System.out.println("개선된 버블정렬 "+ (end-start)+"나노초가 걸렸습니다. 비교횟수 :"+cnt);
		return result;
	}

   private void swap (int[] array,int  i, int j) {
	   int tmp = array[j];
	   array[j] = array[i];
	   array [i] = tmp;
   }


	public static void main(String[] args) {
		int[] array = {50,10,20,40,30}; 
		BubbleSortTest s = new BubbleSortTest();
		System.out.println(Arrays.toString(s.bubbleSort(array)));
		System.out.println("-------------------------------------------");
		System.out.println(Arrays.toString(s.upgradedbubbleSort(array)));
		System.out.println("-------------------------------------------");
		int[] array2 = {10,20,30,40,50}; 
		System.out.println(Arrays.toString(s.bubbleSort(array2)));
		System.out.println("-------------------------------------------");
		System.out.println(Arrays.toString(s.upgradedbubbleSort(array2)));
		System.out.println("-------------------------------------------");
		int[] array3 = {50,40,30,20,10}; 
		System.out.println(Arrays.toString(s.bubbleSort(array3)));
		System.out.println("-------------------------------------------");
		System.out.println(Arrays.toString(s.upgradedbubbleSort(array3)));
		System.out.println("-------------------------------------------");
		
	}

}
