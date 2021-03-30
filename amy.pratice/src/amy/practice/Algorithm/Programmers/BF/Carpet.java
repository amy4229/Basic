package amy.practice.Algorithm.Programmers.BF;

import java.util.Arrays;

/**
 * 카펫
 * 
 * Leo는 카펫을 사러 갔다가 아래 그림과 같이 중앙에는 노란색으로 칠해져 있고 테두리 1줄은 갈색으로 칠해져 있는 격자 모양 카펫을
 * 봤습니다. Leo는 집으로 돌아와서 아까 본 카펫의 노란색과 갈색으로 색칠된 격자의 개수는 기억했지만, 전체 카펫의 크기는 기억하지
 * 못했습니다.
 * 
 * Leo가 본 카펫에서 갈색 격자의 수 brown, 노란색 격자의 수 yellow가 매개변수로 주어질 때 카펫의 가로, 세로 크기를 순서대로
 * 배열에 담아 return 하도록 solution 함수를 작성해주세요.
 * 
 * @author "Amy"
 *
 */
public class Carpet {

	/**
	 * 카펫의 가로, 세로 크기를 순서대로 배열에 담아 return
	 * 
	 * @param brown  갈색 격자의 수
	 * @param yellow 노란색 격자의 수
	 * @return 카펫의 가로, 세로 크기순 배열 배열
	 */
	public int[] solution(int brown, int yellow) {
		int[] answer = new int[2];
		int i = 1;
		while(i<brown) {
			if (yellow % i == 0) {
				int y = i;
				int x = yellow / i;
				if ((x + 2) * (y + 2) == brown+yellow) {
					answer[0] = x+2;
					answer[1] =y+2;
					break;
				}
			}
			i++;
		}
		return answer;
	}

	public static void main(String[] args) {
		Carpet c = new Carpet();

		int brown = 10;
		int yellow = 2;
		System.out.printf("input : b=%d  Y=%d expected =[4,3]  actual: %s \r\n", brown, yellow,
				Arrays.toString(c.solution(brown, yellow)));

		brown = 8;
		yellow = 1;
		System.out.printf("input : b=%d  Y=%d expected =[3, 3] actual: %s \r\n", brown, yellow,
				Arrays.toString(c.solution(brown, yellow)));

		brown = 24;
		yellow = 24;
		System.out.printf("input : b=%d  Y=%d expected =[8, 6] actual: %s \r\n", brown, yellow,
				Arrays.toString(c.solution(brown, yellow)));
	}
}
