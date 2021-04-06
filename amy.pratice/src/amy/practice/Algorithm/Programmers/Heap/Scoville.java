package amy.practice.Algorithm.Programmers.Heap;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * 프로그래머스 더 매운
 * 
 * 매운 것을 좋아하는 Leo는 모든 음식의 스코빌 지수를 K 이상으로 만들고 싶습니다. 모든 음식의 스코빌 지수를 K 이상으로 만들기 위해
 * Leo는 스코빌 지수가 가장 낮은 두 개의 음식을 아래와 같이 특별한 방법으로 섞어 새로운 음식을 만듭니다. Leo는 모든 음식의 스코빌
 * 지수가 K 이상이 될 때까지 반복하여 섞습니다. Leo가 가진 음식의 스코빌 지수를 담은 배열 scoville과 원하는 스코빌 지수 K가
 * 주어질 때, 모든 음식의 스코빌 지수를 K 이상으로 만들기 위해 섞어야 하는 최소 횟수를 return 하도록 solution 함수를
 * 작성해주세요.
 * 
 * @author "Amy"
 *
 */
public class Scoville {

	/**
	 * @param scoville Leo가 가진 음식의 스코빌 지수를 담은 배열
	 * @param K        원하는 스코빌 지수
	 * @return 모든 음식의 스코빌 지수를 K 이상으로 만들 수 없는 경우에는 -1을 return 합니다.
	 */
	public int solution(int[] scoville, int K) {
		int cnt = 0;
		PriorityQueue< Integer> q = new PriorityQueue<>();
		Arrays.stream(scoville).forEach((s)->q.add(s));
		System.out.println(q);
		while(!q.isEmpty()) {
			int minSpicy = q.poll();
			if(minSpicy >= K ) {
				return cnt;
			}
			cnt++;
			if(q.isEmpty()) {return -1;}
			int nextSpicy = q.poll();
			int mixed  = minSpicy + (2*nextSpicy);
			q.add(mixed);
			
		}
		return -1;
	}

	public static void main(String[] args) {
		Scoville sc = new Scoville();



		System.out.println(sc.solution(new int[]{0, 0, 3, 9, 10, 12}, 7)+" 5expected: "+ 3);
		System.out.println(sc.solution(new int[]{0, 0, 0, 0}, 7)+" 6expected: "+ -1);
		System.out.println(sc.solution(new int[]{0, 0, 3, 9, 10, 12}, 7000)+" 7expected: "+ -1);
		System.out.println(sc.solution(new int[]{0, 0, 3, 9, 10, 12}, 0)+" 8 expected: "+ 0);
		System.out.println(sc.solution(new int[]{0, 0, 3, 9, 10, 12}, 1)+" 9 expected: "+ 2);
		System.out.println(sc.solution(new int[]{0, 0}, 0)+" 10 expected: "+ 0);
		System.out.println(sc.solution(new int[]{0, 0}, 1)+" 11 expected: "+ -1);
		System.out.println(sc.solution(new int[]{1, 0}, 1)+"  12expected: "+ 1);

		
	}

}
