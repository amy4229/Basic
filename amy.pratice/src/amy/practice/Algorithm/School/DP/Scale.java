package amy.practice.Algorithm.School.DP;

import java.util.Arrays;

/**
 * 동적프로그래밍 저울문제
 * 
 * @author amy
 *
 */
public class Scale {

	/**
	 * 주어진 추들로 특정 물체의 무게를 측정가능한지 판단
	 * 0 : 불가 1: 가능
	 * @param w 추들의 무게베열
	 * @param m 츠겆할 무게
	 * @return 측정가능여부
	 */
	public int canMeasure(int n, int[] w, int m) {
		int result = 0;
		int[][] s = new int[n + 1][m + 1];
		for (int i = 0; i <= n; i++) {
			s[i][0] = 1;
		}
		for (int j = 1; j <= m; j++) {
			s[0][j] = 0;
		}
		for (int l = 1; l <= n; l++) {
			for (int k = 1; k <= m; k++) {
				if (k - w[l - 1] < 0) {
					s[l][k] = s[l - 1][k];
					continue;
				}
				s[l][k] = Math.max(s[l - 1][k], s[l - 1][k - w[l - 1]]);
			}
		}
		result = s[n][m];
		// s배열 확인용 출력 코드
		for (int i = 0; i < s.length; i++) {
			System.out.println(Arrays.toString(s[i]));
		}
		return result;
	}

	/**
	 * 주어진 추들로 특정 물체의 무게를 측정가능한지 판단
	 * false : 불가 true: 가능
	 * @param w 추들의 무게베열
	 * @param m 츠겆할 무게
	 * @return 측정가능여부
	 */
	public boolean canMeasure2(int n, int[] w, int m) {
		boolean result = false;
		boolean[][] s = new boolean[n + 1][m + 1];
		for (int i = 0; i <= n; i++) {
			s[i][0] = true;
		}
		for (int j = 1; j <= m; j++) {
			s[0][j] = false;
		}
		for (int l = 1; l <= n; l++) {
			for (int k = 1; k <= m; k++) {
				if (k - w[l - 1] < 0) {
					s[l][k] = s[l - 1][k];
					continue;
				}
				s[l][k] = s[l - 1][k] || s[l - 1][k - w[l - 1]];
			}
		}
		result = s[n][m];
		// s배열 확인용 출력 코드
		for (int i = 0; i < s.length; i++) {
			System.out.println(Arrays.toString(s[i]));
		}
		return result;
	}

	public static void main(String[] args) {
		int[] w = new int[] { 7, 8, 5, 3 };
		int m = 13;
		Scale s = new Scale();
		System.out.println(s.canMeasure(4, w, m));
		System.out.println();
		System.out.println(s.canMeasure2(4, w, m));

	}

}
