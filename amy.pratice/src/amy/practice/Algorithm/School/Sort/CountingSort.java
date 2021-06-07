package amy.practice.Algorithm.School.Sort;

import java.util.stream.IntStream;

/**
 * 계수정렬 
 * 주어진 정수범위 내의 정수(중복포험)가 배열에 분포되어 있을 때 
 * 각 정수의 분포를 세서 정렬하는 방법
 * @author "Amy"
 *
 */
public class CountingSort extends AbstractSort {

	@Override
	protected int[] sortProcess(int[] array) {
		int max =  IntStream.of(array).max().getAsInt();
		int[] counts = new int[max+1];
		int[] sorted = new int[array.length];
		IntStream.of(array).forEach(i->counts[i]++);
		IntStream.range(1,counts.length).forEach(i-> counts[i] = counts[i-1]+counts[i]);
		for(int i = array.length-1; i >= 0; i-- ) {
			int no = array[i];
			sorted[counts[no]-1]=no;
			counts[no]--;
		}
		return sorted;
	}

	public static void main(String[] args) {
		CountingSort s = new CountingSort();
		int[] array = {1,1,2,2,2 };
		s.sortName = "계수정렬";
		s.sort(array);
		int[] array2 = { 7,7,7,5,5,5,8,8,8,2,2,2};
		s.sort(array2);
	}
}
