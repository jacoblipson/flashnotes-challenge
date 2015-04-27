import java.lang.Runtime;
import java.io.*;
import java.util.UUID;

public class Task {

    //Free text description
    public String description;
    //Unique object identifier
    public Long GUID = UUID.randomUUID().getMostSignificantBits();
    //An executable command line
    public static String command;

    //Tasks must be created with an input description and an input command
    public Task(String input_desc, String input_comm) {
      description = input_desc;
      command = input_comm;
    }
    
    //Runs the task's stored command, creates a TaskResult, and returns the task's exit code
    public TaskResult execute() {
        String trace = "";
        String output = "";
        Integer exitVal = null;
        long startTime = System.nanoTime();
        TaskResult result;

        try {

          //Runtime allows the application to interface with the environment it runs in
          Process pr = Runtime.getRuntime().exec(command);
          
          //Stores the command's dump to standard output in a string
          BufferedReader input = new BufferedReader(new InputStreamReader(pr.getInputStream()));
          String line=null;
          while((line=input.readLine()) != null) {
                output += line;
          }

          //Receive and print the exit code of the process
          exitVal = pr.waitFor();
        } catch (Exception e) {
            //Preserves the exception message thrown in a string
            CharArrayWriter cw = new CharArrayWriter();
            PrintWriter w = new PrintWriter(cw);
            e.printStackTrace(w);
            w.close();
            trace = cw.toString();
        } finally {
            //Create TaskResult instance
            long endTime = System.nanoTime();
            result = new TaskResult(GUID, exitVal, output, trace, endTime - startTime);
        }
        return result;
    }
}