package amy.practice.Algorithm.BaekJoon.sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 백준 10814
 * 
 * 온라인 저지에 가입한 사람들의 나이와 이름이 가입한 순서대로 주어진다. 이때, 회원들을 나이가 증가하는 순으로, 나이가 같으면 먼저 가입한
 * 사람이 앞에 오는 순서로 정렬하는 프로그램을 작성하시오.
 * 
 * @author "Amy"
 *
 */
public class SortByAge {
	class Info implements Comparable<Info>{
		int key;
		String value;
		int idx;
		public Info(int key, String value, int idx) {
			super();
			this.key = key;
			this.value = value;
			this.idx = idx;
		}
		
		@Override
		public int compareTo(Info o) {
			return this.key-o.key==0 ? o.idx-this.idx : this.key-o.key ;
		}
	
	}
	
	public void solution2(String[] ori) {
		Arrays.sort(ori, new Comparator<String>() {
			public int compare(String p1, String p2) {
				int age1 = Integer.parseInt(p1.split(" ")[0]);
				int age2 = Integer.parseInt(p2.split(" ")[0]);
				return age1-age2;
			}
		});
		Arrays.stream(ori).forEach(System.out::println);
	}
	
	public void solution(String[] ori) {
		PriorityQueue<Info> infos = new PriorityQueue<SortByAge.Info>();
		for(int i = 0 ; i < ori.length; i++) {
			int key = Integer.parseInt(ori[i].split(" ")[0]);
			infos.add(new Info(key, ori[i],i));
		}
		while(!infos.isEmpty()) {
			System.out.println(infos.poll().value);
		}
	}
	

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int num = Integer.parseInt(br.readLine().trim());
		String[] infos = new String[num];
		while(num>0) {
			String info =br.readLine();
			infos[num-1] = info;
			num--;
		}
		System.out.println();
		new SortByAge().solution(infos);
		br.close();

	}

}
