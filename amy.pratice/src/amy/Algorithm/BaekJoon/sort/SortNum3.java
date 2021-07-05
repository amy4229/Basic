package amy.Algorithm.BaekJoon.sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 백준 10989
 * 
 * 문제 N개의 수가 주어졌을 때, 이를 오름차순으로 정렬하는 프로그램을 작성하시오.
 * 
 * 입력 첫째 줄에 수의 개수 N(1 ≤ N ≤ 10,000,000)이 주어진다. 둘째 줄부터 N개의 줄에는 숫자가 주어진다. 이 수는
 * 10,000보다 작거나 같은 자연수이다.
 * 
 * 
 * 계수정렬 : 숫자의 갯수는 많고, 범위가 한정적일 때
 * 출력 첫째 줄부터 N개의 줄에 오름차순으로 정렬한 결과를 한 줄에 하나씩 출력한다.
 * 
 * @author "Amy"
 *
 */
public class SortNum3 {
	
	public void solution(int[] nums) {
		int[] cnt = new int[10001];
		int max = 0;
		int min = Integer.MAX_VALUE;
		for(int num :nums) {
			max = max>num ? max : num;
			min = min<num ? min : num;
			cnt[num]++;
		}
		
		int idx =min;
		while(idx <= max) {
			if(cnt[idx] > 0) {
				for(int j =0 ; j< cnt[idx]; j++) {
					System.out.println(idx);
				}
			}
			idx++;
		}
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
		new SortNum3().solution(nums);
		br.close();

	}

}
