package amy.Algorithm.BaekJoon.sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

import javax.script.ScriptException;

/**
 * 문제 수 N개 A1, A2, ..., AN이 주어진다. A를 오름차순 정렬했을 때, 앞에서부터 K번째 있는 수를 구하는 프로그램을
 * 작성하시오.
 * 
 *  A를 오름차순 정렬
 *  K번째 있는 수
 *  문제 수 1 ≤ N ≤ 5,000,000
 *  K 1 ≤ K ≤ N
 * 
 * 입력 첫째 줄에 N(1 ≤ N ≤ 5,000,000)과 K (1 ≤ K ≤ N)이 주어진다.
 * 
 * 둘째에는 A1, A2, ..., AN이 주어진다. (-109 ≤ Ai ≤ 109)
 * 
 * 출력 A를 정렬했을 때, 앞에서부터 K번째 있는 수를 출력한다.
 * 
 * @author "Amy"
 *
 */
public class KthNumber {
	
	public int solution(int[] array, int k) {
		int kNum = -1;
		Arrays.sort(array);
		kNum = array[k-1];
		return kNum;
	}

	public static void main(String[] args) throws NumberFormatException, IOException, ScriptException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] inputs =br.readLine().split(" ");
		int n = Integer.parseInt(inputs[0]);
		int k = Integer.parseInt(inputs[1]);
		int[]  a = new int[n];        
		int i = 0;
		inputs = br.readLine().split(" ");
		while (i< n) {
			a[i] =Integer.parseInt( inputs[i]);
			i++;
		}
		KthNumber kn = new KthNumber();
		System.out.println(kn.solution(a, k));
		br.close();

	}

}
