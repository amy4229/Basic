package amy.practice.Algorithm.School;

import java.util.Arrays;

/**
 * 동적프로그래밍2
 * 문자열편집거리구하기
 * @author "Amy"
 *
 */
public class StringEditDistance {

	/**
	 * 문자열 편집거리 계산배열
	 */
	public int[][] stdArray;

	/**
	 * a->b로 바꿀 때 문자열 편집거리 구하는 메소드
	 * @param a 문자열 a 
	 * @param b 문자열 b 
	 * @param ins 삽입비용
	 * @param del 삭제비용
	 * @param chg 변경비용
	 * @return 최소편집거리
	 */
	public int getSED(String a, String b, int ins, int del, int chg) {
		//편집거리
		int sed = 0;
		//첫 행초기화
		for(int i = 1; i < stdArray[0].length; i++) {
			stdArray[0][i] = stdArray[0][i-1]+ins;	
		}
		//첫 열 초기화
		for(int j = 1; j < stdArray.length; j++) {
			stdArray[j][0] = stdArray[j-1][0]+del;	
		}
		//나머지칸 비우기
		for(int n = 1; n <stdArray.length;n++) {
			for(int m = 1; m < stdArray[0].length; m++) {
				int calc = a.charAt(n-1)==b.charAt(m-1) ? 0:chg;
				stdArray[n][m]= Math.min(Math.min(stdArray[n][m-1]+del, stdArray[n-1][m]+ins),stdArray[n-1][m-1]+calc);
			}
		}
		sed = stdArray[a.length()][b.length()];
		//편집경로 표 출력하기 위한 코드 결과도출과 무관
		for(int n = 0; n <stdArray.length;n++) {
			System.out.println(Arrays.toString(stdArray[n]));
		};
		return sed;
	}

	public static void main(String[] args) {
		StringEditDistance s = new StringEditDistance();
		String a = "SNOWY";
		String b = "SUNNY";
		int ins = 1;
		int del =1;
		int chg = 2;
		int expected = 4;
		s.stdArray = new int[a.length() + 1][b.length() +1];
		System.out.println("a: " + a + " b: " + b + " expected : " + expected);
		System.out.println("actual :" + s.getSED(a, b,ins,del,chg));
		
		String a2 = "bbabb";
		String b2 = "abaa";
		int ins2 = 1;
		int del2 =1;
		int chg2= 2;
		int expected2 = 5;
		s.stdArray = new int[a2.length() + 1][b2.length() +1];
		System.out.println("a2: " + a2 + " b2: " + b2 + " expected2 : " + expected2);
		System.out.println("actual2 :" + s.getSED(a2, b2,ins2,del2,chg2));

	}

}
