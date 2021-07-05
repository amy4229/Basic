package amy.practice.Algorithm.BaekJoon.sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * 백준 1427
 * 배열을 정렬하는 것은 쉽다. 수가 주어지면, 그 수의 각 자리수를 내림차순으로 정렬해보자.
 * 
 * @author "Amy"
 *
 */
public class SortInside {
	
	public String cntSort (String num) {
		int[] cnt = new int[10];
		for(int i = 0; i <=num.length()-1; i++) {
			int idx = Integer.parseInt(num.substring(i, i+1));
			cnt[idx] ++;
		}
		StringBuilder sb = new StringBuilder();
		for(int j = 9; j >= 0; j--) {
			int k = cnt[j];
			while (k>0) {
				sb.append(j);
				k--;
			}
		}
		return sb.toString();
	}
	public String solution(String num) {
		char[] array=  num.toCharArray();
		Arrays.sort(array);
		StringBuilder sb = new StringBuilder().append(array).reverse();
		return sb.toString();
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String num = br.readLine(); 
		String sorted = new SortInside().solution(num);
		String cntsorted = new SortInside().cntSort(num);
		System.out.println(sorted);
		System.out.println(cntsorted);
		br.close();

	}

}
