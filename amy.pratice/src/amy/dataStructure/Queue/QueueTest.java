package amy.dataStructure.Queue;

import java.util.PriorityQueue;
import java.util.Queue;

class prioritySchedule implements Comparable<prioritySchedule>{
	int priority;
	String schedule;

	public prioritySchedule() {
	}

	public prioritySchedule(int priority, String schedule) {
		this.priority = priority;
		this.schedule = schedule;
	}

	@Override
	public int compareTo(prioritySchedule target) {
		return this.priority <= target.priority ? -1 : 1;
	}

}

public class QueueTest {



	public void testQueue1(){
		System.out.println("\r\n start testQueue1");
		Queue1<String> stringQueue = new Queue1<String>();
		stringQueue.enqueue("a");
		stringQueue.enqueue("b");
		stringQueue.enqueue("c");
		stringQueue.enqueue("d");
		stringQueue.enqueue("E");

		while(!stringQueue.isEmpty()){
			System.out.println(stringQueue.dequeue());
		}
		System.out.println("end testQueue1");
	}

	public void testpriorityQueue (){
		System.out.println("\r\n start testpriorityQueue");
		Queue<Integer> priorityQueue = new PriorityQueue<Integer>();
		priorityQueue.add(1);
		priorityQueue.add(10);
		priorityQueue.add(5);
		priorityQueue.add(8);
		priorityQueue.add(9);
		priorityQueue.add(7);

		while(!priorityQueue.isEmpty()){
			System.out.println(priorityQueue.poll());
		}
		System.out.println("end testpriorityQueue");
	}
	public void testpriorityQueue2 (){
		System.out.println("\r\n start testpriorityQueue2");
		Queue<prioritySchedule> priorityQueue = new PriorityQueue<>();
		priorityQueue.add(new prioritySchedule(10, "schedule 1"));
		priorityQueue.add(new prioritySchedule(1, "ASAP"));
		priorityQueue.add(new prioritySchedule(5, "fast"));
		priorityQueue.add(new prioritySchedule(7, "common"));
		priorityQueue.add(new prioritySchedule(2, "schedule 2"));


		while(!priorityQueue.isEmpty()){
			prioritySchedule schedule = priorityQueue.poll();
			System.out.println(schedule.priority+ ": " + schedule.schedule);
		}
		System.out.println("testpriorityQueue2");
	}



	public static void main(String[] args) {
		QueueTest test = new QueueTest();
		test.testQueue1();
		test.testpriorityQueue();
		test.testpriorityQueue2();

	}

}
