import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingDeque;

public class ScenarioBase {
    
    public static void main(String[] args) {
        ExecutorService nodes = Executors.newFixedThreadPool(3);
        ExecutorService task = Executors.newFixedThreadPool(5);
        BlockingQueue<Task> fila = new LinkedBlockingDeque<>();
        try {
            nodes.execute(new Node(fila));
            nodes.execute(new Node(fila)); 
            nodes.execute(new Node(fila)); 
            task.execute(new TaskProducer(fila));
            task.execute(new TaskProducer(fila)); 
            task.execute(new TaskProducer(fila)); 
            task.execute(new TaskProducer(fila)); 
            task.execute(new TaskProducer(fila)); 
            
        } catch (Exception e) {}

    }
}
