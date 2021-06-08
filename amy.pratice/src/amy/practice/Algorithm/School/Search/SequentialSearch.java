package amy.practice.Algorithm.School.Search;

/**
 * 순차탐색 데이터를 하나하나 찾는 방법
 * 
 * @author "Amy"
 *
 */
public class SequentialSearch extends AbstractSearch {
	@Override
	protected int searchProcess(int[] array, int search) {
		for(int i = 0;  i < array.length; i++ ) {
			if(array[i] == search) {
				return i;
			}
		}
		
		return -1;
	}

	public static void main(String[] args) {
		SequentialSearch s = new SequentialSearch();
		int[] array = new int[] {70,20,30,50,40,10,60};
		int search = 40;
		int expected =4;
		String searchName = "순차탐색";
		s.search(array, search, searchName,expected );
		int search2 = 4;
		int expected2 =-1;
		s.search(array, search2, searchName,expected2 );
	}

}
