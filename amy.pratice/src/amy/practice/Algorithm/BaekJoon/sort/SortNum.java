package amy.practice.Algorithm.BaekJoon.sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class SortNum {

	public int[] solution(int[] array) {
		return quickSort(array, 0, array.length-1);
	}
	public int[] quickSort(int[] array, int start, int end) {
		if (start < end) {
			System.out.println(start+" " +end);
			int pibot = partition(array, start, end);
			if(pibot > start)quickSort(array, start, pibot - 1);
			if(pibot < end-1) quickSort(array, pibot + 1, end);
		}
		return array;
	}

	public int partition(int[] array, int start, int end) {
		int pibot = start;
		int left = pibot;
		int right = end;
		while (left < right) {
			while (array[pibot] > array[left]) {
				left++;
			}
			while (array[pibot] < array[right]) {
				right--;
			}
			if(left<right) 	swap(left, right, array);
		}
		swap(left, pibot, array);
		return left;
	}

	private void swap(int idx1, int idx2, int[] array) {
		int tmp = array[idx1];
		array[idx1] = array[idx2];
		array[idx2] = tmp;
	}


	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine().trim());
		int i = 0;
		int[] nums = new int[n];
		while (i < n) {
			nums[i] = Integer.parseInt(br.readLine().trim());
			i++;
		}
		int[] sorted = new SortNum().solution(nums);
		Arrays.stream(sorted).forEach(System.out::println);
		br.close();

	}

}
