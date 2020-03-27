package InterviewPractice.DiningPhilosophers.LimitingPhilosophers;

import java.util.Random;
import java.util.concurrent.Semaphore;

public class DiningPhilosophers {

    // This random variable is used for test purporses only
    private static Random random = new Random(System.currentTimeMillis());
    // Five semaphore represent the five forks.
    private Semaphore[] forks = new Semaphore[5];

    // Initializing the semaphores with a permit of 1
    public DiningPhilosophers() {
        forks[0] = new Semaphore(1);
        forks[1] = new Semaphore(1);
        forks[2] = new Semaphore(1);
        forks[3] = new Semaphore(1);
        forks[4] = new Semaphore(1);
    }

    // Represents how a philosopher lives his life
    public void lifecycleOfPhilosopher(int id) throws InterruptedException {

        while (true) {
            contemplate();
            eat(id);
        }
    }

    // We can sleep the thread when the philosopher is thinking
    void contemplate() throws InterruptedException {
        Thread.sleep(random.nextInt(500));
    }

    // This method will have the meat of the solution, where the
    // philosopher is trying to eat.
    void eat(int id) throws InterruptedException {
    }
}