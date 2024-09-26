import java.util.concurrent.BlockingQueue;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;

public class TaskProducer implements Runnable {

    BlockingQueue<Task> tasks;
    AtomicInteger tasksRodadas;
    int tasksCriadas = 0;
    AtomicInteger tempoTotal;
    int idProd;
    CopyOnWriteArrayList<Long> tempoCada = new CopyOnWriteArrayList<>();
    CopyOnWriteArrayList<Long> ordemTasks = new CopyOnWriteArrayList<>();

    public TaskProducer(BlockingQueue<Task> tasks, int idProd) {
        this.idProd = idProd;
        this.tasks = tasks;
        this.tempoTotal = new AtomicInteger(0);
        this.tasksRodadas = new AtomicInteger(0);
      }

    @Override
    public void run() {
        try {
            while(true) {
                Task task = new Task(tasksCriadas, this);
                tasks.add(task);
                tasksCriadas++;
                if (tasksRodadas.get() > 0){
                    System.out.println("PRODUTOR " + idProd + 
                    "\n IDS DAS TASKS COMPLETAS DO PRODUTOR: " + ordemTasks.toString() + 
                    "\n TEMPO POR TASK: " + tempoCada.toString() + 
                    "\n TEMPO MEDIO: " + (tempoTotal.get() / tasksRodadas.get())+"\n\n");
                }
                Thread.sleep(5000);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}