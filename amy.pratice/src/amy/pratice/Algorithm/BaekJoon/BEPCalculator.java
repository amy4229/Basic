package amy.pratice.Algorithm.BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * ���� #1712
 * �������ڴ� ��Ʈ���� �����ϰ� �Ǹ��ϴ� ȸ���̴�. ��Ʈ�� �Ǹ� ����� ������� �ų� �Ӵ��, ��꼼, �����, �޿� �� A������ ���� ����� ���, �� ���� ��Ʈ���� �����ϴ� ������ ����� �ΰǺ� �� �� B������ ���� ����� ��ٰ� �Ѵ�.
 * ���� ��� A=1,000, B=70�̶�� ����. �� ��� ��Ʈ���� �� �� �����ϴ� ���� �� 1,070������ ���, �� �� �����ϴ� ���� �� 1,700������ ���.
 * ��Ʈ�� ������ C�������� å���Ǿ��ٰ� �Ѵ�. �Ϲ������� ���� ����� �÷� ���� ���� ��� ���� �� ����(�Ǹź��)�� �� ���(=�������+�������)���� �������� �ȴ�. ���ʷ� �� ������ �� ��뺸�� ������ ������ �߻��ϴ� ������ ���ͺб���(BREAK-EVEN POINT)�̶�� �Ѵ�.
 * A, B, C�� �־����� ��, ���ͺб����� ���ϴ� ���α׷��� �ۼ��Ͻÿ�.
 * @author "Amy"
 *
 */
public class BEPCalculator {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] info = br.readLine().split(" ");
		double fixed = Integer.parseInt(info[0]);
		double perCost = Integer.parseInt(info[1]);
		double price = Integer.parseInt(info[2]);
		if(price <= perCost) {
			System.out.println(-1);
		}else {
			double n =fixed/(price-perCost);
			System.out.println((int)n+1);
		}
		
	}
}
