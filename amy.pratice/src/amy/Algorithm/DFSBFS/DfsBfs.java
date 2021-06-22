package amy.Algorithm.DFSBFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.stream.IntStream;

/**
 * 백준 1260 * DFS와 BFS
 * 
 * 그래프를 DFS로 탐색한 결과와 BFS로 탐색한 결과를 출력하는 프로그램을 작성하시오. 단, 방문할 수 있는 정점이 여러 개인 경우에는
 * 정점 번호가 작은 것을 먼저 방문하고, 더 이상 방문할 수 있는 점이 없는 경우 종료한다. 정점 번호는 1번부터 N번까지이다.
 * 
 * @author "Amy"
 *
 */
public class DfsBfs {

	public DfsBfs() {
		// TODO Auto-generated constructor stub
	}

	public int[] DFS(int[][] graph, int n, int v) {
		int[] path = new int[n];
		int cnt = 0;
		boolean[] visited = new boolean[n + 1];
		Stack<Integer> stack = new Stack<>();
		stack.add(v);
		
		while (!stack.isEmpty()) {
			int now = stack.pop();
			if(visited[now]) continue;
			int[] linked = graph[now];
			visited[now] =true;
			path[cnt] = now;
			IntStream.range(0, n+1).forEach(j -> {if(linked[n-j] != 0 && !visited[n-j] ) stack.add(n-j);});
			cnt++;
		}
		return path;
	}

	public int[] BFS(int[][] graph, int n, int v) {
		int[] path = new int[n];
		boolean[] visited = new boolean[n + 1];
		Queue<Integer> q = new LinkedList<>();
		int cnt = 0;
		q.add(v);
		while(!q.isEmpty()) {
			int now = q.poll();
			if(visited[now]) continue;
			path[cnt] = now;
			visited[now] = true;
			int[] linked = graph[now];
			IntStream.rangeClosed(1, n).forEach(i -> {if(linked[i] != 0 && !visited[i] ) q.add(i);});
			cnt++;
		}
		return path;
	}

	public static void main(String[] args) throws IOException {
		DfsBfs db = new DfsBfs();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input1 = br.readLine().split(" ");
		// 정점의 개수N(1 ≤ N ≤ 1,000),
		int n = Integer.parseInt(input1[0]);
		// 간선의 개수 M(1 ≤ M ≤ 10,000),
		int m = Integer.parseInt(input1[1]);
		// 탐색을 시작할 정점의 번호 V
		int v = Integer.parseInt(input1[2]);
		int[][] graph = new int[n + 1][n + 1];

		int i = 0;
		while (i < m) {
			String[] edge = br.readLine().split(" "); 
			int v1 =  Integer.parseInt(edge[0]);
			int v2 = Integer.parseInt(edge[1]);
			graph[v1][v2] = 1;
			graph[v2][v1] = 1;
			i++;
		}

		int[] dfs = db.DFS(graph, n, v);
		StringBuilder sb = new StringBuilder();
		for (int l = 0; l < n; l++) {
			if(dfs[l]==0) break;
			sb.append(dfs[l]).append(" ");
		}
		System.out.println(sb.toString().trim());
		sb = new StringBuilder();
		int[] bfs =db.BFS(graph, n, v);
		for (int k = 0; k< n;k++) {
			if(bfs[k]==0) break;
			sb.append(bfs[k]).append(" ");
		}
		System.out.println(sb.toString().trim());
		br.close();

	}

}
