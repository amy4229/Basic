package amy.pratice.Algorithm.BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * ���� #1874
 * ���� (stack)�� �⺻���� �ڷᱸ�� �� �ϳ���, ��ǻ�� ���α׷��� �ۼ��� �� ���� �̿�Ǵ� �����̴�. ������ �ڷḦ �ִ� (push)
 * �Ա��� �ڷḦ �̴� (pop) �Ա��� ���� ���� ���߿� �� �ڷᰡ ���� ���� ������ (LIFO, Last in First out)
 * Ư���� ������ �ִ�.
 * 
 * 1���� n������ ���� ���ÿ� �־��ٰ� �̾� �þ�������ν�, �ϳ��� ������ ���� �� �ִ�. �̶�, ���ÿ� push�ϴ� ������ �ݵ��
 * ���������� ��Ű���� �Ѵٰ� ����. ������ ������ �־����� �� ������ �̿��� �� ������ ���� �� �ִ��� ������, �ִٸ� � ������
 * push�� pop ������ �����ؾ� �ϴ����� �˾Ƴ� �� �ִ�. �̸� ����ϴ� ���α׷��� �ۼ��϶�.
 * 
 * @author amy
 *
 */

public class StackSequence {
	public static void solution(int[] input) {
		StringBuilder sb = new StringBuilder();
		boolean[] isPop = new boolean[input.length + 1];
		boolean isPossible = true;
		int lastpush = 0;
		int prep = 0;
		for (int i = 0; i < input.length; i++) {
			int j = input[i];
			if (prep < j) {
				if (j <= lastpush) {
					isPossible = false;
					break;
				}
				for (int k = lastpush; k < j; k++) {
					sb.append("+\r\n");
					lastpush++;
				}
				
			}
			if (prep > j) {
				if (isPop[j]) {
					isPossible = false;
					break;
				}
				for (int k = lastpush-1; k > j; k--) {
					if(!isPop[k])sb.append("-\n");
					isPop[k] = true;
				}
			}
			isPop[j] = true;
			sb.append("-\r\n");
			prep = j;
		}
		if (isPossible) {
			System.out.println(sb.toString());
		} else {
			System.out.println("NO");

		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] input = new int[n];
		for (int i = 0; i < n; i++) {
			input[i] = Integer.parseInt(br.readLine());
		}
		solution(input);

		br.close();

	}

}
