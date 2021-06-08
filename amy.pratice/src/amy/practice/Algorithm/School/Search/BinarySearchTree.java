package amy.practice.Algorithm.School.Search;

import java.util.LinkedList;
import java.util.Queue;
import java.util.stream.IntStream;

/**
 * 이진 탐색 트리
 * 
 * 이진탐색의 삽입/삭제 기능을 더 빠르게 보완한  트리 형태로 데이터를 담아 탐색하는 방법
 * @author "Amy"
 *
 */
public class BinarySearchTree extends AbstractSearch {

	/**
	 * 노드 클래스
	 * @author "Amy"
	 *
	 */
	/**
	 * @author "Amy"
	 *
	 */
	class Node {
		
		/**
		 * 왼쪽노드  키값보다 작은 자식노드
		 */
		Node left;
		
		/**
		 * 키값 
		 */
		int key;
		/**
		 * 오른쪽 노드 : 키값보다 큰 자식노드
		 */
		Node right;

		public Node() {
			// TODO Auto-generated constructor stub
		}

		public Node(Node left, int key, Node right) {
			this.left = left;
			this.key = key;
			this.right = right;
		}

	}

	/**
	 * 이진탐색트리의 헤더
	 */
	public Node binarySearchTree;
	
	/**
	 * 기본생성자
	 */
	public BinarySearchTree() {
	}

	/**
	 * 생성자
	 * @param array
	 */
	public BinarySearchTree(int[] array) {
		this.binarySearchTree = new Node(null, array[0], null);
		IntStream.range(1, array.length).forEach(i -> addElement(binarySearchTree, array[i]));
		printTree();
	}
	
	/**
	 * 노드 삽입
	 * 같은 값의 노드가 존재할 시 추가안함
	 * @param insertVal 삽입할 값
	 * @return 삽입 성공여부
	 */
	public boolean insertNode(int insertVal) {
		System.out.print("노드추가 \t");
		if(!addElement(binarySearchTree, insertVal)) {
			System.out.print("이미 존재하는 노드입니다.");
			return false;
		}
		System.out.println();
		return true;
	}
	
	/**
	 * 해당 값을 갖는 노드 존재여부 확인
	 * @param search 존재여부 확인할 값
	 * @return 존재여부 
	 */
	public boolean isExist (int search) {
		Node next = this.binarySearchTree;
		while(next != null) {
			if(next.key == search) {
				System.out.printf("%d 존재합니다.\r\n" , search );
				return true;
			}else {
				if(next.key > search) {
					next = next.left;
				}else {
					next = next.right;
				}
			}
		}
		System.out.printf("%d 존재하지 않습니다.\r\n" , search );
		return false;
	}

	/**
	 * 노드 추가
	 * @param parent 부모노드
	 * @param no 추가할 키값
	 * @return 추가 성공여부
	 */
	private boolean addElement(Node parent, int no) {
		if (parent.key == no) {
			return false;
		}
		if (parent.key < no) {
			if (parent.right == null) {
				parent.right = new Node(null, no, null);
			} else {
				return addElement(parent.right, no);
			}
		} else {
			if (parent.left == null) {
				parent.left = new Node(null, no, null);
			} else {
				return addElement(parent.left, no);
			}
		}
		return true;
	}

	/**
	 * 트리를 각 레벨별로 출력
	 */
	public void printTree() {
		Queue<Node> addednode = new LinkedList<>();
		Queue<Node> printnode = new LinkedList<>();
		addednode.add(binarySearchTree);
		System.out.println("트리구조출력");

		while (true) {
			if (addednode.isEmpty()) {
				break;
			}
			while (!addednode.isEmpty()) {
				Node node = addednode.poll();
				printnode.add(node);
			}
			while (!printnode.isEmpty()) {
				Node node = printnode.poll();
				if (node.left != null) {
					addednode.add(node.left);
				}
				if (node.right != null) {
					addednode.add(node.right);
				}
				System.out.print(node.key + "\t");
			}
			System.out.println();

		}
	}
	
	/**
	 * 삭제 
	 * @param value 삭제할 노드의 키값
	 */
	public void delete(int value) {
		System.out.print("노드 삭제\t");
		Node parent = binarySearchTree;
		Node current = null;
		if(!isExist(value)) return;
		while(parent !=null ) {
			if(parent.left.key == value) {
				current = parent.left;
				//노드가 터미널일 경우
				if(current.left == null && current.right == null ) {
					parent.left= null;
				}else if(current.left != null && current.right != null){
					parent.left = getReplaceNode(current);
				} else {
					parent.left = current.left != null ? current.left:current.right;
				}
				break;
			}else if(parent.right.key == value) {
				current = parent.right;
				//노드가 터미널일 경우
				if(current.left == null && current.right == null ) {
					parent.right= null;
				}else if(current.left != null && current.right != null){
					parent.right = getReplaceNode(current);
				} else {
					parent.right = current.left != null ? current.left:current.right;
				}
				break;
			}else  {
				parent = parent.key < value ? parent.right: parent.left;
			}
		}
	}
	
	/**
	 * 노드 삭제시 터미널 노드가 아닐때 재구성
	 * @param target 대상 노드
	 * @return 교체될 노드 
	 */
	private Node getReplaceNode(Node target) {
		Node parent = target;
		Node current = null;
		while(parent != null) {
			current = parent.left;
			if(current.left == null) {
				if(current.right!=null) {
					parent.left =current.right;
				}else {
					parent.left = null;
				}
				current.right = target.right;
				current.left = target.left;
				return current;
			}else {
				parent = current;
			}
		}
		return null;
	}

	/**
	 * 이진탐색트리 
	 */
	@Override
	protected int searchProcess(int[] array, int search) {
		this.binarySearchTree = new Node(null, array[0], null);
		IntStream.range(1, array.length).forEach(i -> addElement(binarySearchTree, array[i]));
		return isExist(search)?1:-1;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] array = new int[] { 20, 30, 40, 50, 60, 10, 30, 40, 90 };
		String searchName ="이진탐색트리";
		int expected1 = 1;
		int search1 = 10 ;
		BinarySearchTree bst = new BinarySearchTree();
		bst.search(array, search1, searchName, expected1);
		int expected2 = -1;
		int search2 = 25 ;
		bst.search(array, search2, searchName, expected2);
		bst.insertNode(5);
		bst.insertNode(10);
		bst.printTree();
		bst.delete(10);
		bst.printTree();

	}

}
