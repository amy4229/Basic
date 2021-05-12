package amy.dataStructure.Stack;

import java.util.ArrayList;
import java.util.List;

public class MyStack<T> {
	
	private List<T> stack;

	public MyStack() {
		this.stack = new ArrayList<T>();
	}
	
	public void push(T data) {
		stack.add(data);
	}
	
	public T poll() {
		T data = stack.get(stack.size()-1);
		stack.remove(stack.size()-1);
		return data;
	}
	
	public T peek() {
		T data = stack.get(-1);
		return data;
	}
	
	
	public boolean isEmpty() {
		return stack.isEmpty();
	}
	
	
	

}
