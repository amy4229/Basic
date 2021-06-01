package amy.dataStructure.Heap;

import java.util.Arrays;

public class MyHeapTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] array = new int[] {60,20,70,10,80,30,50,40};
		int[] expected = new int[] {80,70,60,40,20,30,50,10};
		MyHeap h = new MyHeap(8);
		for(int i =0; i< array.length; i++) {
			h.add(array[i]);
		}
		System.out.printf("실제 힙: %s \r\n 예상힙 : %s \r\n", h, Arrays.toString(expected));
		h.printHeap();
		h.deleteRoot();
		System.out.println(h);
		h.printHeap();
	}

}
