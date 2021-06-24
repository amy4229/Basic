package amy.Algorithm.DFSBFS;

import java.util.Arrays;
import java.util.stream.Stream;

/**
 * 프로그래머스 단어변환
 * 
 * 두 개의 단어 begin, target과 단어의 집합 words가 있습니다. 아래와 같은 규칙을 이용하여 begin에서 target으로
 * 변환하는 가장 짧은 변환 과정을 찾으려고 합니다.
 * 
 * 1. 한 번에 한 개의 알파벳만 바꿀 수 있습니다. 2. words에 있는 단어로만 변환할 수 있습니다. 예를 들어 begin이
 * "hit", target가 "cog", words가 ["hot","dot","dog","lot","log","cog"]라면
 *  "hit" -> "hot" -> "dot" -> "dog" -> "cog"와 같이 4단계를 거쳐 변환할 수 있습니다.
 * 
 * 두 개의 단어 begin, target과 단어의 집합 words가 매개변수로 주어질 때, 최소 몇 단계의 과정을 거쳐 begin을
 * target으로 변환할 수 있는지 return 하도록 solution 함수를 작성해주세요.
 * 
 * @author "Amy"
 *
 */
public class WordTransfer {
	
	public int result =Integer.MAX_VALUE;
	public int solution(String begin, String target,String[] words) {
        boolean[] used = new boolean[words.length];
        if(Stream.of(words).filter(w->w.equals(target)).count()==0) return 0;
        dfs(begin, target, used, words, 0);
        return result;
    }
	
	public void dfs(String begin, String target, boolean[] used, String[] words, int level) {
		System.out.println(begin);
		if(begin.equals(target)) {
			result = Math.min(result, level);
			System.out.println();
		}
		boolean[] used2 = Arrays.copyOf(used, used.length);
		for(int i =0; i < begin.length(); i++) {
			for(int j = 0; j <used.length; j++) {
				if(!used2[j]) {
					StringBuilder sbB = new StringBuilder(begin);
					StringBuilder sbT = new StringBuilder(words[j]);
					sbB.deleteCharAt(i);
					sbT.deleteCharAt(i);
					if(sbB.toString().equals(sbT.toString())) {
						used2[j] = true;
						dfs(words[j], target, used2, words, level+1);
						
					}
				}
			}
		}
		
	}

	public static void main(String[] args) {
		WordTransfer wt = new WordTransfer();
		 String begin ="hit";	
		 String target= "cog";
		 String[] words = new String[] {"hot", "dot", "dog", "lot", "log", "cog"};
		 int expected = 4;
		 System.out.printf("expected :%d acutal : %d\r\n",expected, wt.solution(begin, target, words));
		 
		 begin ="hit";
		 target="cog"	;
		 words = new String[] {"hot", "dot", "dog", "lot", "log"};
		 expected = 0;
		 System.out.printf("expected :%d acutal : %d\r\n",expected, wt.solution(begin, target, words));

	}

}
