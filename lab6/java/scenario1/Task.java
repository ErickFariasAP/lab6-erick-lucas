import java.util.Random;

public class Task {
    long id;

    public Task(long id) {
        this.id = id;
    }

    public void execute() {
        try {
            // generating a number between 1000 and 15000
            long execDuration = 1000 + (long) (new Random().nextFloat() * (15000 - 1000));
            System.out.println(execDuration);
            Thread.sleep(execDuration);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
