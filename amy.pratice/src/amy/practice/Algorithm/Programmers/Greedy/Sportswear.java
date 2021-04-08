package amy.practice.Algorithm.Programmers.Greedy;

import java.util.stream.IntStream;

/**
 * 체육복
 * 
 * 
 * 점심시간에 도둑이 들어, 일부 학생이 체육복을 도난당했습니다. 다행히 여벌 체육복이 있는 학생이 이들에게 체육복을 빌려주려 합니다.
 * 학생들의 번호는 체격 순으로 매겨져 있어, 바로 앞번호의 학생이나 바로 뒷번호의 학생에게만 체육복을 빌려줄 수 있습니다. 예를 들어, 4번
 * 학생은 3번 학생이나 5번 학생에게만 체육복을 빌려줄 수 있습니다. 체육복이 없으면 수업을 들을 수 없기 때문에 체육복을 적절히 빌려
 * 최대한 많은 학생이 체육수업을 들어야 합니다.
 * 
 * 전체 학생의 수 n, 체육복을 도난당한 학생들의 번호가 담긴 배열 lost, 여벌의 체육복을 가져온 학생들의 번호가 담긴 배열
 * reserve가 매개변수로 주어질 때, 체육수업을 들을 수 있는 학생의 최댓값을 return 하도록 solution 함수를 작성해주세요.
 * 
 * 
 * @author "Amy"
 *
 */
public class Sportswear {

	/**
	 * 체육수업을 들을 수 있는 학생의 최댓값
	 * 
	 * @param n       전체 학생의 수
	 * @param lost    체육복을 도난당한 학생들의 번호가 담긴 배열
	 * @param reserve 여벌의 체육복을 가져온 학생들의 번호가 담긴 배열
	 * @return 체육수업을 들을 수 있는 학생의 최댓값
	 */
	public int solution(int n, int[] lost, int[] reserve) {
		int[] students = new int[n];
		for (int l : lost) {
			int lostIdx = l - 1;
			students[lostIdx] --;
		}
		
		for (int r : reserve) {
			int reserveIdx = r - 1;
				students[reserveIdx] ++;
		}
		
		for (int r : reserve) {
			int reserveIdx = r - 1;
			if(students[reserveIdx] < 1) {
				continue;
			}

			if (reserveIdx > 0 &&  students[reserveIdx - 1] == -1) {
				students[reserveIdx - 1] = 0;
				continue;
			}

			if (reserveIdx< n-1 && students[reserveIdx + 1] == -1) {
				students[reserveIdx + 1] = 0;
			}
		}
		
		int result = (int) IntStream.range(0, n).filter(i->students[i]>=0).count(); 

		return result;
	}

	public static void main(String[] args) {

		Sportswear sp = new Sportswear();
		int n;
		int[] lost;
		int[] reserve;
		int expected;

		
		  n = 5; lost = new int[] { 2, 4 }; reserve = new int[] { 1, 3, 5 }; expected =
		  5; System.out.printf("expected : %d  actual: %d \r\n", expected,
		  sp.solution(n, lost, reserve));
		  
		  n = 5; lost = new int[] { 2, 4 }; reserve = new int[] { 3 }; expected = 4;
		  System.out.printf("expected : %d  actual: %d \r\n", expected, sp.solution(n,
		  lost, reserve));
		  
		  n = 3; lost = new int[] { 3 }; reserve = new int[] { 1 }; expected = 2;
		  System.out.printf("expected : %d  actual: %d \r\n", expected, sp.solution(n,
		  lost, reserve));
		  
		  n = 5; lost = new int[] { 1, 2, 3 }; reserve = new int[] { 2, 3, 4 };
		  expected = 4; System.out.printf("expected : %d  actual: %d \r\n", expected,
		  sp.solution(n, lost, reserve));
		  
		  n = 7; lost = new int[] { 2, 4, 5, 6, 7 }; reserve = new int[] { 1, 3, 4, 5,
		  6, 7 }; expected = 7; System.out.printf("expected : %d  actual: %d \r\n",
		  expected, sp.solution(n, lost, reserve));
		  
		  
		  n = 4; lost = new int[] { 4, 2 }; reserve = new int[] {1, 3}; expected = 4;
		  System.out.printf("expected : %d  actual: %d \r\n", expected, sp.solution(n,
		  lost, reserve));
		  
		  n = 2; lost = new int[] { 1,2 }; reserve = new int[] {1,2}; expected = 2;
		  System.out.printf("expected : %d  actual: %d \r\n", expected, sp.solution(n,
		  lost, reserve));
		  
		  n = 2; lost = new int[] { 1}; reserve = new int[] {1}; expected = 2;
		  System.out.printf("expected : %d  actual: %d \r\n", expected, sp.solution(n,
		  lost, reserve));
		  
		  n = 8; lost = new int[] {2,3,5,8}; reserve = new int[] {1,4,6,7,8}; expected
		  = 8; System.out.printf("expected : %d  actual: %d \r\n", expected,
		  sp.solution(n, lost, reserve));
		  
		  n = 4; lost = new int[] {3,1,2}; reserve = new int[] {2,4,3}; expected = 3;
		  System.out.printf("expected : %d  actual: %d \r\n", expected, sp.solution(n,
		  lost, reserve));
		 
		
		n = 5;
		lost = new int[] {2, 3, 4};
		reserve = new int[] {1, 2, 3};
		expected = 4;
		System.out.printf("expected : %d  actual: %d \r\n", expected, sp.solution(n, lost, reserve));
		

	}

}
