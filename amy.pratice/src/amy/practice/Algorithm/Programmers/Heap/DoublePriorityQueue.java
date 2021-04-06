package amy.practice.Algorithm.Programmers.Heap;

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

/**
 * 이중우선순위큐
 * 
 * 
 * 이중 우선순위 큐가 할 연산 operations가 매개변수로 주어질 때, 모든 연산을 처리한 후 큐가 비어있으면 [0,0] 비어있지 않으면
 * [최댓값, 최솟값]을 return 하도록 solution 함수를 구현해주세요.
 * 
 * operations는 길이가 1 이상 1,000,000 이하인 문자열 배열입니다. operations의 원소는 큐가 수행할 연산을
 * 나타냅니다. 원소는 “명령어 데이터” 형식으로 주어집니다.- 최댓값/최솟값을 삭제하는 연산에서 최댓값/최솟값이 둘 이상인 경우, 하나만
 * 삭제합니다. 빈 큐에 데이터를 삭제하라는 연산이 주어질 경우, 해당 연산은 무시합니다.
 * 
 * I 숫자 큐에 주어진 숫자를 삽입합니다. * D 1 큐에서 최댓값을 삭제합니다. * D -1 큐에서 최솟값을 삭제합니다.
 * 
 * @author "Amy"
 *
 */
public class DoublePriorityQueue {

	public int[] solution(String[] operations) {
		int[] answer = new int[2];
		PriorityQueue<Integer> q = new PriorityQueue<>();
		PriorityQueue<Integer> rq = new PriorityQueue<>(Collections.reverseOrder());
		int i = 0;
		int size = 0;
		while (i < operations.length) {
			String[] operation = operations[i].split(" ");
			String order = operation[0];
			int no = Integer.parseInt(operation[1]);
			switch (order) {
			case "I":
				q.add(no);
				rq.add(no);
				size ++;
				break;
			case "D":
				if(size>0) {
					if (no > 0) {
						rq.poll();
					}else {
						q.poll();
					}
					size--;
					break;
				}
			}
			i++;
		}
		
		if(size !=0) {
			int max = rq.poll();
			while(!q.contains(max)) {
				max = rq.poll();
			}
			int min = q.poll();
			while(!rq.contains(min)) {
				min = q.poll();
			}
			answer [0] = max;
			answer[1] = min;
		}
		return answer;
	}

	public static void main(String[] args) {
		DoublePriorityQueue dpq = new DoublePriorityQueue();
		String[] operations;
		String expected;
		operations = new String[] { "I 16", "D 1" };
		expected = "[0,0]";
		System.out.println("expected : " + expected + " actual: " + Arrays.toString(dpq.solution(operations)));
		operations = new String[] { "I 7", "I 5", "I -5", "D -1" };
		expected = "[7,5]";
		System.out.println("expected : " + expected + " actual: " + Arrays.toString(dpq.solution(operations)));
		
		operations = new String[] {"I 4", "I 3", "I 2", "I 1", "D 1", "D 1", "D -1", "D -1", "I 5", "I 6"};
		expected = "[6,5]";
		System.out.println("expected : " + expected + " actual: " + Arrays.toString(dpq.solution(operations)));

	}

}
