package amy.pratice.Algorithm.BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 백준 #1904
 * 
 * @author "Amy"
 * 
 *         01타일
 * 
 *         지원이에게 2진 수열을 가르쳐 주기 위해, 지원이 아버지는 그에게 타일들을 선물해주셨다. 그리고 이 각각의 타일들은 0 또는
 *         1이 쓰여 있는 낱장의 타일들이다. 어느 날 짓궂은 동주가 지원이의 공부를 방해하기 위해 0이 쓰여진 낱장의 타일들을 붙여서
 *         한 쌍으로 이루어진 00 타일들을 만들었다. 결국 현재 1 하나만으로 이루어진 타일 또는 0타일을 두 개 붙인 한 쌍의
 *         00타일들만이 남게 되었다. 그러므로 지원이는 타일로 더 이상 크기가 N인 모든 2진 수열을 만들 수 없게 되었다. 예를
 *         들어, N=1일 때 1만 만들 수 있고, N=2일 때는 00, 11을 만들 수 있다. (01, 10은 만들 수 없게
 *         되었다.) 또한 N=4일 때는 0011, 0000, 1001, 1100, 1111 등 총 5개의 2진 수열을 만들 수 있다.
 *         우리의 목표는 N이 주어졌을 때 지원이가 만들 수 있는 모든 가짓수를 세는 것이다. 단 타일들은 무한히 많은 것으로
 *         가정하자.
 *
 */
public class Tile01 {
	int[] cnts; 
	public int countTile(int n) {
		
		for(int i = 0;  i <=n; i++) {
			if(i<3) {
				cnts[i] =i;
			}else {
				cnts[i] = (cnts[i-1]+cnts[i-2])% 15746;
			}
		}
		return cnts[n] ;
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		Tile01 t01 = new Tile01();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		t01.cnts = new int[n+1];
		System.out.println(t01.countTile(n));
	}
}
