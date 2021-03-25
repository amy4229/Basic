package amy.pratice.Algorithm.BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * #���� 2798
 * ī���뿡�� ���� �α� �ִ� ���� ������ ��Ģ�� ����� ����. ī���� ���� 21�� ���� �ʴ� �ѵ� ������, ī���� ���� �ִ��� ũ�� �����
 * �����̴�. ������ ī���븶�� �پ��� ������ �ִ�.
 * 
 * �ѱ� �ְ��� ���� ��� �������� ���ο� ���� ��Ģ�� ����� ���, â���̿� �����Ϸ��� �Ѵ�.
 * 
 * ������ ������ ���迡�� �� ī�忡�� ���� ������ ���� �ִ�. �� ����, ������ N���� ī�带 ��� ���ڰ� ���̵��� �ٴڿ� ���´�. �׷�
 * �Ŀ� ������ ���� M�� ũ�� ��ģ��.
 * 
 * ���� �÷��̾�� ���ѵ� �ð� �ȿ� N���� ī�� �߿��� 3���� ī�带 ���� �Ѵ�. ���� ���� �����̱� ������, �÷��̾ �� ī����
 * ���� M�� ���� �����鼭 M�� �ִ��� ������ ������ �Ѵ�.
 * 
 * N���� ī�忡 ���� �ִ� ���ڰ� �־����� ��, M�� ���� �����鼭 M�� �ִ��� ����� ī�� 3���� ���� ���� ����Ͻÿ�.
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
