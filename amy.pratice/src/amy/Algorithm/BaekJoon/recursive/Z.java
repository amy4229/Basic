package amy.Algorithm.BaekJoon.recursive;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import amy.Algorithm.BaekJoon.DP.Fibonacci;

/**
 * 백준 #1074
 * 
 * 문제 한수는 크기가 2N × 2N인 2차원 배열을 Z모양으로 탐색하려고 한다. 예를 들어, 2×2배열을 왼쪽 위칸, 오른쪽 위칸, 왼쪽
 * 아래칸, 오른쪽 아래칸 순서대로 방문하면 Z모양이다. * N이 주어졌을 때, r행 c열을 몇 번째로 방문하는지 출력하는 프로그램을
 * 작성하시오.
 * 
 * 
 * 입력 첫째 줄에 정수 N, r, c가 주어진다.
 * 
 * 출력 r행 c열을 몇 번째로 방문했는지 출력한다.
 * 
 * @author "Amy"
 *
 */
public class Z {
	public static int r;
	public static int c;
	public static int result = 0;

	public void solution(int n, int x, int y) {
		if(n == 2) {
			if(r==y && c == x) {
				System.out.println(result);
				return ;
			}
			result++;
			if(r==y && c==x+1) {
				System.out.println(result);
				return;
			}
			result++;
			if(r==y+1 && c==x ) {
				System.out.println(result);
				return;
			}
			result++;
			if(r == y+1 && c==x+1) {
				System.out.println(result);
				return;
			}
			return;
		}
		//1사분면
		if(r<y+(n/2) && c <x+(n/2)) {
			solution(n/2, x, y);
		} else if(r < y+(n/2) && c >= x+(n/2)) {
			//2사분면
			result += Math.pow(n/2, 2);
			solution(n/2, x+(n/2), y);
		} else if(r >= y+(n/2) && c < x+(n/2) ) {
			//3사분면
			result += 2 * Math.pow(n/2, 2);
			solution(n/2, x, y+(n/2));
		} else {
			//4사분면
			result += 3*Math.pow(n/2, 2);
			solution(n/2, x+(n/2), y+(n/2));
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] inputs = br.readLine().trim().split(" ");
		int n = Integer.parseInt(inputs[0]);
		r = Integer.parseInt(inputs[1]);
		c = Integer.parseInt(inputs[2]);
		new Z().solution((int)Math.pow(2,n), 0, 0);
		br.close();

	}

}
