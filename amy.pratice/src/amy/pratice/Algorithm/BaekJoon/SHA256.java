package amy.pratice.Algorithm.BaekJoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.security.MessageDigest;
import java.util.stream.Stream;

/**
 * 백준 #10930
 * 문자열 S가 주어졌을 때, SHA-256 해시값을 구하는 프로그램을 작성하시오.
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
