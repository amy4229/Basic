package amy.practice.Algorithm.School.Search;

import java.util.Arrays;

public abstract class AbstractSearch {
protected String searchName = null;
	
	
	/**
	 * 탐색
	 * 
	 * 원하는 탐색대상이 데이터에 존재할경우 해당 값이 있는 인덱스를 반환 
	 * 탐색대상이 존재하지 않을경우 -1을 반환
	 * 
	 * @param array 탐색데이터
	 * @param search 탐색대상
	 * @param searchName 탐색알고리즘 이름
	 * @return 탐색대상의 인덱스
	 */
	public final int search (int[] array, int search, String searchName, int expected) {
		this.searchName= searchName;
		long start = System.nanoTime();
		int result = searchProcess(array,search);
		long end = System.nanoTime();
		System.out.printf("%s  탐색처리시간 : %d나노초 \t  탐색데이터 : %s, 탐색키워드 : %s  예상결과: %s 결과: %s \r\n",searchName,  (end-start), Arrays.toString(array), search,expected, result);
		return result;
	}
	
	protected abstract int searchProcess (int[] array, int search);
}
