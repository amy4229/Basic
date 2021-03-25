package amy.pratice.Algorithm.BaekJoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * ����1920�� - �� ã��
 * N���� ���� A[1], A[2], ��, A[N]�� �־��� ���� ��, �� �ȿ� X��� ������ �����ϴ��� �˾Ƴ��� ���α׷��� �ۼ��Ͻÿ�.
 * 
 * @param ù° �ٿ� �ڿ��� N(1 �� N �� 100,000)�� �־�����. ���� �ٿ��� N���� ���� A[1], A[2], ��, A[N]��
 *           �־�����. ���� �ٿ��� M(1 �� M �� 100,000)�� �־�����. ���� �ٿ��� M���� ������ �־����µ�, �� ������
 *           A�ȿ� �����ϴ��� �˾Ƴ��� �ȴ�. ��� ������ ������ -231 ���� ũ�ų� ���� 231���� �۴�
 * @retrun M���� �ٿ� ���� ����Ѵ�. �����ϸ� 1��, �������� ������ 0�� ����Ѵ�.
 */
public class FindNumber {
	public static void solution(int[] input1, int[] input2 ) throws Exception {
		HashSet<Integer> set = new HashSet<>();
		IntStream.of(input1).boxed().forEach(n->set.add(n));
		for(int i = 0; i < input2.length;i++) {
			if(set.contains(input2[i])) {
				System.out.println(1);
			}else {
				System.out.println(0);
			}
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] input1 =Stream.of( br.readLine().split(" ")).mapToInt(b->Integer.parseInt(b)).toArray();
		int[] input2 =Stream.of( br.readLine().split(" ")).mapToInt(b->Integer.parseInt(b)).toArray();
		
		
		solution(input1,input2);
		br.close();

	}

}
