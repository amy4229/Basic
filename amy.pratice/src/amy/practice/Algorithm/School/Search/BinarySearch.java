package amy.practice.Algorithm.School.Search;

import java.util.Arrays;

/**
 * 이진탐색
 * 
 * 정렬된 데이터의 반씩 탐색하는 탐색방법
 * 
 * @author "Amy"
 *
 */
public class BinarySearch extends AbstractSearch {

	@Override
	protected int searchProcess(int[] array, int search) {
		return binarySearch(array, 0, array.length - 1, search);
	}

	private int binarySearch(int[] array, int start, int end, int search) {
		int mid = (start + end) / 2;
		System.out.println(Arrays.toString(array) + " " + start + " " + end + " " + array[mid] + " " + search);
		if (start > end) {
			return -1;
		}
		if (array[mid] > search) {
			mid = binarySearch(array, start, mid - 1, search);
		}else 	if (array[mid] < search) {
			mid = binarySearch(array, mid + 1, end, search);
		}
		return mid;

	}

	public static void main(String[] args) {
		BinarySearch bs = new BinarySearch();
		int[] array = new int[] { 10, 15, 20, 25, 30, 35, 40, 45, 50 };
		String searchName = "이진탐색";
		int search = 50;
		int expected = 8;
		bs.search(array, search, searchName, expected);
		int search2 = 11;
		int expected2 = -1;
		bs.search(array, search2, searchName, expected2);
	}

}
