package amy.practice.Algorithm.BaekJoon.DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 백준#1463번
 * 
 * 1로 만들기
 * 
 * 정수 X에 사용할 수 있는 연산은 다음과 같이 세 가지 이다.
 * 
 * X가 3으로 나누어 떨어지면, 3으로 나눈다. X가 2로 나누어 떨어지면, 2로 나눈다. 1을 뺀다. 이 주어졌을 때, 위와 같은 연산 세
 * 개를 적절히 사용해서 1을 만들려고 한다. 연산을 사용하는 횟수의 최솟값을 출력하시오.
 * 
 * @author "Amy"
 *
 */
public class MakeOne {

	/**
	 * @param 정수 n
	 * @return 연산횟수
	 */
	public int countCalc(int n) {
		int[] result = new int[n+1];
		//3으로 나누어떨어질 때 
		if(n < 2) return 0;
		for(int i = 2; i <= n; i++) {
			result[i] = result[i-1]+1;
			if(i%2 == 0) {
				result[i] = Math.min(result[i], result[i/2]+1);
			}
			if(i%3 == 0) {
				result[i] = Math.min(result[i], result[i/3]+1);
			}
		}
		
		return result[n];
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		MakeOne mo = new MakeOne();
		System.out.println(mo.countCalc(n));

	}

}
