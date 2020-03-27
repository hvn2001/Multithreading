package Quizzes.Quiz1.Ques3;

import java.util.concurrent.Callable;

class Demonstration {
    public static void main(String args[]) throws Exception {
        (new LambdaTargetType()).getWorking();
        // Callable invoked
    }
}

class LambdaTargetType {

    public void getWorking() throws Exception {
        compute(() -> "done");
    }

    void compute(Runnable r) {
        System.out.println("Runnable invoked");
        r.run();
    }

    <T> T compute(Callable<T> c) throws Exception {
        System.out.println("Callable invoked");
        return c.call();
    }
}
