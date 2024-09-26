import java.time.Instant;
import java.util.Random;

public class Task {
    long id;
    TaskProducer produtor;

    public Task(long id, TaskProducer produtor) {
        this.id = id;
        this.produtor = produtor;
        Instant.now().toEpochMilli();
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
