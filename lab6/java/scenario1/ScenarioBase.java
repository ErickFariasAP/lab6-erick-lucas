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
            task.execute(new TaskProducer(fila,1));
            task.execute(new TaskProducer(fila,2)); 
            task.execute(new TaskProducer(fila,3)); 
            task.execute(new TaskProducer(fila,4)); 
            task.execute(new TaskProducer(fila,5)); 
            
        } catch (Exception e) {}

    }
}
