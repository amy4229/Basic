package amy.practice.Algorithm.School.Greedy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class DirectionalDijkstra {
	class DEdge {
		String vertex;
		int weight;

		public DEdge(String vertex, int weight) {
			super();
			this.vertex = vertex;
			this.weight = weight;
		}

	}

	public void dijkstra(String[] vertexes, String[][] edges, String start, String end) {
		List<String> unvisited = Arrays.stream(vertexes).collect(Collectors.toList());
		HashMap<String, DEdge> dist = new HashMap<String, DEdge>();
		IntStream.range(0, vertexes.length).forEach(i -> dist.put(vertexes[i], new DEdge(null, Integer.MAX_VALUE)));
		HashMap<String, LinkedList<DEdge>> edgeMap = new HashMap<>();
		for (String[] edge : edges) {
			String ori = edge[0];
			String dest = edge[1];
			int w = Integer.parseInt(edge[2]);
			DEdge de = new DEdge(dest, w);
			if (!edgeMap.containsKey(ori)) {
				edgeMap.put(ori, new LinkedList<DEdge>());
			}
			edgeMap.get(ori).add(de);
		}

		unvisited.remove(unvisited.indexOf(start));
		dist.put(start, new DEdge(start, 0));
		String depart = start;

		while (true) {
			// 현재 시작정점까지 최소거리
			int amt = dist.get(depart).weight;
			// 시작정점의 인접간선
			LinkedList<DEdge> list = edgeMap.get(depart);

			// 다음 시작정점지정 초기화
			String nP = null;
			int min = Integer.MAX_VALUE;
			// 인접연결된 모든 정점 갱신
			while (list != null && !list.isEmpty()) {
				DEdge dE = list.poll();
				int edgeW = amt + dE.weight;
				// 만약 기존의 해당정점의 가중치보다 현재 경로의 가중치가 더 작다면
				if (dist.get(dE.vertex).weight >= edgeW) {
					// 가중치를 갱신
					dist.get(dE.vertex).weight = edgeW;
					// 선행정점을 현재 시작정점으로 갱신
					dist.get(dE.vertex).vertex = depart;
				}
				// 아직 방문하지 않은 정점중 갱신된 가중치가 인접정정중 최소값이라면 다음 인접정점은
				if ( dist.get(dE.vertex).weight < min) {
					nP = dE.vertex;
					min = dist.get(dE.vertex).weight;
				}
			}
			if(unvisited.size() <= 0)  break;
			if (nP == null) {
				int minW = Integer.MAX_VALUE;
				for (String uP : unvisited) {
					if (!uP.equals(end) && dist.get(uP).weight < minW) {
						nP = uP;
					}
				}
			}
			System.out.printf("시작정점 = %s", depart);
			depart = nP;
			System.out.printf(" 종료정점 = %s 선행정점 %s 가중치 %d\r\n", depart, dist.get(depart).vertex,
					dist.get(depart).weight);
			unvisited.remove(depart);
		}
		System.out.printf("출발점 %s ~  도착첨 %s 까지의 최단거리 %d   ", start, end, dist.get(end).weight);
		StringBuilder path = new StringBuilder();
		String v = end;
		path.append(v);
		while (!v.equals(start)) {
			v = dist.get(v).vertex;
			path.append(v);
		}
		System.out.println(" 경로" + path.toString());
		for (int i = vertexes.length - 1; i > 0; i--) {
			String key = vertexes[i];
			System.out.printf("정점 %s 선생정점 %s 최소가중치 %d \r\n", key, dist.get(key).vertex, dist.get(key).weight);
		}
	}

	public static void main(String[] args) {

		DirectionalDijkstra dd = new DirectionalDijkstra();
		String[][] graphs = null;
		String start = "a";
		String end = "f";
		graphs = new String[][] { { "a", "b", "1" }, { "a", "c", "7" }, { "a", "d", "4" }, { "a", "e", "6" },
				{ "b", "d", "2" }, { "c", "f", "3" }, { "d", "c", "3" }, { "d", "e", "4" }, { "e", "c", "2" },
				{ "e", "d", "2" }, { "e", "f", "2" } };
		int expected = 8;
		System.out.println("expected : " + expected);
		String[] vertexes = new String[] { "a", "b", "c", "d", "e", "f" };
		dd.dijkstra(vertexes, graphs, start, end);
	}
}
