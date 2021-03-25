package amy.pratice.Algorithm.BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.stream.IntStream;

/**
 * ����#1966
 * �����е� �˴ٽ��� �������� ������ ���� �������� �μ��ϰ��� �ϴ� ������ �μ� ����� ���� ��������Ρ�, �� ���� ��û�� ���� ����
 * �μ��Ѵ�. ���� ���� ������ ���δٸ� Queue �ڷᱸ���� �׿��� FIFO - First In First Out - �� ���� �μⰡ �ǰ�
 * �ȴ�. ������ ����̴� ���ο� �����ͱ� ���� ����Ʈ��� �����Ͽ��µ�, �� �����ͱ�� ������ ���� ���ǿ� ���� �μ⸦ �ϰ� �ȴ�.
 * 
 * ���� Queue�� ���� �տ� �ִ� ������ ���߿䵵���� Ȯ���Ѵ�. ������ ������ �� ���� �������� �߿䵵�� ���� ������ �ϳ��� �ִٸ�, ��
 * ������ �μ����� �ʰ� Queue�� ���� �ڿ� ���ġ �Ѵ�. �׷��� �ʴٸ� �ٷ� �μ⸦ �Ѵ�. ���� ��� Queue�� 4���� ����(A B C
 * D)�� �ְ�, �߿䵵�� 2 1 4 3 ��� C�� �μ��ϰ�, �������� D�� �μ��ϰ� A, B�� �μ��ϰ� �ȴ�.
 * 
 * �������� �� ����, ���� Queue�� �ִ� ������ ���� �߿䵵�� �־����� ��, � �� ������ �� ��°�� �μ�Ǵ��� �˾Ƴ��� ���̴�. ����
 * ��� ���� ������ C������ 1��°��, A������ 3��°�� �μ�ǰ� �ȴ�. ù �ٿ� �׽�Ʈ���̽��� ���� �־�����. �� �׽�Ʈ���̽��� �� �ٷ�
 * �̷���� �ִ�.
 * 
 * �׽�Ʈ���̽��� ù ��° �ٿ��� ������ ���� N(1 �� N �� 100)��, �� ��°�� �μ�Ǿ����� �ñ��� ������ ���� Queue���� ��
 * ��°�� ���� �ִ����� ��Ÿ���� ���� M(0 �� M < N)�� �־�����. �̶� �� ������ 0��°��� ����. �� ��° �ٿ��� N�� ������
 * �߿䵵�� ���ʴ�� �־�����. �߿䵵�� 1 �̻� 9 ������ �����̰�, �߿䵵�� ���� ������ ���� �� ���� ���� �ִ�.
 */
public class PrinterQueue {
	public static int solution(int docuNum, int[] reserve) {
		int result = 1;
		Queue<Integer> q = IntStream.range(0, reserve.length).collect(LinkedList::new, (list,item)->list.add(item), LinkedList::addAll);
		int[] sortedPriority =IntStream.of(reserve).boxed().sorted(Collections.reverseOrder()).mapToInt(Integer::intValue).toArray();
		for(int i = 0; i<sortedPriority.length; i++) {
			while(true) {
				if(sortedPriority[i]==reserve[q.peek()]){
					if(q.poll()==docuNum) {
						return result;
					};
					result++;
					break;
				}else {
					q.add(q.poll());
				}
			}
		}
		
		return result;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int caseNo = Integer.parseInt(br.readLine());
		

		for (int i = 0; i < caseNo; i++) {
			String[] firstLine = br.readLine().split(" ");
			int n =Integer.parseInt(firstLine[0]); 
			int docuNum = Integer.parseInt(firstLine[1]);
			String[] secondLine = br.readLine().split(" ");
			int[] reserve = new int[n];
			for(int j = 0; j<n; j++) {
				reserve[j] = Integer.parseInt(secondLine[j]);
			}
			System.out.println(solution(docuNum, reserve));
		}

		br.close();

	}
}
