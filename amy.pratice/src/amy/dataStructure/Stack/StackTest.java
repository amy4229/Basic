package amy.dataStructure.Stack;

public class StackTest {
	
	public void mystackTest() {
		MyStack<Integer> mystack = new MyStack<>();
		for (int i = 0; i < 10; i++) {
			mystack.push(i);
		}
		
		while(!mystack.isEmpty()) {
			System.out.println(mystack.poll());
		}
		
	}

	public static void main(String[] args) {
		StackTest test = new StackTest();
		test.mystackTest();

	}

}
