package amy.practice.Algorithm.School.Sort;

public class SelectionSortTest extends AbstractSort{
	
	protected int[] sortProcess(int[] array) {
		int i = 0;
		while (i < array.length-1) {
			int minIdx = i;
			int min = array[i];
			for(int j = i+1; j < array.length; j++) {
				cnt++;
				if( min > array[j] ) {
					minIdx = j; 
					min = array[j];
				}
			}
			if(i != minIdx) {
				swap( array, i, minIdx);
			}
			i++;
		}
		return array;
	}
	
	 public static void main(String[] args) {
			// TODO Auto-generated method stub
			int[] array = {50,10,20,40,30}; 
			SelectionSortTest s = new SelectionSortTest();
			s.sortName = "선택정렬"; 
			s.sort(array);
			int[] array2 = {10,20,30,40,50}; 
			s.sort(array2);
			int[] array3 = {50,40,30,20,10}; 
			s.sort(array3);

		}
	

}
