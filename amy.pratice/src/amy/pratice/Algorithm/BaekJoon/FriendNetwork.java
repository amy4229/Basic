package amy.pratice.Algorithm.BaekJoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * 백준4195번 - 친구 네트워크
 * 문제 민혁이는 소셜 네트워크 사이트에서 친구를 만드는 것을 좋아하는 친구이다. 우표를 모으는 취미가 있듯이, 민혁이는 소셜 네트워크
 * 사이트에서 친구를 모으는 것이 취미이다.
 * 
 * 어떤 사이트의 친구 관계가 생긴 순서대로 주어졌을 때, 두 사람의 친구 네트워크에 몇 명이 있는지 구하는 프로그램을 작성하시오.
 * 
 * 친구 네트워크란 친구 관계만으로 이동할 수 있는 사이를 말한다.
 * 
 * 입력 첫째 줄에 테스트 케이스의 개수가 주어진다. 각 테스트 케이스의 첫째 줄에는 친구 관계의 수 F가 주어지며, 이 값은 100,000을
 * 넘지 않는다. 다음 F개의 줄에는 친구 관계가 생긴 순서대로 주어진다. 친구 관계는 두 사용자의 아이디로 이루어져 있으며, 알파벳 대문자
 * 또는 소문자로만 이루어진 길이 20 이하의 문자열이다.
 * 
 * 출력 친구 관계가 생길 때마다, 두 사람의 친구 네트워크에 몇 명이 있는지 구하는 프로그램을 작성하시오.
 */

public class FriendNetwork {
	// 친구-그룹
	public HashMap<String, String> personalG = new HashMap<>();
	// 그룹의 인원수 부모-인원수
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
	 * 문자열 정렬 순으로 부모 판단
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
