package amy.practice.Algorithm.School.Sort;

import java.util.Arrays;

import amy.dataStructure.Heap.MyHeap;

public class HeapSortTest extends AbstractSort {
	@Override
	protected int[] sortProcess(int[] array) {
		int[] heap = new MyHeap(array).getHeapArray();
		System.out.println("최초힙 : " + Arrays.toString(heap));
		int unsortedNode = heap.length - 1;
		while (unsortedNode > 0) {
			swap(heap, 0, unsortedNode);
			unsortedNode--;
			swapDown(heap, unsortedNode);
		}
		return heap;
	}

	/**
	 * 노드 삭제시, 윗노드부터 재구성하기위한 메서드
	 * 
	 * @param node 상위 노드
	 */
	private void swapDown(int[] heap, int node) {
		int parent = node;
		int child1 = 0;
		int child2 = 0;
		while (parent >= 0) {
			child1 = 2 * (parent + 1) - 1;
			child2 = 2 * (parent + 1);
			if (child1 > node) {
				parent--;
				continue;
			}
			cnt++;
			int childMax = heap[child1] >= (child2 > node ? 0 : heap[child2]) ? child1 : child2;
			if (heap[parent] < heap[childMax]) {
				swap(heap, parent, childMax);
				swapDown(heap, childMax);
			}
			parent--;
		}
		return;
	}

	public static void main(String[] args) {
		int[] array = { 50, 10, 20, 40, 30 };
		HeapSortTest s = new HeapSortTest();
		s.sortName = "힙정렬";
		s.sort(array);
		int[] array2 = { 10, 20, 30, 40, 50 };
		s.sort(array2);
		int[] array3 = { 50, 40, 30, 20, 10 };
		s.sort(array3);
		int[] array4 = { 80, 60, 70, 40, 20,30,50,10 };
		s.sort(array4);

	}

}
