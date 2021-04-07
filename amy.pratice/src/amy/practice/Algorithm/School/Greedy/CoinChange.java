package amy.practice.Algorithm.School.Greedy;

import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * 욕심쟁이 알고리즘, 탐욕알고리즘 <동전 문제>
 * 
 * 고객에게 거스름돈을 줄 때 가장 적은 동전 개수로 거스름돈을 줄 수 있는 방법
 * 
 * @author amy
 *
 */
public class CoinChange {

	/**
	 * 고객에게 거스름돈을 줄 때 가장 적은 동전 개수로 거스름돈을 줄 때 각 동전의 개수를 반환(욕심쟁이 알고리즘)
	 * 
	 * @param T 고객에게 돌려줄 거스름돈(단, 입력된 거스름돈은 주어진 동전의 최소액면가 이하는 절사)
	 * @param n 동전의 종류수
	 * @param C 동전의 액면가를 내림차순으로 정렬한 배열
	 * @return 거스름돈으로 돌려줄 각 동전의 개수(동전 액면가가 큰 순서)
	 */
	public int[] changeG(int T, int n, int[] C) {
		System.out.println("욕심쟁이 알고리즘 방법 ---------------------------");
		int[] coinCnts = new int[n];
		double amt = (double) T;
		int minCoin = C[n - 1];
		int i = 0;
		while (amt > minCoin) {
			coinCnts[i] = (int) Math.floor(amt / C[i]);
			amt %= C[i];
			i++;
		}
		if (amt > 0) {
			System.out.printf("반환가능한 액면가 이하인 %.0f원은 반환되지 않습니다\r\n", amt);
		}
		return coinCnts;
	}

	/**
	 * 고객에게 거스름돈을 줄 때 가장 적은 동전 개수로 거스름돈을 줄 때 각 동전의 개수를 반환(동적프로그래밍)
	 * 
	 * @param T 고객에게 돌려줄 거스름돈(단, 입력된 거스름돈은 주어진 동전의 최소액면가 이하는 절사)
	 * @param n 동전의 종류수
	 * @param C 동전의 액면가를 내림차순으로 정렬한 배열
	 * @return 거스름돈으로 돌려줄 각 동전의 개수(동전 액면가가 큰 순서)
	 */
	public int changeD(int T, int n, int[] C) {
		System.out.println("동적프로그래밍 방법 ---------------------------");
		int[][] resultTbl = new int[n + 1][(T / 10) + 1];

		/*
		 * for (int i = 0; i < resultTbl.length; i++) { resultTbl[i][0] =
		 * Integer.MAX_VALUE; } for (int i = 0; i < resultTbl[0].length; i++) {
		 * resultTbl[0][1] = 0; }
		 */

		for (int i = 1; i < resultTbl.length; i++) {
			for (int j = 1; j < resultTbl[0].length; j++) {
				if (j - (C[i - 1] / 10) < 0) {
					resultTbl[i][j] =resultTbl[i-1][j]>0 ? Math.min(resultTbl[i-1][j], j / (C[i - 1] / 10)):j / (C[i - 1] / 10);
				} else {
					resultTbl[i][j] =resultTbl[i-1][j]>0 ?  Math.min(resultTbl[i-1][j],
							resultTbl[i][j - (C[i - 1] / 10)] + j / (C[i - 1] / 10)):resultTbl[i][j - (C[i - 1] / 10)] + j / (C[i - 1] / 10);

				}
			}
		}
		System.out.println(resultTbl.length);
		for (int i = 0; i < resultTbl.length; i++) {
			int coin =0;
			if(i>0) {
				coin = C[i-1];
			}
			System.out.println(coin+Arrays.toString(resultTbl[i]));
		}
		return resultTbl[n][(T / 10)];

	}

	public void print(int T, int n, int[] C, int[] coinCnts) {
		System.out.println("거스름돈 " + T + "원이");
		IntStream.range(0, n).forEach(i -> System.out.printf(" %d원*%d개 \t", C[i], coinCnts[i]));
		System.out.printf("\r\n 총 동전 개수: %d개로 반환되었습니다. \r\n",
				IntStream.range(0, n).reduce(0, (total, i) -> total + coinCnts[i]));
	}

	public static void main(String[] args) {
		CoinChange cc = new CoinChange();
		int T = 872;
		int[] C = new int[] { 500, 100, 50, 10 };
		int n = C.length;
		int[] coinCnts = cc.changeG(T, n, C);
		cc.print(T, n, C, coinCnts);

		T = 650;
		C = new int[] { 500, 120, 100, 50, 10 };
		n = C.length;

		coinCnts = cc.changeG(T, n, C);
		cc.print(T, n, C, coinCnts);
		T = 60;
		System.out.println(cc.changeD(T, n, C));
	}

}
