package InterviewPractice.DiningPhilosophers.Sol;

import java.util.Random;
import java.util.concurrent.Semaphore;

public class DiningPhilosophers {

    private static Random random = new Random(System.currentTimeMillis());

    private Semaphore[] forks = new Semaphore[5];
    private Semaphore maxDiners = new Semaphore(4);

    public DiningPhilosophers() {
        forks[0] = new Semaphore(1);
        forks[1] = new Semaphore(1);
        forks[2] = new Semaphore(1);
        forks[3] = new Semaphore(1);
        forks[4] = new Semaphore(1);
    }

    public void lifecycleOfPhilosopher(int id) throws InterruptedException {

        while (true) {
            contemplate();
            eat(id);
        }
    }

    void contemplate() throws InterruptedException {
        Thread.sleep(random.nextInt(500));
    }

    void eat(int id) throws InterruptedException {

        // acquire the left fork first
        forks[id].acquire();

        // acquire the right fork second
        forks[(id + 1) % 5].acquire();

        // eat to your heart's content
        System.out.println("Philosopher " + id + " is eating");

        // release forks for others to use
        forks[id].release();
        forks[(id + 1) % 5].release();

    }
}