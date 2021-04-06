package amy.practice.Algorithm.Programmers.Heap;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * 
 * 디스크 컨트롤러
 * 
 * 하드디스크는 한 번에 하나의 작업만 수행할 수 있습니다. 디스크 컨트롤러를 구현하는 방법은 여러 가지가 있습니다. 가장 일반적인 방법은
 * 요청이 들어온 순서대로 처리하는 것입니다.
 * 
 * 각 작업에 대해 [작업이 요청되는 시점, 작업의 소요시간]을 담은 2차원 배열 jobs가 매개변수로 주어질 때, 작업의 요청부터 종료까지
 * 걸린 시간의 평균을 가장 줄이는 방법으로 처리하면 평균이 얼마가 되는지 return 하도록 solution 함수를 작성해주세요. (단,
 * 소수점 이하의 수는 버립니다)
 * 
 * @author "Amy"
 *
 */
public class DiskController {

	class DCJob implements Comparable<DCJob> {
		int request;
		int processing;

		DCJob(int request, int processing) {
			this.request = request;
			this.processing = processing;
		}

		@Override
		public int compareTo(DCJob job) {
			return this.processing - job.processing;
		}
	}


	/**
	 * 작업의 요청부터 종료까지 걸린 시간의 평균을 가장 줄이는 방법으로 처리하면 평균이 얼마가 되는지 return
	 * 
	 * @param jobs [작업이 요청되는 시점, 작업의 소요시간]을 담은 2차원 배열
	 * @return 요청부터 종료까지 걸린 시간의 평균의 최소값
	 */
	public int solution(int[][] jobs) {
		PriorityQueue<DCJob> q = new PriorityQueue<>();
		int sum = 0;
		//요청 순서대로 배열 정렬 (처리 시간이 길어도 해당 요청시간에 작업이 없으면 작업이 들어가야하므로 요청시간으로 우선 정렬)
		Arrays.sort(jobs, (j1,j2)->j1[0]-j2[0]);
		int idx = 0;
		//작업완료시간 갱신용
		int endTime = 0;
		//큐에 데이터 넣을 타이밍 체크
		boolean isChg = true;
		
		while (true) {
			//큐에 작업 요청을 넣을 타이밍체크 
			if(isChg) {
				isChg =false;
				int chkTime = endTime;
				for(int i = idx; i<jobs.length; i++) {
					//현재 작업의 완료 전 들어온 요청 큐에 추가
					if(jobs[i][0] <= chkTime ){
						q.offer(new DCJob(jobs[i][0],jobs[i][1]));
					//현재 작업 완료전 들어온 요청 없다면 다음 작업의 요청시간과 같은 작업들 추가
					}else if( q.isEmpty()){
						q.offer(new DCJob(jobs[i][0],jobs[i][1]));
						chkTime = jobs[i][0];
					}else {
						idx = i;
						isChg = true;
						break;
					}
				}
			}
			//큐가 비었으면 빠져나감 
			if(q.isEmpty()) break;
			//큐에 들어간 작업중 처리시간이 작은 작업 
			DCJob job = q.poll();
			//작업확인용 코드
			System.out.print(" job : [" + job.request+ "," + job.processing + "] start : " + endTime);
			//해당작업의 작업시간 = 대기시간 + 처리시간
			int workTime = Math.max((endTime - job.request),0) + job.processing;
			sum += workTime;
			//작업완료시간 갱신
			endTime = Math.max(endTime + job.processing,job.request+job.processing);
			//확인용 출력
			System.out.print(" endTime : " + endTime+ " worktime : "+ workTime+ " \r\n");
		}
		return sum / jobs.length;
	}

	public static void main(String[] args) {
		DiskController dc = new DiskController();

		int[][] jobs = new int[][] { { 0, 3 }, { 1, 9 }, { 2, 6 } };
		int expected = 9;
		System.out.printf("expected : %d  actual : %d   \r\n", expected, dc.solution(jobs));

		jobs = new int[][] { { 0, 9 }, { 0, 4 }, { 0, 5 }, { 0, 7 }, { 0, 3 } };
		expected = 13;
		System.out.printf("expected : %d  actual : %d   \r\n", expected, dc.solution(jobs));

		jobs = new int[][] { { 0, 3 }, { 4, 3 }, { 10, 3 } };
		expected = 3;
		System.out.printf("expected : %d  actual : %d   \r\n", expected, dc.solution(jobs));
		jobs = new int[][] { { 0, 10 }, { 2, 3 }, { 9, 3 } };
		expected = 9;
		System.out.printf("expected : %d  actual : %d   \r\n", expected, dc.solution(jobs));
		jobs = new int[][] { { 1, 10 }, { 3, 3 }, { 10, 3 } };
		expected = 9;
		System.out.printf("expected : %d  actual : %d   \r\n", expected, dc.solution(jobs));
		jobs = new int[][] { { 0, 10 } };
		expected = 10;
		System.out.printf("expected : %d  actual : %d   \r\n", expected, dc.solution(jobs));
		jobs = new int[][] { { 0, 10 }, { 4, 10 }, { 5, 11 }, { 15, 2 } };
		expected = 15;
		System.out.printf("expected : %d  actual : %d   \r\n", expected, dc.solution(jobs));
		jobs = new int[][] { { 0, 1 }, { 1, 2 }, { 500, 6 } };
		expected = 3;
		System.out.printf("expected : %d  actual : %d   \r\n", expected, dc.solution(jobs));
		jobs = new int[][] { { 0, 9 }, { 0, 4 }, { 0, 5 }, { 0, 7 }, { 0, 3 } };
		expected = 13;
		System.out.printf("expected : %d  actual : %d   \r\n", expected, dc.solution(jobs));
		jobs = new int[][] { { 0, 5 }, { 1, 2 }, { 5, 5 } };
		expected = 6;
		System.out.printf("expected : %d  actual : %d   \r\n", expected, dc.solution(jobs));
		jobs = new int[][]  {{0, 3}, {1, 9}, {2, 6}, {4, 3}};
		expected = 9;
		System.out.printf("expected : %d  actual : %d   \r\n", expected, dc.solution(jobs));
		jobs = new int[][]  {{24, 10}, {28, 39}, {43, 20}, {37, 5}, {47, 22}, {20, 47}, {15, 34}, {15, 2}, {35, 43}, {26, 1}};
		expected = 72;
		System.out.printf("expected : %d  actual : %d   \r\n", expected, dc.solution(jobs));

	}

}
