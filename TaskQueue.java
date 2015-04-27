import java.util.List;
import java.util.LinkedList;
import java.util.ArrayList;

public class TaskQueue {

	//TaskQueue is implemented as a linked list of Tasks
	private static LinkedList<Task> queue;

	public TaskQueue() {
		queue = new LinkedList<Task>(); 
	}

	//Adds another Task to the bottom of the queue
	public void push(Task new_task) {
		queue.add(new_task);
	}

	//Permanently removes and returns the next Task
	public static Task pop() {
		return queue.removeFirst();
	}

	//Creates an ArrayList of the queue's members and returns it
	public static List<Task> peek_all() {
		List<Task> task_list = new ArrayList<Task>(queue);
		return task_list;
	}

	//Returns a copy of the next Task
	public static Task peek_next() {
		return queue.peekFirst();
	}

	//Returns the number of Tasks in the queue
	public static Integer count() {
		return queue.size();
	}
}