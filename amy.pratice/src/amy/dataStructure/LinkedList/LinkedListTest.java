package amy.dataStructure.LinkedList;

public class LinkedListTest {
	
	public static void testMyDoubleLinkedList() {
		System.out.println("start testMyDoubleLinkedList");
		MyDoubleLinkedList<Integer> mylinkedList = new MyDoubleLinkedList<Integer>(0);
		for(int i = 1; i< 10; i++) {
			mylinkedList.add(i);
		}
		mylinkedList.add(1);
		mylinkedList.print();
		System.out.println();
		
		System.out.println(mylinkedList.get(1));
		
		mylinkedList.remove(1);
		System.out.println();
		
		mylinkedList.print();
		System.out.println();
		System.out.println("End testMyDoubleLinkedList\r\n");
	}
	
	public static void testMyLinkedList() {
		System.out.println("start testMyLinkedList");
		MyLinkedList<Integer> mylinkedList = new MyLinkedList<Integer>(0);
		for(int i = 1; i< 10; i++) {
			mylinkedList.add(i);
		}
		mylinkedList.add(1);
		mylinkedList.print();
		System.out.println();
		
		System.out.println(mylinkedList.indexOf(1));
		
		System.out.println(mylinkedList.get(1));
		
		mylinkedList.remove(1);
		System.out.println();
		
		mylinkedList.print();
		System.out.println();
		System.out.println("End testMyLinkedList\r\n");
	}

	public static void main(String[] args) {
		testMyDoubleLinkedList();
		testMyLinkedList();

	}

}
