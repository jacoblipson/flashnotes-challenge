public class Test {
	
	public static void main(String[] args) {

		TaskQueue simple_tasks = new TaskQueue();
		Task task1 = new Task("My first task", "ping -c 3 google-public-dns-a.google.com");
		Task task2 = new Task("My second task", "ping -c 3 google-public-dns-b.google.com");

		simple_tasks.push(task1);
		simple_tasks.push(task2);
		
		while (TaskQueue.peek_next() != null) {
		    Task t = TaskQueue.pop();
		    System.out.println("Running task " + t.GUID);
		    t.execute();
		}
	}

}