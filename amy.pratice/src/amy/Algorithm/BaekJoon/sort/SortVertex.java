package amy.Algorithm.BaekJoon.sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

/**
 * 백준 11650
 * 
 * 2차원 평면 위의 점 N개가 주어진다. 좌표를 x좌표가 증가하는 순으로, x좌표가 같으면 y좌표가 증가하는 순서로 정렬한 다음 출력하는
 * 프로그램을 작성하시오.
 * 
 * 입력 첫째 줄에 점의 개수 N (1 ≤ N ≤ 100,000)이 주어진다. 둘째 줄부터 N개의 줄에는 i번점의 위치 xi와 yi가
 * 주어진다. (-100,000 ≤ xi, yi ≤ 100,000) 좌표는 항상 정수이고, 위치가 같은 두 점은 없다.
 * 
 * 출력 첫째 줄부터 N개의 줄에 점을 정렬한 결과를 출력한다.
 * 
 * @author "Amy"
 *
 */
public class SortVertex {
	
	public int[][] solution(int[][] ori){
		Arrays.sort(ori, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[0]- o2[0]==0? o1[1]- o2[1]:o1[0]- o2[0];
			}
		});
		return ori;
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int num = Integer.parseInt(br.readLine().trim());
		int[][] vertexes = new int[num][2];
		int i = 0;
		while (i < num) {
			String[] loc = br.readLine().split(" ");
			vertexes[i] = new int[] {Integer.parseInt(loc[0]),Integer.parseInt(loc[1])};
			i++;
		}
		int[][] sorted = new SortVertex().solution(vertexes);
		for(int j =0 ; j < sorted.length; j++) {
		 System.out.println(sorted[j][0]+" "+sorted[j][1]);
		}
		br.close();

	}

}
