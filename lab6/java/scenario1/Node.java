import java.util.concurrent.BlockingQueue;

public class Node implements Runnable {

  BlockingQueue<Task> tasks;

  public Node(BlockingQueue<Task> tasks) {
    this.tasks = tasks;
  }

    @Override
    public void run() {
      try {
        while(true) {
          tasks.take().execute();
        }
      } catch (Exception e) {
        e.printStackTrace();
      }
    }
}
