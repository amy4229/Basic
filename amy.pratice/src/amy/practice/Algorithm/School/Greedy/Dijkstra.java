package amy.practice.Algorithm.School.Greedy;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

public class Dijkstra {
	/**최단경로*/
	String minPath;

	/**최단거리*/
	int minTotalDistance;

	/**거리정보*/
	static class Dist {
		/**앞의 노드*/
		char prev = ' ';
		/**최단 경로거리*/
		int minDist = Integer.MAX_VALUE;

		public Dist() {
			// TODO 自動生成されたコンストラクター・スタブ
		}
		public Dist(char prev, int minDist) {
			this.prev = prev;
			this.minDist = minDist;
		}
	}

	/**엣지 정보*/
	static class Edge{
		/**도착지*/
		char v ;
		/**가중치*/
		int w ;

		public Edge(char v, int w) {
			this.v = v;
			this.w = w;
		}
	}

	public void makeMinPath(HashMap<Character, Set<Edge>> adj,HashMap<Character, Dist> dists, char start, char dest){
		char now =start;
		//첫번째 노드 거리값 초기화 0
		dists.get(start).minDist = 0;
		//갱신 플래그
		boolean isChange=false;
		//최종 목적지까지 경로계산 반복
		while(now!=dest){
			//다음 체크할 포인트
			char next = ' ';
			//인접점 중 최단 경로거리
			int minVal = Integer.MAX_VALUE;
			//인접점들과의 엣지
			Set<Edge> edges = adj.get(now);
			adj.remove(now);
			Iterator<Edge> iter= edges.iterator();
			while(iter.hasNext()){
				//도착노드
				Edge nextNode = iter.next();
				//도착노드의 현 최단경로 거리
				Dist dist = dists.get(nextNode.v);
				//최단 경로거리 변경 여부
				isChange = dist.minDist > dists.get(now).minDist+nextNode.w;
				//해당 노드까지의 최단경로거리 설정
				dist.minDist = Math.min(dist.minDist, dists.get(now).minDist+nextNode.w);
				//값 변경시 해당경로의 선행점 정보 변경
				dist.prev = isChange ? now : dist.prev;
				if(adj.containsKey(nextNode.v) &&  minVal > dist.minDist){
					next = nextNode.v;
					minVal = dist.minDist;
				}
			}
			now = next;
		}
		//최단 경로 거리 출력
		Dist dist = dists.get(dest);
		System.out.println("최단거리 :" + dist.minDist);
		char ch =dest;
		StringBuilder path = new StringBuilder().append(ch);
		while(ch != start){
			ch = dists.get(ch).prev;
			path.insert(0,ch);
		}
		System.out.print("최단경로 : "+path.toString());

	}





	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("엣지 수를 입력하시오 :");
		int e = sc.nextInt();
		System.out.print("시작점을 입력하시오 :");
		char start = sc.next().toCharArray()[0];
		System.out.print("도착점을 입력하시오 :");
		char dest = sc.next().toCharArray()[0];
		HashMap<Character, Set<Edge>> adj = new HashMap<Character, Set<Edge>>();
		HashMap<Character, Dist> dists = new HashMap<Character, Dijkstra.Dist>();
		for (int i = 0; i < e; i++) {
			System.out.print("엣지"+i+"의 정보를 입력하세요.");
			System.out.print("v1? : ");
			char v1 = sc.next().toCharArray()[0];
			System.out.print("v2? : ");
			char v2 = sc.next().toCharArray()[0];
			System.out.print("가중치? : ");
			int w = sc.nextInt();
			for(int j =0; j<2; j++){
				if(j>0){
					char tmp = v1;
					v1 = v2;
					v2=tmp;
				}
				if(adj.containsKey(v1)){
					Set<Edge> edgeset = adj.get(v1);
					edgeset.add(new Edge(v2, w));
				}else{
					Set<Edge> edgeSet =new HashSet<Edge>();
					edgeSet.add(new Edge(v2, w));
					adj.put(v1, edgeSet);
				}

				if(!dists.containsKey(v1)){
					dists.put(v1,new Dist());
				}
			}
		}
		Dijkstra path = new Dijkstra();
		path.makeMinPath(adj, dists, start, dest);
	}

}
