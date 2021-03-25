package amy.pratice.Algorithm.BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;

/**
 * ���� #1157
 * ���ĺ� ��ҹ��ڷ� �� �ܾ �־�����, �� �ܾ�� ���� ���� ���� ���ĺ��� �������� �˾Ƴ��� ���α׷��� �ۼ��Ͻÿ�. ��, �빮�ڿ� �ҹ��ڸ� �������� �ʴ´�.
 * @author "Amy"
 *
 */
public class MaxFinder {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] str =br.readLine().toUpperCase().toCharArray();
		Arrays.sort(str);
		String string = String.valueOf(str);
		HashSet<Character> letters = new HashSet<>();
		for(int i = 0; i<str.length;i++) {
			letters.add(str[i]);
		}
		int max = -1;
		char maxChar = ' '; 
		Iterator<Character> it = letters.iterator();
		while(it.hasNext()) {
			char c = it.next();
			int cnt = string.lastIndexOf(c)-string.indexOf(c)+1;
			if(max>-1 && cnt == max) {
				maxChar = '?';
			}
			if(max < cnt) {
				max = cnt;
				maxChar = c;				
			}
		}
		
		System.out.println(maxChar);
		br.close();
	}
}
