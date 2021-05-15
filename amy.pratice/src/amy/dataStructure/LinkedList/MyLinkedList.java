package amy.dataStructure.LinkedList;

/**
 * @author wkhs4
 *
 * @param <T>
 */
public class MyLinkedList<T> {
	
	private Node head;
	private Node tail;
	private int size;
	
	private class Node{
		
		private Node next;
		private T value;
		
		public Node(T value) {
			this.value = value;
		}
		
		public String toString() {
			return value.toString();
		}
		
	}
	
	/**
	 * Constructor
	 * */	
	public MyLinkedList(T value) {
		this.head = new Node(value);
		this.tail = head;
		this.size = 1;
	}
	
	/**
	 * getNode
	 * 	특정 인덱스의 노드를 반환
	 * @param index
	 * @return 노드
	 */
	private Node getNode(int index){
			int i = 0;
			Node node = head;
			while(i < index) {
				node = node.next;
				i++;
			}
			return node;
	}
	
	/**
	 * get
	 * 특정 인텍스의 값를 반환
	 * @param index 인덱스
	 * @return value 값
	 */
	public T get(int index) {
		return getNode(index).value;
	}
	
	
	
	/**
	 * indexOf 
	 * 	특정값을 갖는 가장 처음 인덱스를 반환
	 * 특정값을 갖는 노드가 없을경우 -1반환
	 * @param value 값
	 * @return 인덱스 (특정값을 갖는 노드가 없을경우 -1반환)
	 * 
	 */
	public int indexOf(T value) {
		int index = 0;
		Node nowNode = head;
		while(!nowNode.value.equals(value)) {
			nowNode=nowNode.next;
			index++;
			if(index > size-1) {
				index =-1;
				break;
			}
		}
		return index;
	}
	
	
	/**
	 * lastIndexOf
	 * 특정값을 갖는 가장마지막 노드의 인덱스를 반환
	 * 특정값을 갖는 노드가 없을경우 -1반환
	 * @param value 값
	 * @return 인덱스
	 */
	public int lastIndexOf(T value) {
		int i = 0;
		Node nowNode = head;
		int index = 0;
		boolean isExist =false;
		while(i < size) {
			if(nowNode.value.equals(value)) {
				index = i;
				isExist = true;
			}
			nowNode=nowNode.next;
			i++;
		}
		if(!isExist) index = -1;
		return index;
	}
	
	
	public void add(T value) {
		Node newNode = new Node(value);
		tail.next = newNode;
		size++;
		tail = newNode;
	}
	
	
	public void remove(int index) {
		if(size < index-1) {
			System.out.println("해당노드는 존재하지 않습니다.");
		}else {
			Node prior = getNode(index-1);
			Node target =prior.next;
			Node next = target.next;
			
			prior.next = next;
			size--;
		}
		
	}
	
	public void print() {
		Node node = head;
		for(int i =0; i< size; i++) {
			System.out.print(node.toString()+"\t");
			node = node.next;
		}
	}

}
