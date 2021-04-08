package amy.practice.Algorithm.School.Greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class CruskalAlgorithm {
	class Edge {
		String v1;
		String v2;
		int weight;

		public Edge(String v1, String v2, int weight) {
			super();
			this.v1 = v1;
			this.v2 = v2;
			this.weight = weight;
		}

	}

	public void cruskalAlgorithm(String[][] graph, int n) {
		int amtWeight = 0;
		ArrayList<StringBuilder> grps = new ArrayList<StringBuilder>();
		String[] selected = new String[n-1];
		
		Edge[] edges = new Edge[graph.length];
		for(int i = 0; i<graph.length; i++) {
			Edge edge = new Edge(graph[i][0],graph[i][1],Integer.parseInt(graph[i][2]));
			edges[i] =edge;
		}
		Arrays.sort(edges,(e1,e2)->e1.weight-e2.weight);
		int i = 0;
		int selectedNo =0;
		while(i<graph.length) {
			Edge e = edges[i];
			System.out.println("현재그룸"+ grps.toString());
			System.out.printf("현재 간선 : [%s,%s,%d]", e.v1,e.v2,e.weight );
			
			i++;
			String edgeName= new StringBuilder(e.v1).append("-").append(e.v2).toString();
			if(grps.isEmpty()) {
				//비어 있으면 추가
				grps.add(new StringBuilder(e.v1).append(e.v2));
				amtWeight+=e.weight;
				System.out.println("첫 그룹 형성");
				selected[selectedNo++] = edgeName;
				continue;
			}
			
			int grp1 = -1;
			int grp2 = -1;
			for(int grpIdx = 0; grpIdx<grps.size(); grpIdx++) {
				grp1 = grps.get(grpIdx).indexOf(e.v1)>=0 ? grpIdx:grp1;
				grp2 = grps.get(grpIdx).indexOf(e.v2)>=0 ? grpIdx:grp2;
			}
			
			//어떤 그룹에도 속하지 않을 때
			if(grp1 == -1 && grp2 ==-1) {
				//새로운 군집 형성
				grps.add(new StringBuilder(e.v1).append(e.v2));
				amtWeight+=e.weight;
				selected[selectedNo++] = edgeName;
				System.out.println("그룹 추가");
				continue;
			}
			
			//두 정점다 이미 한그룹에 속해있을 때
			if(grp1 == grp2) {
				System.out.println("간선 선택안함");
				continue;
			}
			
			selected[selectedNo++] = edgeName;
			//한정점만 한그룹에 속해있고 나머진 아직 그룹이 없을 때
			if(grp1== -1||grp2 == -1) {
				System.out.println("기존그룹에 정점 추가");
				if(grp1 == -1) {
					grps.get(grp2).append(e.v1);
				}else {
					grps.get(grp1).append(e.v2);
				}
				amtWeight+=e.weight;
				continue;
			}
			
			//두정점이 서로 다른 그룹에 있을 때
			if(grp1 != grp2) {
				System.out.println("그룹합침");
				grps.get(grp1).append(grps.get(grp2));
				grps.remove(grp2);
				amtWeight+=e.weight;
				continue;
			}
			
		}
		System.out.println("최소합계 가중치 : "+ amtWeight);
		System.out.println("선택된 간선 :"+ Arrays.toString(selected));

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[][] graph = new String[][] { { "a", "b", "1" }, { "a", "c", "6" }, { "b", "c", "2" }, { "b", "d", "5" },
				{ "b", "e", "4" }, { "c", "d", "2" }, { "c", "e", "3" }, { "d", "e", "1" }, { "d", "f", "4" },
				{ "e", "f", "7" } };
				CruskalAlgorithm ca = new CruskalAlgorithm();
				ca.cruskalAlgorithm(graph,6);

	}

}
