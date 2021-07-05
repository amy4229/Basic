package amy.Algorithm.BaekJoon.recursive;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

/**
 * 문제 1부터 N까지의 수를 오름차순으로 쓴 수열 1 2 3 ... N을 생각하자.
 * 
 * 그리고 '+'나 '-', 또는 ' '(공백)을 숫자 사이에 삽입하자(+는 더하기, -는 빼기, 공백은 숫자를 이어 붙이는 것을 뜻한다).
 * 이렇게 만든 수식의 값을 계산하고 그 결과가 0이 될 수 있는지를 살피자.
 * 
 * N이 주어졌을 때 수식의 결과가 0이 되는 모든 수식을 찾는 프로그램을 작성하라.
 * 
 * 입력 첫 번째 줄에 테스트 케이스의 개수가 주어진다(<10).
 * 
 * 각 테스트 케이스엔 자연수 N이 주어진다(3 <= N <= 9).
 * 
 * 출력 각 테스트 케이스에 대해 ASCII 순서에 따라 결과가 0이 되는 모든 수식을 출력한다. 각 테스트 케이스의 결과는 한 줄을 띄워
 * 구분한다.
 * 
 * @author "Amy"
 *
 */
public class MakeZero {
	
	public static StringBuilder zero = new StringBuilder(); 

	public void solution(int num, String expression)  throws ScriptException {
		StringBuilder sb = new StringBuilder(expression);
		if(num == 1) {
			ScriptEngineManager mgt = new ScriptEngineManager();
			ScriptEngine eg = mgt.getEngineByName("JavaScript");
			int result =(int) eg.eval(sb.insert(0, num).toString().replace(" ",""));
			System.out.println(sb.toString()+" "+result);
			if(result == 0) {
				zero.append(sb.append("\n").toString());
			}
			return;
		}
		solution(num-1, sb.insert(0,num).insert(0, "+").toString());
		sb.delete(0, 1);
		solution(num-1, sb.insert(0, "-").toString());
		sb.delete(0, 1);
		solution(num-1, sb.insert(0, " ").toString());
		
	}

	public static void main(String[] args) throws NumberFormatException, IOException, ScriptException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		while (n > 0) {
			zero.append("\n");
			int num = Integer.parseInt(br.readLine());
			new MakeZero().solution(num, "");
			n--;
		}
		System.out.println(zero.toString());
		br.close();
		
		

	}

}
