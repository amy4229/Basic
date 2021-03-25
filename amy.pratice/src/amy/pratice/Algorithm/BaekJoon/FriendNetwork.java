package amy.pratice.Algorithm.BaekJoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * ����4195�� - ģ�� ��Ʈ��ũ
 * ���� �����̴� �Ҽ� ��Ʈ��ũ ����Ʈ���� ģ���� ����� ���� �����ϴ� ģ���̴�. ��ǥ�� ������ ��̰� �ֵ���, �����̴� �Ҽ� ��Ʈ��ũ
 * ����Ʈ���� ģ���� ������ ���� ����̴�.
 * 
 * � ����Ʈ�� ģ�� ���谡 ���� ������� �־����� ��, �� ����� ģ�� ��Ʈ��ũ�� �� ���� �ִ��� ���ϴ� ���α׷��� �ۼ��Ͻÿ�.
 * 
 * ģ�� ��Ʈ��ũ�� ģ�� ���踸���� �̵��� �� �ִ� ���̸� ���Ѵ�.
 * 
 * �Է� ù° �ٿ� �׽�Ʈ ���̽��� ������ �־�����. �� �׽�Ʈ ���̽��� ù° �ٿ��� ģ�� ������ �� F�� �־�����, �� ���� 100,000��
 * ���� �ʴ´�. ���� F���� �ٿ��� ģ�� ���谡 ���� ������� �־�����. ģ�� ����� �� ������� ���̵�� �̷���� ������, ���ĺ� �빮��
 * �Ǵ� �ҹ��ڷθ� �̷���� ���� 20 ������ ���ڿ��̴�.
 * 
 * ��� ģ�� ���谡 ���� ������, �� ����� ģ�� ��Ʈ��ũ�� �� ���� �ִ��� ���ϴ� ���α׷��� �ۼ��Ͻÿ�.
 */

public class FriendNetwork {
	// ģ��-�׷�
	public HashMap<String, String> personalG = new HashMap<>();
	// �׷��� �ο��� �θ�-�ο���
	public HashMap<String, HashSet<String>> fGroup = new HashMap<>();

	public void solution(String[] friendNetwork) {
		for (int i = 0; i < friendNetwork.length; i++) {
			String[] relation = friendNetwork[i].split(" ");
			String f1 = relation[0];
			String f2 = relation[1];
			String parent = findGroup(f1, f2);
			System.out.println(fGroup.get(parent).size());
		}

	}

	/**
	 * ���ڿ� ���� ������ �θ� �Ǵ�
	 */
	public String findGroup(String f1, String f2) {

		boolean hasParent = false;
		String parent = "";
		if (personalG.containsKey(f1)) {
			hasParent = true;
			parent = personalG.get(f1);
		}
		if (personalG.containsKey(f2)) {
			if (hasParent && !parent.equals(personalG.get(f2))) {
				parent = unionGroup(parent, personalG.get(f2));
			} else {
				parent = personalG.get(f2);
				hasParent = true;
			}
		}
		if (!hasParent) {
			parent = f1.compareTo(f2) > 0 ? f1 : f2;
		}
		personalG.put(f1, parent);
		personalG.put(f2, parent);
		if (fGroup.get(parent) == null) {
			fGroup.put(parent, new HashSet<>());
		}
		fGroup.get(parent).add(f1);
		fGroup.get(parent).add(f2);
		return parent;

	}

	private String unionGroup(String parent1, String parent2) {

		String parent = parent2;
		String child = parent1;
		if (parent1.compareTo(parent2) > 0) {
			parent = parent1;
			child = parent2;
		}

		Set<String> target = fGroup.get(child);
		if (target != null) {
			fGroup.get(parent).addAll(target);

			Iterator<String> it = target.iterator();
			while (it.hasNext()) {
				personalG.put(it.next(), parent);
			}
			fGroup.remove(child);
		}
		return parent;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testCase = Integer.parseInt(br.readLine());
		while (testCase > 0) {
			int F = Integer.parseInt(br.readLine());
			String[] friendNetwork = new String[F];
			int i = 0;
			while (i < F) {
				friendNetwork[i] = br.readLine();
				i++;
			}
			new FriendNetwork().solution(friendNetwork);
			testCase--;
		}
		br.close();

	}
}
