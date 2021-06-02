package amy.dataStructure.Heap;

import java.util.Arrays;

/**
 * 최대힙구현클래스 최대힙 : 완전이진트리 구조의 자료구조, 부모노드가 자식노드보다 항상 같거나크다.
 * 
 * @author "Amy"
 *
 */
public class MyHeap {
	private int[] heap;
	private int length;

	/**
	 * 생성자
	 * 
	 * @param length 배열초기화를 위한 길이
	 */
	public MyHeap(int length) {
		this.length = 0;
		this.heap = new int[length];
	}

	/**
	 * 생성자
	 * 
	 * @param array 입력배열
	 */
	public MyHeap(int[] array) {
		this.heap = Arrays.copyOf(array, array.length);
		this.length = array.length;
		swapUpLeft(array.length - 1);
	}

	public int[] getHeapArray() {
		return heap;
	}

	/**
	 * 힙에 자료 추가
	 * 
	 * @param element 추가할 숫자
	 */
	public void add(int element) {
		if (length > heap.length) {
			System.out.println("정해진 힙의 크기를 초과하여 추가에 실패하였습니다.");
			return;
		}
		heap[length] = element;
		swapUp(length);
		length++;
	}

	/**
	 * 데이터 추가시 부모노드가 자식노드보다 크도록 재구성 아래 노드부터 상위노드로 정렬진행
	 * 
	 * @param node 체크할 말단 노드
	 */
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

	/**
	 * 노드 삭제시, 윗노드부터 재구성하기위한 메서드
	 * 
	 * @param node 상위 노드
	
	private void swapDown(int node) {
		int parent = node;
		int child1 = 2 * (parent + 1) - 1;
		int child2 = 2 * (parent + 1);
		// 자식노드 체크
		boolean isSingleChild = false;
		if (child1 > length - 1) {
			return;
		}
		if (child2 > length - 1) {
			isSingleChild = true;
		}

		if (isSingleChild) {
			if (heap[child1] > heap[parent]) {
				swapDown(child1);
			}
		} else {
			if (heap[child2] > heap[parent]) {
				swapDown(child2);
			}
			if (heap[child1] > heap[parent]) {
				swapDown(child1);
			}
		}
		return;
	}
 */
	/**
	 * 노드 삭제시, 윗노드부터 재구성하기위한 메서드
	 * 
	 * @param node 상위 노드
	 */
	private void swapDown(int node) {
		int parent = node;
		int child1 = 2 * (parent + 1) - 1;
		int child2 = 2 * (parent + 1);
		if (child1 > length - 1) {
			return;
		}
		int childMax = heap[child1] >= (child2 > length - 1 ? 0 : heap[child2]) ? child1 : child2;
		if (heap[parent] < heap[childMax]) {
			swap(parent, childMax);
			swapDown(childMax);
		}
		return;
	}

	/**
	 * 입력배열을 힙으로 재구성하기 위한 메서드 아래/오른쪽부터 순차적 재구성
	 * 
	 * @param node 마지막 노드
	 */
	private void swapUpLeft(int node) {
		int parent = node;
		int child1 = 0;
		int child2 = 0;
		while (parent >= 0) {
			child1 = 2 * (parent + 1) - 1;
			child2 = 2 * (parent + 1);
			if (child1 > length - 1) {
				parent--;
				continue;
			}
			int childMax = heap[child1] >= (child2 > length - 1 ? 0 : heap[child2]) ? child1 : child2;
			if (heap[parent] < heap[childMax]) {
				swap(parent, childMax);
				swapDown(childMax);
			}
			parent--;
		}
	}

	/**
	 * 위치 바꿈 메서드
	 * 
	 * @param i 위치바꿀 인덱스1
	 * @param j 위치바꿀 인덱스2
	 */
	private void swap(int i, int j) {
		int tmp = heap[i];
		heap[i] = heap[j];
		heap[j] = tmp;
	}

	/**
	 * 최대값인 루트노드 삭제 메서드 루트노드 삭제 및 반환 재구성
	 * 
	 * @return 삭제한 루트노드의 값
	 */
	public int deleteRoot() {
		if (length == 0) {
			System.out.println("힙에 데이터가 없습니디");
			return -1;
		}
		int deleteElement = heap[0];
		swap(0, length - 1);
		heap[length - 1] = 0;
		swapDown(0);
		length--;
		return deleteElement;
	}

	/**
	 * 힙의 출력을 위한 변환
	 */
	@Override
	public String toString() {
		return Arrays.toString(heap);
	}

	/**
	 * 힙을 트리구조로 출력
	 */
	public void printHeap() {
		int h = 0;
		int i = 0;
		System.out.println("트리구조출력");
		while (h <= (int) Math.ceil(Math.sqrt(length + 1))) {
			for (int j = i; j < i + Math.pow(2, h); j++) {
				if (j > length - 1) {
					break;
				}
				System.out.print(heap[j] + "\t");
			}
			System.out.println();
			i = i + (int) Math.pow(2, h);
			h++;
		}
	}

}
