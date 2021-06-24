package amy.Algorithm.DFSBFS;

import java.util.Arrays;

/**
 * 프로그래머스 _ 여행경로
 * 
 * 주어진 항공권을 모두 이용하여 여행경로를 짜려고 합니다. 항상 "ICN" 공항에서 출발합니다.
 * 
 * 항공권 정보가 담긴 2차원 배열 tickets가 매개변수로 주어질 때, 방문하는 공항 경로를 배열에 담아 return 하도록
 * solution 함수를 작성해주세요.
 * 
 * 제한사항
 * 
 * 모든 공항은 알파벳 대문자 3글자로 이루어집니다. 주어진 공항 수는 3개 이상 10,000개 이하입니다. tickets의 각 행 [a,
 * b]는 a 공항에서 b 공항으로 가는 항공권이 있다는 의미입니다. 주어진 항공권은 모두 사용해야 합니다. 만일 가능한 경로가 2개 이상일
 * 경우 알파벳 순서가 앞서는 경로를 return 합니다. 모든 도시를 방문할 수 없는 경우는 주어지지 않습니다.
 * 
 * @author "Amy"
 *
 */
public class TravelRoute {
	private static final String SEPERATOR = ",";
	private static final String START = "ICN";
	private  String[] route;

	public String[] solution(String[][] tickets) {
		route = null;
		StringBuilder path = new StringBuilder();
		// 티켓배열 정렬
		Arrays.sort(tickets, (t1, t2) -> {
			if (t1[0].compareTo(t2[0]) == 0)
				return t1[1].compareTo(t2[1]);
			return t1[0].compareTo(t2[0]);
		});

		boolean[] used = new boolean[tickets.length];
		int ticketCnt = 0;
		 dfs(path, tickets, used, START, ticketCnt, -1);
		 return route;
	}

	private void dfs(StringBuilder path, String tickets[][], boolean[] used, String start, int ticketCnt, int pre) {
		if(route != null) return;
		if (used.length == ticketCnt) {
			route = path.toString().split(SEPERATOR);
			return;
		}
		boolean hasAdded = false;
		for (int i = 0; i < tickets.length; i++) {
			if (used[i] && ticketCnt != used.length)
				continue;
			String[] ticket = tickets[i];
			String depart = ticket[0];
			String dest = ticket[1];
			
			if (depart.equals(start)) {
				if(!hasAdded) {
					path.append(depart).append(SEPERATOR);
					if (ticketCnt == tickets.length - 1) {
						path.append(dest);
						used[i] = true;
					}
				}
				hasAdded = true;
				if(ticketCnt > 0) used[pre] = true;
				dfs(new StringBuilder(path), tickets, Arrays.copyOf(used, used.length), dest, ticketCnt + 1, i);
			}
		}
		
		
	}

	public static void main(String[] args) {

		TravelRoute tr = new TravelRoute();
		String[][] tickets = null;
		String[] expected =null;
	 	// 1
		tickets = new String[][] { { "ICN", "JFK" }, { "HND", "IAD" }, { "JFK", "HND" } };
		expected = new String[] { "ICN", "JFK", "HND", "IAD" };
		System.out.printf("1. expected %s \tactual : %s\r\n", Arrays.toString(expected),
				Arrays.toString(tr.solution(tickets)));
		// 2
		tickets = new String[][] { { "ICN", "SFO" }, { "ICN", "ATL" }, { "SFO", "ATL" }, { "ATL", "ICN" },
				{ "ATL", "SFO" } };
		expected = new String[] { "ICN", "ATL", "ICN", "SFO", "ATL", "SFO" };
		System.out.printf("2. expected %s \tactual : %s\r\n", Arrays.toString(expected),
				Arrays.toString(tr.solution(tickets)));
		//3
		tickets = new String[][] { { "ICN", "SFO" }, { "SFO", "ICN" }, { "ICN", "SFO" }, { "SFO", "QRE" } };
		expected = new String[] { "ICN", "SFO", "ICN", "SFO", "QRE" };
		System.out.printf("3. expected %s \tactual : %s\r\n", Arrays.toString(expected),
				Arrays.toString(tr.solution(tickets)));
		//4
		tickets = new String[][] { { "ICN", "AAA" }, { "ICN", "AAA" }, { "ICN", "AAA" }, { "AAA", "ICN" },
				{ "AAA", "ICN" } };
		expected = new String[] { "ICN", "AAA", "ICN", "AAA", "ICN", "AAA" };
		System.out.printf("4. expected %s \tactual : %s\r\n", Arrays.toString(expected),
				Arrays.toString(tr.solution(tickets)));
		
		//5
		tickets = new String[][] { { "ICN", "COO" }, { "ICN", "BOO" }, { "COO", "ICN" }, { "BOO", "DOO" } };
		expected = new String[] { "ICN", "COO", "ICN", "BOO", "DOO" };
		System.out.printf("5 .expected %s \tactual : %s\r\n", Arrays.toString(expected),
				Arrays.toString(tr.solution(tickets)));
		
		
		//6
		tickets = new String[][] { { "ICN", "SFO" }, { "SFO", "ICN" }, { "ICN", "SFO" }, { "SFO", "QRE" } };
		expected = new String[] { "ICN", "SFO", "ICN", "SFO", "QRE" };
		System.out.printf("6. expected %s \tactual : %s\r\n", Arrays.toString(expected),
				Arrays.toString(tr.solution(tickets)));
		
		
		//7
		tickets = new String[][] { { "ICN", "BOO" }, { "ICN", "COO" }, { "COO", "DOO" }, { "DOO", "COO" },
				{ "BOO", "DOO" }, { "DOO", "BOO" }, { "BOO", "ICN" }, { "COO", "BOO" } };
		expected = new String[] { "ICN", "BOO", "DOO", "BOO", "ICN", "COO", "DOO", "COO", "BOO" };
		System.out.printf("7. expected %s \tactual : %s\r\n", Arrays.toString(expected),
				Arrays.toString(tr.solution(tickets)));
	}

}
