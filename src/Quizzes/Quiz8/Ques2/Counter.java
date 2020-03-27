package Quizzes.Quiz8.Ques2;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Counter {

    ThreadLocal<Integer> counter = ThreadLocal.withInitial(() -> 0);

    public Counter() {
        counter.set(10);
    }

    void increment() {
        counter.set(counter.get() + 1);
    }

    public void usingSingleThreadPool() throws Exception {

        Counter counter = new Counter();
        ExecutorService es = Executors.newFixedThreadPool(1);
        Future<Integer>[] tasks = new Future[100];

        for (int i = 0; i < 100; i++) {
            tasks[i] = es.submit(() -> {
                for (int j = 0; j < 100; j++)
                    counter.increment();

                return counter.counter.get();
            });
        }

        // What is the output of the below line?
        System.out.println(tasks[99].get());

        es.shutdown();
    }
}