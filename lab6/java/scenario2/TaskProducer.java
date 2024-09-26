import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

public class TaskProducer implements Runnable {

    PriorityBlockingQueue<Task> tasks;
    AtomicInteger tasksRodadas;
    Long tasksCriadas = 0L;
    AtomicInteger tempoTotal;
    int idProd;
    CopyOnWriteArrayList<Long> tempoCada = new CopyOnWriteArrayList<>();
    CopyOnWriteArrayList<Long> ordemTasks = new CopyOnWriteArrayList<>();
    int prioridades;
    int delay;

    public TaskProducer(PriorityBlockingQueue<Task> tasks, int delay, int prioridades, int idProd) {
        this.idProd = idProd;
        this.tasks = tasks;
        this.tempoTotal = new AtomicInteger(0);
        this.tasksRodadas = new AtomicInteger(0);
        this.delay = delay;
        this.prioridades = prioridades;
      }

    @Override
    public void run() {
        try {
            while(true) {
                Task task = new Task(tasksCriadas, prioridades, this);
                tasks.add(task);
                tasksCriadas++;
                if (tasksRodadas.get() > 0){
                    System.out.println("PRODUTOR " + idProd + 
                    "\n IDS DAS TASKS COMPLETAS DO PRODUTOR: " + ordemTasks.toString() + 
                    "\n TEMPO POR TASK: " + tempoCada.toString() + 
                    "\n TEMPO MEDIO: " + (tempoTotal.get() / tasksRodadas.get())+"\n\n");
                }
                Thread.sleep(delay);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}