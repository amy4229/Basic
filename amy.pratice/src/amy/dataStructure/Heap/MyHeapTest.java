package amy.dataStructure.Heap;

import java.util.Arrays;

public class MyHeapTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] array = new int[] {60,20,70,10,80,30,50,40};
		int[] expected1 = new int[] {80,60,70,40,20,30,50,10};
		int[] expected2= new int[] {80,70,60,40,20,30,50,10};
		MyHeap h1 = new MyHeap(array);
		System.out.printf("입력데이터 : %s \r\n 실제 힙: %s \r\n 예상힙 : %s \r\n",Arrays.toString(array), h1, Arrays.toString(expected1));
		h1.printHeap();
		MyHeap h2 = new MyHeap(8);
		for(int i =0; i< array.length; i++) {
			h2.add(array[i]);
		}
		System.out.printf("입력데이터 : %s \r\n 실제 힙: %s \r\n 예상힙 : %s \r\n",Arrays.toString(array), h2, Arrays.toString(expected2));
		h2.printHeap();
		h2.deleteRoot();
		System.out.printf("최댓값 삭제후 힙 %s \r\n", h2);
		h2.printHeap();
		h2.deleteRoot();
		System.out.printf("최댓값 삭제후 힙 %s \r\n", h2);
		h2.printHeap();
	}

}
