package amy.Algorithm.DFSBFS;

import java.util.Stack;

/**
 * 프로그래머스 네트워크
 * 
 * 네트워크란 컴퓨터 상호 간에 정보를 교환할 수 있도록 연결된 형태를 의미합니다. 예를 들어, 컴퓨터 A와 컴퓨터 B가 직접적으로
 * 연결되어있고, 컴퓨터 B와 컴퓨터 C가 직접적으로 연결되어 있을 때 컴퓨터 A와 컴퓨터 C도 간접적으로 연결되어 정보를 교환할 수
 * 있습니다. 따라서 컴퓨터 A, B, C는 모두 같은 네트워크 상에 있다고 할 수 있습니다.
 * 
 * 컴퓨터의 개수 n, 연결에 대한 정보가 담긴 2차원 배열 computers가 매개변수로 주어질 때, 네트워크의 개수를 return 하도록
 * solution 함수를 작성하시오.
 * 
 * @author "Amy"
 *
 */
public class Network {
//DFS stack
	public int solution(int n, int[][] computers) {
		int result = 0;
		boolean[] visited = new boolean[n];
		Stack<Integer> s = new Stack<>();
		int start = -1;

		while (true) {
			for (int i = 0; i < computers.length; i++) {
				if (!visited[i] ) {
					start = i;
					break;
				}
			}
			if (start < 0) {
				return result;
			}

			s.add(start);
			while (!s.isEmpty()) {
				int target = s.pop();
				visited[target] = true;
				int[] linked = computers[target];
				for (int j = 0; j < linked.length; j++) {
					if (j != target && linked[j] == 1 && !visited[j]) {
						s.add(j);
					}
				}
			}
			start = -2;
			result++;
		}

	}

	public static void main(String[] args) {
		Network nt = new Network();
		int n = 3;
		int[][] computers = new int[][] { { 1, 1, 0 }, { 1, 1, 0 }, { 0, 0, 1 } };
		int expected = 2;
		System.out.printf("n: %d  expected : %d actual : %d \n", n, expected,	nt.solution(n, computers));

		n = 3;
		computers = new int[][] { { 1, 1, 0 }, { 1, 1, 1 }, { 0, 1, 1 } };
		expected = 1;
		System.out.printf("n: %d  expected : %d actual : %d \n", n, expected,	nt.solution(n, computers));

		n = 5;
		computers = new int[][] { { 1, 0, 0, 0, 0 }, { 0, 1, 0, 0, 0 }, { 0, 0, 1, 0, 0 },{ 0, 0, 0, 1, 0 },{ 0, 0, 0, 0, 0 } };
		expected = 5;
		System.out.printf("n: %d  expected : %d actual : %d \n", n, expected,	nt.solution(n, computers));

	}

}
