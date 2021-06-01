package amy.dataStructure.Heap;

import java.util.Arrays;

public class MyHeap {
	public int[] heap;
	private int length;

	public MyHeap(int length) {
		this.length = 0;
		this.heap = new int[length];
	}

	public void add(int element) {
		if (length  > heap.length) {
			System.out.println("정해진 힙의 크기를 초과하여 추가에 실패하였습니다.");
			return;
		}
		heap[length] = element;
		swapUp(length);
		length++;
	}

	private void swapUp(int node) {
		int parent = (int) Math.floor((node - 1) / 2.00);
		int child = node;
		while (parent >= 0) {
			if (heap[parent] < heap[child]) {
				swap(parent, child);
				child = parent;
				parent = (child - 1) / 2;
			} else {
				break;
			}
		}
	}

	private void swapDown(int node) {
		int parent = node;
		int child1 = 2 * parent;
		int child2 = (2 * parent) + 1;
		if (child1 > length || child2 > length) {
			return;
		}
		if (heap[child2] < heap[parent] && heap[child2] < heap[parent]) {
			return;
		} else if (heap[child2] > heap[parent]) {
			swap(child2, parent);
			swapDown(child2);
		} else {
			swap(child1, parent);
			swapDown(child1);
		}
	}

	private void swap(int i, int j) {
		int tmp = heap[i];
		heap[i] = heap[j];
		heap[j] = tmp;
	}

	public int deleteRoot() {
		if(length == 0) {
			System.out.println("힙에 데이터가 없습니디");
			return -1;
		}
		int deleteElement = heap[0];
		swap(0,length-1);
		heap[length-1] = 0;
		swapDown(0);
		length--;
		return deleteElement;
	}

	@Override
	public String toString() {
		return Arrays.toString(heap);
	}
	
	public void printHeap () {
		int h = 0;
		int i = 0;
		while(h < (int)Math.ceil(Math.sqrt(length+1))) {
			for(int j =i ; j < i+Math.pow(2,h); j++) {
				if(j > length) {break;}
				System.out.print(heap[j]+"\t");
			}
			System.out.println();
			i = i+ (int) Math.pow(2,h);
			h++;
		}
	}

}
