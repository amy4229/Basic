package amy.dataStructure.LinkedList;

public class MyDoubleLinkedList<T> {
	
	private Node head;
	private Node tail;
	private int size;
	
	private class Node{
		
		private Node prior;
		private Node next;
		private T value;
		
		public Node(T value, Node prior) {
			this.prior = prior;
			this.value = value;
		}
		
		public String toString() {
			return value.toString();
		}
		
	}
		
	public MyDoubleLinkedList(T value) {
		this.head = new Node(value, null);
		this.tail = head;
		this.size = 1;
	}
	
	private Node getNode(int index){
			int i = 0;
			Node node = head;
			while(i<index) {
				node = node.next;
				i++;
			}
			return node;
	}
	
	public T get(int index) {
		return getNode(index).value;
	}
	
	public void add(T value) {
		Node newNode = new Node(value, tail);
		tail.next = newNode;
		newNode.prior = tail;
		size++;
		tail = newNode;
	}
	
	public void remove(int index) {
		if(size < index-1) {
			System.out.println("해당노드는 존재하지 않습니다.");
		}else {
			Node target =getNode(index);
			Node prior = target.prior;
			Node next = target.next;
			
			prior.next = next;
			next.prior = prior;
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
