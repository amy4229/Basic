package amy.practice.Algorithm.Programmers.Greedy;

import java.util.HashSet;
import java.util.Set;

/**
 * 프로그래머스 완전탐색 
 * 소수 찾기 
 * 주어진 문자열을 조합하여 
 * 소수갯수 구하기
 * @author "Amy"
 *
 */
public class FindPrime {
	/**
	 * 소수 저장 셋
	 */
	Set<Integer> set;
	
	public int solution(String numbers) {
		set = new HashSet<>();
        int answer = 0;
        StringBuilder ori = new StringBuilder();
        makeNumber(ori, numbers);
        answer = set.size();
        System.out.println(set.toString());
        return answer;
    }
	
	/**
	 * 숫자조합
	 * @param ori 조합대상문자열
	 * @param remain 조합후보군
	 */
	private void makeNumber(StringBuilder ori, String remain) {
		if(remain.length()==0) return;
		for(int i =0; i<remain.length(); i++) {
			StringBuilder make = new StringBuilder(ori).append(remain.charAt(i));
			String nextRemain = new StringBuilder(remain).delete(i, i+1).toString();
			int newNo = Integer.parseInt(make.toString());
			if(isPrime(newNo)){
				set.add(newNo);
			}
			System.out.println(newNo);
			if(newNo!=0) {
				makeNumber(make, nextRemain);
			}
		}
		 
	}
	
	
	/**
	 * 소수여부판별
	 * @param num 판별하고자하는 숫자
	 * @return 소수여부
	 */
	private boolean isPrime(int num) {
		if(num ==1 ) return false;
		if(num == 2) return true;
		if(num%2==0) return false;
		for(int i = 3; i < num; i+=2) {
			if(num%i==0) return false;
		}
		return true;
	}
	
	public static void main(String[] args) {

		FindPrime fp = new FindPrime();
		String numbers  = "17";
		int expected =3 ;
		System.out.printf("expected : %d actual: %d \r\n",expected, fp.solution(numbers));
		numbers ="011";
		expected = 2;
		System.out.printf("expected : %d actual: %d \r\n",expected, fp.solution(numbers));
		

	}


}
