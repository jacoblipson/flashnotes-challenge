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
    
    //Runs the task's stored command and outputs the results
    public void execute() {
        try {
          //Runtime allows the application to interface with the environment it runs in
          Process pr = Runtime.getRuntime().exec(command);

          //Receives and outputs the results of the process
          BufferedReader input = new BufferedReader(new InputStreamReader(pr.getInputStream()));
          String line=null;
          while((line=input.readLine()) != null) {
              System.out.println(line);
          }
 
          //Receive and print the exit code of the process
          int exitVal = pr.waitFor();
          System.out.println("Exited with error code "+exitVal);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}