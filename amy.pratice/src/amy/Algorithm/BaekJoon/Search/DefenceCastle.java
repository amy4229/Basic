package amy.Algorithm.BaekJoon.Search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.stream.Stream;

import amy.Algorithm.BaekJoon.Main;

/**
 * 백준 #1236
 * 
 * 문제 영식이는 직사각형 모양의 성을 가지고 있다. 성의 1층은 몇 명의 경비원에 의해서 보호되고 있다. 영식이는 모든 행과 모든 열에 한
 * 명 이상의 경비원이 있으면 좋겠다고 생각했다.
 * 
 * 성의 크기와 경비원이 어디있는지 주어졌을 때, 몇 명의 경비원을 최소로 추가해야 영식이를 만족시키는지 구하는 프로그램을 작성하시오.
 * 
 * 입력 첫째 줄에 성의 세로 크기 N과 가로 크기 M이 주어진다. N과 M은 50보다 작거나 같은 자연수이다. 둘째 줄부터 N개의 줄에는
 * 성의 상태가 주어진다. 성의 상태는 .은 빈칸, X는 경비원이 있는 칸이다.
 * 
 * 출력 첫째 줄에 추가해야 하는 경비원의 최솟값을 출력한다.
 * 
 * @author "Amy"
 *
 */
public class DefenceCastle {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] line1 = br.readLine().split(" ");
		int n = Integer.parseInt(line1[0]);
		int m = Integer.parseInt(line1[1]);

		int[] patrolRow = new int[n];
		int[] patrolCol = new int[m];

		for (int i = 0; i < n; i++) {
			String line = br.readLine().trim();
			int idx = line.indexOf('X');
			while (idx >= 0) {
				patrolRow[i] = 1;
				patrolCol[idx] = 1;
				idx = line.indexOf('X');
			}
		}
		int rows = (int)Arrays.stream(patrolRow).filter( i-> i  == 0 ).count();
		int cols = (int)Arrays.stream(patrolCol).filter( i-> i ==0 ).count();
		System.out.println(Math.max(cols, rows));
		br.close();
	}

}
