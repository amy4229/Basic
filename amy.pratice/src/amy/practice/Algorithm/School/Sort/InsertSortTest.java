package amy.practice.Algorithm.School.Sort;

public class InsertSortTest extends AbstractSort {
	protected int[] sortProcess(int[] array) {
		for( int sorted = 1; sorted < array.length; sorted++) {
			int targetIdx = sorted; 
			while(targetIdx>0 ) {
				cnt++;
				if( array[targetIdx] >= array[targetIdx-1]) break;
				swap(array, targetIdx, targetIdx-1);
				targetIdx--;
			}
		}
		
		return array;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] array = { 50, 10, 20, 40, 30 };
		InsertSortTest s = new InsertSortTest();
		s.sortName = "삽입정렬";
		s.sort(array);
		int[] array2 = { 10, 20, 30, 40, 50 };
		s.sort(array2);
		int[] array3 = { 50, 40, 30, 20, 10 };
		s.sort(array3);

	}

}
