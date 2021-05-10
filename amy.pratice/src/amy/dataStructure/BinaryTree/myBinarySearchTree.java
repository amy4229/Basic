package amy.dataStructure.BinaryTree;

public class myBinarySearchTree {
	public class Node {
		public int value;
		public Node left;
		public Node right;
		
		public Node(int value) {
			this.value = value;
		}

	
	}
	
	public Node head;
	public int size;
	
	public myBinarySearchTree(int value) {
		this.head = new Node(value);
	}
	
	public void insert(int value) {
		Node current = head;
		while (true) {
			if(current.value > value ) {
				if(current.left == null) {
					current.left= new Node(value);
					break;
				} else {
					current = current.left;
					continue;
				}
			} else {
				if(current.right==null) {
					current.right= new Node(value);
					break;
				} else {
					current = current.right;
					continue;
				}
			}
		}
		size++;
	}
	
	public boolean isExist(int value) {
		Node current = head;
		while (current != null) {
			if( current.value == value ) {
				return true;
			} else {
				current = current.value < value ? current.left : current.right;
			} 
		}
		return false;
	}
	
	public Node getNode (int value) {
		Node current = head;
		while (current != null) {
			if( current.value == value ) {
				return current;
			} else {
				current = current.value < value ? current.left : current.right;
			} 
		}
		return null;
	}
	
	public void delete(int value) {
		Node parent = head;
		Node current = null;
		if(!isExist(value)) return;
		while(parent !=null ) {
			if(parent.left.value == value) {
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
			}else if(parent.right.value == value) {
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
				parent = parent.value < value ? parent.right: parent.left;
			}
		}
	}
	
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
	
	
	
	
}
