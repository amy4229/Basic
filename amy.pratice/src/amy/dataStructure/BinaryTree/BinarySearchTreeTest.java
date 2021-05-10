package amy.dataStructure.BinaryTree;

public class BinarySearchTreeTest {
	
	public static void testMyBinarySearchTree() {
		myBinarySearchTree mBST = new myBinarySearchTree(25);
		mBST.insert(100);
		mBST.insert(20);
		mBST.insert(21);
		
		System.out.println(mBST.head.value + "");
		System.out.println(mBST.head.left.value + "\t"+ mBST.head.right.value);
		System.out.println(mBST.head.left.right.value);
	}
	
	public static void main(String[] args) {
		testMyBinarySearchTree();
	}

}
