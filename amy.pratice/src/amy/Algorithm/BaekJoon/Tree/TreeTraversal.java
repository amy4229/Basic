package amy.Algorithm.BaekJoon.Tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/**
 * 백준 #1991 트리순회
 * 
 * 문제 이진 트리를 입력받아 전위 순회(preorder traversal), 중위 순회(inorder traversal), 후위
 * 순회(postorder traversal)한 결과를 출력하는 프로그램을 작성하시오.
 * 
 * 
 * 예를 들어 위와 같은 이진 트리가 입력되면,
 * 
 * 전위 순회한 결과 : ABDCEFG // (루트) (왼쪽 자식) (오른쪽 자식) 중위 순회한 결과 : DBAECFG // (왼쪽 자식)
 * (루트) (오른쪽 자식) 후위 순회한 결과 : DBEGFCA // (왼쪽 자식) (오른쪽 자식) (루트) 가 된다.
 * 
 * 입력 첫째 줄에는 이진 트리의 노드의 개수 N(1≤N≤26)이 주어진다. 둘째 줄부터 N개의 줄에 걸쳐 각 노드와 그의 왼쪽 자식 노드,
 * 오른쪽 자식 노드가 주어진다. 노드의 이름은 A부터 차례대로 영문자 대문자로 매겨지며, 항상 A가 루트 노드가 된다. 자식 노드가 없는
 * 경우에는 .으로 표현된다.
 * 
 * 출력 첫째 줄에 전위 순회, 둘째 줄에 중위 순회, 셋째 줄에 후위 순회한 결과를 출력한다. 각 줄에 N개의 알파벳을 공백 없이 출력하면
 * 된다.
 * 
 * @author "Amy"
 *
 */
class Node {
	Node left;
	Node right;
	String value;
	
	public Node(String value) {
		this.value = value;
	}
	
	public Node(Node left, Node right, String value) {
		super();
		this.left = left;
		this.right = right;
		this.value = value;
		
	}
	
	public void addLeftNode(Node left) {
		this.left = left;
	}
	
	public void addRightNode( Node right) {
		this.right = right;
	}
	
	
}

class MyTree {
	public Node head;
	
	public MyTree(Node head) {
		this.head = head;
	}
	
	public void printByPreorder (Node start) {
		if(start == null) start = head;
		System.out.print(start.value);
		if(start.left != null ) printByPreorder(start.left);
		if(start.right != null ) printByPreorder(start.right);
	}
	public void printByInorder (Node start) {
		if(start == null) start = head;
		if(start.left != null ) printByInorder(start.left);
		System.out.print(start.value);
		if(start.right != null ) printByInorder(start.right);
	}
	
	public void printByPostorder (Node start) {
		if(start == null) start = head;
		if(start.left != null ) printByPostorder(start.left);
		if(start.right != null ) printByPostorder(start.right);
		System.out.print(start.value);
	}
	public Node getNodeByValue(String value) {
		Stack<Node> s = new Stack<>();
		s.add(head);
		while(!s.isEmpty()) {
			Node now = s.pop();
			if(now.value.equals(value)) return now;
			if(now.left != null) 	{
				s.add(now.left);
			}
			if(now.right != null) {
				s.add(now.right);
			} 
		}
		return null;
	}
	

}
public class TreeTraversal {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		MyTree tree = null;

		for (int i = 0; i < n; i++) {
			String[] info = br.readLine().split(" ");
			String parent = info[0];
			String left = info[1].equals(".") ? null :info[1] ;
			String right = info[2].equals(".") ? null :info[2] ;
			Node pNode = null;
			if(i == 0) {
				tree = new MyTree(new Node(parent));
				pNode = tree.head;
			} else {
				pNode = tree.getNodeByValue(parent);
			}
			if( left != null ) pNode.addLeftNode(new Node(left));
			if( right != null ) pNode.addRightNode(new Node(right));
		}
		tree.printByPreorder(null);
		System.out.println();
		tree.printByInorder(null);
		System.out.println();
		tree.printByPostorder(null);

		br.close();
	}
}
