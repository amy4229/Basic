package amy.practice.Algorithm.School.Sort;

import java.util.Arrays;

/**
 * 정렮클래스의 추상클래스 
 * 
 * 
 * @author "Amy"
 *
 */
public abstract class AbstractSort {
	protected int cnt =0;
	protected String sortName = null;
	
	
	public final int[] sort (int[] array) {
		cnt =0;
		long start = System.nanoTime();
		int[] output = Arrays.copyOf(array, array.length);
		output =sortProcess(output);
		long end = System.nanoTime();
		System.out.printf("%s  정렬처리시간 : %d나노초 \t  비교횟수 : %d 회, 입력데이터 : %s, 결과: %s \r\n",sortName,  (end-start),cnt, Arrays.toString(array), Arrays.toString(output));
		return array;
	}
	
	protected abstract int [] sortProcess (int[] array);
	
	protected void swap (int[] array,int  i, int j) {
		   int tmp = array[j];
		   array[j] = array[i];
		   array [i] = tmp;
	   }
	
	
}
