package amy.practice.Algorithm.Programmers.Sort;

import java.util.Arrays;

/**
 * 프로그래머스 정렬 H-index
 * 
 * H-Index는 과학자의 생산성과 영향력을 나타내는 지표입니다. 어느 과학자의 H-Index를 나타내는 값인 h를 구하려고 합니다.
 * 위키백과1에 따르면, H-Index는 다음과 같이 구합니다.
 * 
 * 어떤 과학자가 발표한 논문 n편 중, h번 이상 인용된 논문이 h편 이상이고 나머지 논문이 h번 이하 인용되었다면 h의 최댓값이 이
 * 과학자의 H-Index입니다.
 * 
 * 어떤 과학자가 발표한 논문의 인용 횟수를 담은 배열 citations가 매개변수로 주어질 때, 이 과학자의 H-Index를 return
 * 하도록 solution 함수를 작성해주세요.
 * 
 * @author "Amy"
 *
 */
public class Hindex {
	private int[] sort(int[] citations, int left, int right) {
		int pl = left;
		int pr = right;
		int x = citations[(pl + pr) / 2];

		do {
			while (citations[pl] > x)
				pl++;
			while (citations[pr] < x)
				pr--;
			if (pl <= pr) {
				int temp = citations[pl];
				citations[pl] = citations[pr];
				citations[pr] = temp;
				pl++;
				pr--;
			}
		} while (pl <= pr);

		if (left < pr)
			sort(citations, left, pr);
		if (right > pl)
			sort(citations, pl, right);
		return citations;

	}

	public int solution(int[] citations) {
		int answer = 0;
		int[] sorted = sort(citations, 0, citations.length - 1);
		System.out.println(Arrays.toString(sorted));
		for (int i = citations.length - 1; i >= 0; i--) {
			if (sorted[i] >= i+1) {
				answer = i+1;
				System.out.println("sorted[i]: "+sorted[i]+" i : "+i);
				break;
			}

		}
		return answer;
	}

	public static void main(String[] args) {
		Hindex h = new Hindex();
		int[] citations1 = {3, 0, 6, 1, 5};
		System.out.println("expected : 3 "+h.solution(citations1));

		int[] citations2 = {9, 7, 6, 2, 1};
		System.out.println("expected : 3 "+h.solution(citations2));
		
		int[] citations3 = {10, 8, 5, 4,3};
		System.out.println("expected : 4 "+h.solution(citations3));
		
		int[] citations4 = {25, 8, 5, 3, 3};
		System.out.println("expected : 3 "+h.solution(citations4));
		
	}

}
