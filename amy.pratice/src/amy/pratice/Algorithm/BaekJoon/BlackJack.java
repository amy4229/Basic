package amy.pratice.Algorithm.BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * #백준 2798
 * 카지노에서 제일 인기 있는 게임 블랙잭의 규칙은 상당히 쉽다. 카드의 합이 21을 넘지 않는 한도 내에서, 카드의 합을 최대한 크게 만드는
 * 게임이다. 블랙잭은 카지노마다 다양한 규정이 있다.
 * 
 * 한국 최고의 블랙잭 고수 김정인은 새로운 블랙잭 규칙을 만들어 상근, 창영이와 게임하려고 한다.
 * 
 * 김정인 버전의 블랙잭에서 각 카드에는 양의 정수가 쓰여 있다. 그 다음, 딜러는 N장의 카드를 모두 숫자가 보이도록 바닥에 놓는다. 그런
 * 후에 딜러는 숫자 M을 크게 외친다.
 * 
 * 이제 플레이어는 제한된 시간 안에 N장의 카드 중에서 3장의 카드를 골라야 한다. 블랙잭 변형 게임이기 때문에, 플레이어가 고른 카드의
 * 합은 M을 넘지 않으면서 M과 최대한 가깝게 만들어야 한다.
 * 
 * N장의 카드에 써져 있는 숫자가 주어졌을 때, M을 넘지 않으면서 M에 최대한 가까운 카드 3장의 합을 구해 출력하시오.
 */
public class BlackJack {
	
	public static int dealBlackJack(String input1, String input2) {
		int result = 0;
		int n = Integer.parseInt(input1.split(" ")[0]);
		int m = Integer.parseInt(input1.split(" ")[1]);
		String[ ] seperated = input2.split(" ");
		ArrayList<Integer> cards = new ArrayList<>();
		Arrays.stream(seperated).map(Integer::parseInt).forEach((c)->cards.add(c));
		for(int i = 0; i < n-2; i++) {
			for(int j = i+1; j < n-1; j++ ) {
				for(int k = j+1; k<n; k++) {
					int sum = cards.get(i)+ cards.get(j)+cards.get(k);
					if(sum <= m) {
						result = Math.max(result, sum);
					}
				}
			}
		}
		
		return result;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input1 = br.readLine();
		String input2 = br.readLine();
		System.out.println(dealBlackJack(input1, input2));
		
		br.close();
		
		
	}

}
