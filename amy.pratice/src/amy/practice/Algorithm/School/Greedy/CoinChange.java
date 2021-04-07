package amy.practice.Algorithm.School.Greedy;

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
	 * 고객에게 거스름돈을 줄 때 가장 적은 동전 개수로 거스름돈을 줄 때 각 동전의 개수를 반환
	 * 
	 * @param T 고객에게 돌려줄 거스름돈(단, 입력된 거스름돈은 주어진 동전의 최소액면가 이하는 절사)
	 * @param n 동전의 종류수
	 * @param C 동전의 액면가를 내림차순으로 정렬한 배열
	 * @return 거스름돈으로 돌려줄 각 동전의 개수(동전 액면가가 큰 순서)
	 */
	public int[] change(int T, int n, int[] C) {
		int[] coinCnts = new int[n];
		double amt = (double)T;
		int minCoin = C[n-1];
		int i = 0;
		while(amt > minCoin) {
			coinCnts[i] = (int)Math.floor(amt/C[i]);
			amt %= C[i];
			i++;
		}
		if(amt>0) {
			System.out.printf("반환가능한 액면가 이하인 %.0f원은 반환되지 않습니다\r\n", amt);
		}
		return coinCnts;
	}

	public static void main(String[] args) {
		CoinChange cc = new CoinChange();
		int T= 872;
		int[] C = new int[] {500, 100, 50, 10};
		int n = C.length;
		int[] coinCnts = cc.change(T, n, C);
		System.out.println("거스름돈 " +T +"원이");
		IntStream.range(0, n).forEach(i-> System.out.printf(" %d원*%d개 \t",C[i],coinCnts[i]));
		System.out.printf("\r\n 총 동전 개수: %d개로 반환되었습니다. \r\n",IntStream.range(0, n).reduce(0,(total, i)-> total+coinCnts[i]));
	}

}
