package amy.Algorithm.BaekJoon.BinarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

import amy.Algorithm.BaekJoon.Main;

/**
 * 백준 #1939 중량제한
 * 
 * 
 * 문제 N(2≤N≤10,000)개의 섬으로 이루어진 나라가 있다. 이들 중 몇 개의 섬 사이에는 다리가 설치되어 있어서 차들이 다닐 수
 * 있다.
 * 
 * 영식 중공업에서는 두 개의 섬에 공장을 세워 두고 물품을 생산하는 일을 하고 있다. 물품을 생산하다 보면 공장에서 다른 공장으로 생산
 * 중이던 물품을 수송해야 할 일이 생기곤 한다. 그런데 각각의 다리마다 중량제한이 있기 때문에 무턱대고 물품을 옮길 순 없다. 만약
 * 중량제한을 초과하는 양의 물품이 다리를 지나게 되면 다리가 무너지게 된다.
 * 
 * 한 번의 이동에서 옮길 수 있는 물품들의 중량의 최댓값을 구하는 프로그램을 작성하시오.
 * 
 * 입력 첫째 줄에 N, M(1≤M≤100,000)이 주어진다. 다음 M개의 줄에는 다리에 대한 정보를 나타내는 세 정수 A, B(1≤A,
 * B≤N), C(1≤C≤1,000,000,000)가 주어진다. 이는 A번 섬과 B번 섬 사이에 중량제한이 C인 다리가 존재한다는 의미이다.
 * 서로 같은 두 도시 사이에 여러 개의 다리가 있을 수도 있으며, 모든 다리는 양방향이다. 마지막 줄에는 공장이 위치해 있는 섬의 번호를
 * 나타내는 서로 다른 두 정수가 주어진다. 공장이 있는 두 섬을 연결하는 경로는 항상 존재하는 데이터만 입력으로 주어진다.
 * 
 * 출력 첫째 줄에 답을 출력한다.
 * 
 * @author "Amy"
 *
 */
public class WeightLimit {

	public boolean bfs(HashMap<Integer, HashMap<Integer, Integer>>  islands, int start, int end, int c) {
		Queue<Integer> q = new LinkedList<Integer>();
		boolean[] visited = new boolean[islands.size()+1];
		visited[start] = true;
		q.add(start);
		while (!q.isEmpty()) {
			int sp = q.poll();
			for (int i = 1; i < islands.get(sp).size(); i++) {
				if( islands.get(sp).get(i) == null) continue;
				int dest = islands.get(sp).get(i);
				if (!visited[i] && dest >= c) {
					q.add(i);
					visited[i] = true;
				}
			}
		}
		return visited[end];
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int result = 0;
		String[] line1 = br.readLine().split(" ");
		int n = Integer.parseInt(line1[0]);
		int m = Integer.parseInt(line1[1]);
		HashMap<Integer, HashMap<Integer, Integer>> islands = new HashMap<>();
		int min = Integer.MAX_VALUE;
		int max = 0;
		for (int i = 0; i < m; i++) {
			String[] line = br.readLine().split(" ");
			int a = Integer.parseInt(line[0]);
			int b = Integer.parseInt(line[1]);
			int c = Integer.parseInt(line[2]);
			if (islands.get(a) == null) {
				islands.put(a, new HashMap<>());
			}
			if (islands.get(b) == null) {
				islands.put(b, new HashMap<>());
			}
			int w = c;
			if(islands.get(a).containsKey(b)) {
				w = Math.max(islands.get(a).get(b), c);
			}
			islands.get(a).put(b, w);
			islands.get(b).put(a, w);

			min = Math.min(min, c);
			max = Math.max(max, c);
		}

		String[] plants = br.readLine().split(" ");
		int start = Integer.parseInt(plants[0]);
		int end = Integer.parseInt(plants[1]);
		WeightLimit wl = new WeightLimit();
		while (min <= max) {
			int mid = (min + max) / 2;
			if (wl.bfs(islands, start, end, mid)) {
				result = mid;
				min = mid + 1;
			} else {
				max = mid - 1;
			}

		}

		System.out.println(result);
		br.close();
	}
}
