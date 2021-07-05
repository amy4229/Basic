package amy.Algorithm.BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;

/**
 * 백준 #1157
 * 알파벳 대소문자로 된 단어가 주어지면, 이 단어에서 가장 많이 사용된 알파벳이 무엇인지 알아내는 프로그램을 작성하시오. 단, 대문자와 소문자를 구분하지 않는다.
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
