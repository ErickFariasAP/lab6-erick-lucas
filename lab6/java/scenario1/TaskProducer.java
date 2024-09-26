import java.util.concurrent.BlockingQueue;

public class TaskProducer implements Runnable {

    BlockingQueue<Task> tasks;

    public TaskProducer(BlockingQueue<Task> tasks) {
        this.tasks = tasks;
      }

    @Override
    public void run() {
        try {
            while(true) {
                Task task = new Task(0);
                tasks.add(task);
                Thread.sleep(5000);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}