package amy.Algorithm.BaekJoon.DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * 백준 #12865
 * 
 * @author "Amy"
 * 
 *         평범한 배낭문제
 * 
 *         이 문제는 아주 평범한 배낭에 관한 문제이다. 한 달 후면 국가의 부름을 받게 되는 준서는 여행을 가려고 한다. 세상과의
 *         단절을 슬퍼하며 최대한 즐기기 위한 여행이기 때문에, 가지고 다닐 배낭 또한 최대한 가치 있게 싸려고 한다.
 * 
 *         준서가 여행에 필요하다고 생각하는 N개의 물건이 있다. 각 물건은 무게 W와 가치 V를 가지는데, 해당 물건을 배낭에 넣어서
 *         가면 준서가 V만큼 즐길 수 있다. 아직 행군을 해본 적이 없는 준서는 최대 K만큼의 무게만을 넣을 수 있는 배낭만 들고
 *         다닐 수 있다. 준서가 최대한 즐거운 여행을 하기 위해 배낭에 넣을 수 있는 물건들의 가치의 최댓값을 알려주자.
 *
 */
public class CommonBackpack {

	/**
	 * 배낭에 넣을 수 있는 물건들의 가치의 최댓값
	 * @param k 가방에 넣을 수 있는 최대값
	 * @param items 물건목록
	 * @return 배낭에 넣을 수 있는 물건들의 최대가치
	 */
	int[][] values;
	public int getMaxValue(int n,int k, int[][] items) {
		
		for(int l = 1; l <= n; l++ ) {
			for(int m = 1; m<=k; m++) {
				int w = items[l-1][0];
				if(m-w<0) {
					values[l][m] =values[l-1][m];
				}else {
					values[l][m] =Math.max(values[l-1][m], values[l-1][m-w]+items[l-1][1]);
				}
			}
		}
		//가치 해테이블 확인용 소스
		for(int i = 0; i<items.length+1;i++) {
			System.out.println(Arrays.toString(values[i]));
		}
		return values[n][k];
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] vals = br.readLine().split(" ");
		int n = Integer.parseInt(vals[0]);
		int k = Integer.parseInt(vals[1]);

		int[][] items = new int[n][2];
		for (int i = 0; i < n; i++) {
			vals = br.readLine().split(" ");
			// 무게 W
			items[i][0] = Integer.parseInt(vals[0]);
			// 가치 V
			items[i][1] = Integer.parseInt(vals[1]);
		}

		CommonBackpack cb = new CommonBackpack();
		cb.values = new int[n+1][k+1];
		System.out.println(cb.getMaxValue(n,k, items));

	}

}
