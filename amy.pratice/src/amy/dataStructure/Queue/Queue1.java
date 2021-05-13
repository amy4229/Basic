package amy.dataStructure.Queue;

import java.util.ArrayList;
import java.util.List;

/**
 * 일반적인 큐의 구조를 리스트를 이용해 구현
 * */
public class Queue1<T> {

	/**
	 * 큐의 구조를 구현한 자료형
	 * */
	private List<T> queue;

	/**
	 * Constructor
	 * */
	public Queue1() {
		this.queue = new ArrayList<T>();
	}

	public void enqueue(T data){
		queue.add(data);
	}

	public T dequeue(){
		T data = queue.get(0);
		queue.remove(0);
		return data;
	}

	public T peek(){
		T data = queue.get(0);
		return data;
	}

	public boolean isEmpty(){
		return queue.size()==0 ? true : false;
	}


}
