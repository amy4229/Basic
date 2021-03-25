package amy.pratice.Algorithm.BaekJoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * 백준1920번 - 수 찾기
 * N개의 정수 A[1], A[2], …, A[N]이 주어져 있을 때, 이 안에 X라는 정수가 존재하는지 알아내는 프로그램을 작성하시오.
 * 
 * @param 첫째 줄에 자연수 N(1 ≤ N ≤ 100,000)이 주어진다. 다음 줄에는 N개의 정수 A[1], A[2], …, A[N]이
 *           주어진다. 다음 줄에는 M(1 ≤ M ≤ 100,000)이 주어진다. 다음 줄에는 M개의 수들이 주어지는데, 이 수들이
 *           A안에 존재하는지 알아내면 된다. 모든 정수의 범위는 -231 보다 크거나 같고 231보다 작다
 * @retrun M개의 줄에 답을 출력한다. 존재하면 1을, 존재하지 않으면 0을 출력한다.
 */
public class FindNumber {
	public static void solution(int[] input1, int[] input2 ) throws Exception {
		HashSet<Integer> set = new HashSet<>();
		IntStream.of(input1).boxed().forEach(n->set.add(n));
		for(int i = 0; i < input2.length;i++) {
			if(set.contains(input2[i])) {
				System.out.println(1);
			}else {
				System.out.println(0);
			}
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] input1 =Stream.of( br.readLine().split(" ")).mapToInt(b->Integer.parseInt(b)).toArray();
		int[] input2 =Stream.of( br.readLine().split(" ")).mapToInt(b->Integer.parseInt(b)).toArray();
		
		
		solution(input1,input2);
		br.close();

	}

}
