import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.PriorityBlockingQueue;

public class ScenarioBase {
    
    public static void main(String[] args) {
        ExecutorService nodes = Executors.newFixedThreadPool(3);
        ExecutorService task = Executors.newFixedThreadPool(5);
        PriorityBlockingQueue<Task> filaPrioridade = new PriorityBlockingQueue<>();
        try {
            nodes.execute(new Node(filaPrioridade));
            nodes.execute(new Node(filaPrioridade)); 
            nodes.execute(new Node(filaPrioridade)); 
            task.execute(new TaskProducer(filaPrioridade,13000,0,1));
            task.execute(new TaskProducer(filaPrioridade,7000,1,2)); 
            task.execute(new TaskProducer(filaPrioridade,3000,2,3)); 
            
        } catch (Exception e) {}

    }
}
