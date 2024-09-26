import java.time.Instant;
import java.util.Random;

public class Task {
    Long id;
    TaskProducer produtor;
    public int prioridade;

    public Task(Long id, int prioridade, TaskProducer produtor) {
        this.id = id;
        this.produtor = produtor;
        this.prioridade = prioridade;
        Instant.now().toEpochMilli();
    }

    int compareTo(Task o){
        if (o.prioridade < prioridade) return -1;
        if (o.prioridade == prioridade) return 0;
        return 1;
    }

    public void execute() {
        try {
            // generating a number between 1000 and 15000
            long execDuration = 1000 + (long) (new Random().nextFloat() * (15000 - 1000));
            produtor.tempoTotal.set(((int)(produtor.tempoTotal.get() + execDuration)));
            produtor.tasksRodadas.incrementAndGet();
            produtor.ordemTasks.add(this.id);
            produtor.tempoCada.add(execDuration);
            Thread.sleep(execDuration);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
