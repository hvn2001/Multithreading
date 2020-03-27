package Quizzes.Quiz8.Ques1;

public class Counter {

    ThreadLocal<Integer> counter = ThreadLocal.withInitial(() -> 0);

    public Counter() {
        counter.set(10);
    }

    void increment() {
        counter.set(counter.get() + 1);
    }

    public void usingThreads() throws Exception {

        Counter counter = new Counter();
        Thread[] tasks = new Thread[100];

        for (int i = 0; i < 100; i++) {
            Thread t = new Thread(() -> {
                for (int j = 0; j < 100; j++)
                    counter.increment();
            });
            tasks[i] = t;
            t.start();
        }

        for (int i = 0; i < 100; i++) {
            tasks[i].join();
        }

        // What is the output of the the below line?
        System.out.println(counter.counter.get());
    }
}