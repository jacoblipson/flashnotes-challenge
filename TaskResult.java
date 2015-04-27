import java.lang.Runtime;
import java.io.*;

public class TaskResult {

	//True if task ran without exception, else False
	public boolean succeeded;
    //Task's unique object identifier
    public Long task_GUID;
    //Return code returned by execute
    public Integer return_code;
    //The stdout dump for the task
    public String output;
    //An exception message if an exception occurred during execution.
    public String exception;
    //How long this task took to run
	public Long execution_duration;


    //Tasks must be created with an input description and an input command
    public TaskResult(Long task_id, int exit, String out_dump, String except, long duration) {
    	task_GUID = task_id;
    	execution_duration = duration;
		return_code = exit;
		exception = except;
		output = out_dump;
    	if (exception.equals("")) {
    		succeeded = true;
    	} else {
    		succeeded = false;
    	}
    }
    
}