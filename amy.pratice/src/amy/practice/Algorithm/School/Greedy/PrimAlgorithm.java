package amy.practice.Algorithm.School.Greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

public class PrimAlgorithm {
	class Edge implements Comparable<Edge> {
		String v;
		int w;

		public Edge(String v, int w) {
			super();
			this.v = v;
			this.w = w;
		}

		@Override
		public int compareTo(Edge o) {
			// TODO Auto-generated method stub
			return this.w - o.w;
		}

	}

	public void prim(String[][] graph, int n, String start) {
		HashMap<String, PriorityQueue<Edge>> graphs = new HashMap<String, PriorityQueue<Edge>>();
		ArrayList<String> selected = new ArrayList<String>();
		ArrayList<String> selectedE = new ArrayList<String>();
		Set<String> unselected = new HashSet<>();
		int amtWeight = 0;
		

		// 초기화 정점별 연결간선 정보
		for (String[] info : graph) {
			String v1 = info[0];
			String v2 = info[1];
			unselected.add(v1);
			unselected.add(v2);

			int w = Integer.parseInt(info[2]);
			Edge e;
			if (!graphs.containsKey(v1)) {
				graphs.put(v1, new PriorityQueue<PrimAlgorithm.Edge>());
			}
			e = new Edge(v2, w);
			graphs.get(v1).add(e);

			if (!graphs.containsKey(v2)) {
				graphs.put(v2, new PriorityQueue<PrimAlgorithm.Edge>());
			}
			e = new Edge(v1, w);
			graphs.get(v2).add(e);
		}

		// selected 초기설정
		int idx = 0;
		selected.add(start);
		unselected.remove(start);
		
		while (unselected.size() > 0) {
			StringBuilder edgeName = null;
			int min = Integer.MAX_VALUE;
			PriorityQueue<Edge> pq = null;
			String sV = null;
			String finalVal ="";
			Edge estimated =null;
			for(int i =0; i <= idx; i++) {
				sV = selected.get(i);
				pq = graphs.get(sV);
				if(pq.isEmpty()) {
					continue;
				}
				estimated = pq.poll();
				boolean isContinue =true;
				while(selected.contains(estimated.v)) {
					if(pq.isEmpty()) {
						isContinue =false; 
						break;
					}
					estimated = pq.poll();
				}
				if(! isContinue) continue;
				if(min > estimated.w) {
					min = estimated.w;
					edgeName = new StringBuilder(sV).append("-").append(estimated.v);
					finalVal = estimated.v;
				}
				
			}
			if(!finalVal.isEmpty()) {
				selected.add(finalVal);
				System.out.print("현재 선택된 정점 : "+ selected.toString());
				idx++;
				selectedE.add(edgeName.toString());
				System.out.print(" 현재 선택된 간선 : "+ selectedE.toString());
				unselected.remove(finalVal);
				System.out.println(" 남은 선택되지 않은 정점 : "+ unselected.toString());
				amtWeight += min;
				
			}
		}

		System.out.println("최종 선택된 간선 :" +selectedE.toString());
		System.out.println("최소 가중치 : "+amtWeight);
	}

	public static void main(String[] args) {

		// TODO Auto-generated method stub
		String[][] graph = new String[][] { { "a", "b", "1" }, { "a", "c", "6" }, { "b", "c", "2" }, { "b", "d", "5" },
				{ "b", "e", "4" }, { "c", "d", "2" }, { "c", "e", "3" }, { "d", "e", "1" }, { "d", "f", "4" },
				{ "e", "f", "7" } };
		PrimAlgorithm pa = new PrimAlgorithm();
		pa.prim(graph, 6, "a");

	}

}
