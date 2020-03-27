package Quizzes.Quiz1.Ques2;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class Demonstration {
    public static void main(String args[]) throws Exception {
        ExecutorService threadPool = Executors.newFixedThreadPool(5);

        Callable<Void> someTask = new Callable<Void>() {

            public Void call() throws Exception {
                System.out.println("Running");
                return null;
            }
        };

        threadPool.submit(someTask).get();

        System.out.println("Program Exiting");
        /*
        Running
        Program Exiting
        * */
    }
}