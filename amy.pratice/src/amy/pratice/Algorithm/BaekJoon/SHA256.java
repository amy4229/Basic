package amy.pratice.Algorithm.BaekJoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.security.MessageDigest;
import java.util.stream.Stream;

/**
 * ���� #10930
 * ���ڿ� S�� �־����� ��, SHA-256 �ؽð��� ���ϴ� ���α׷��� �ۼ��Ͻÿ�.
 * @author amy
 *
 */
public class SHA256 {

	public static String solution(String input) throws Exception {
		MessageDigest digest = MessageDigest.getInstance("SHA-256");
		byte[] digested = digest.digest();
		StringBuilder sb = new StringBuilder();
		Stream.of(digested).forEach(d->sb.append(d));
		return sb.toString();
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		System.out.println(solution(input));
		br.close();

	}

}
