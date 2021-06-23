package amy.Algorithm.DFSBFS;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 프로그래머스 _ 타겟넘버
 * 
 * n개의 음이 아닌 정수가 있습니다. 이 수를 적절히 더하거나 빼서 타겟 넘버를 만들려고 합니다.
 * 
 * 사용할 수 있는 숫자가 담긴 배열 numbers, 타겟 넘버 target이 매개변수로 주어질 때 숫자를 적절히 더하고 빼서 타겟 넘버를
 * 만드는 방법의 수를 return 하도록 solution 함수를 작성해주세요.
 * 
 * @author "Amy"
 *
 */
public class TargetNumber {
	public int solution(int[] numbers, int target) {
        int answer = 0;
        int start = 0;
        Queue<Integer> s = new LinkedList<>();
        s.add(start);
        int i = 0;
        int level =0;
        int twoNumbering = 1;
        while(level < numbers.length) {
        	int now= s.poll();
        	s.add(now+numbers[level]);
        	s.add(now-numbers[level]);
        	i++;
        	if(i == twoNumbering ) {
        		twoNumbering *= 2;
        		i = 0;
        		level++;
        	}
        }
        answer =  (int) s.stream().filter(k-> k == target).count();
      
        return answer;
    }
	
	public static void main(String[] args) {
		TargetNumber t = new TargetNumber();
		
		int[] numbers= {1, 1, 1, 1, 1};
		 int target =3;
		 
		 System.out.println("expected = 5  actual "+t.solution(numbers, target));
		
	}

}
