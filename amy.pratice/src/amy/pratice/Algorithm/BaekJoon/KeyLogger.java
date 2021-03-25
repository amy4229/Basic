package amy.pratice.Algorithm.BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.stream.Stream;

/**
 * ����#5397
 * â���̴� �������� ��й�ȣ�� ��ġ�� ���ؼ� �����̰� ����ϴ� ��ǻ�Ϳ� Ű�ΰŸ� ��ġ�ߴ�. ��ĥ�� ��ٸ� ���� â���̴� �����̰� ��й�ȣ
 * â�� �Է��ϴ� ���ڸ� ���´�.
 * 
 * Ű�ΰŴ� ����ڰ� Ű���带 ���� ����� ��� ����Ѵ�. ����, �����̰� ��й�ȣ�� �Է��� ��, ȭ��ǥ�� �齺���̽��� �Է��ص� ��Ȯ��
 * ��й�ȣ�� �˾Ƴ� �� �ִ�.
 * 
 * �����̰� ��й�ȣ â���� �Է��� Ű�� �־����� ��, �������� ��й�ȣ�� �˾Ƴ��� ���α׷��� �ۼ��Ͻÿ�.
 * 
 * ù° �ٿ� �׽�Ʈ ���̽��� ������ �־�����. �� �׽�Ʈ ���̽��� ���ٷ� �̷���� �ְ�, �����̰� �Է��� ������� ���̰� L�� ���ڿ���
 * �־�����. (1 �� L�� ���� �� 1,000,000) �����̰� �齺���̽��� �Է��ߴٸ�, '-'�� �־�����. �̶� Ŀ���� �ٷ� �տ� ���ڰ�
 * �����Ѵٸ�, �� ���ڸ� �����. ȭ��ǥ�� �Է��� '<'�� '>'�� �־�����. �̶��� Ŀ���� ��ġ�� ������ �� �ִٸ�, ���� �Ǵ� ����������
 * 1��ŭ �����δ�. ������ ���ڴ� ��й�ȣ�� �Ϻ��̴�. ����, ���߿� �齺���̽��� ���ؼ� ���� ���� �ִ�. ���� Ŀ���� ��ġ�� ���� ��������
 * �ƴ϶��, Ŀ�� �� Ŀ�� �����ʿ� �ִ� ��� ���ڴ� ���������� �� ĭ �̵��Ѵ�.
 */
public class KeyLogger {
	public static String solution(String input) {
		StringBuilder result = new StringBuilder();
		Stack<Character> temp = new Stack<>();
		Stack<Character> move = new Stack<>();
		for (int i = 0; i < input.length(); i++) {
			char letter = input.charAt(i);
			if (letter == '<') {
				if (!temp.isEmpty()) {
					move.push(temp.pop());
				}
			} else if (letter == '>') {
				if (!move.isEmpty()) {
					temp.push(move.pop());
				}
			} else if (letter == '-') {
				if (!temp.isEmpty()) {
					temp.pop();
				}
			} else {
				temp.push(letter);
			}
		}
		while (!move.isEmpty()) {
			temp.push(move.pop());
		}

		temp.forEach(c -> result.append(c));

		return result.toString();
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		String[] result = new String[n];
		for (int i = 0; i < n; i++) {
			String input = br.readLine();
			result[i] = solution(input);
		}
		Stream.of(result).forEach(System.out::println);

		br.close();

	}
}
