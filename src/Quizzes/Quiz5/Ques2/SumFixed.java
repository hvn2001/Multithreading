package Quizzes.Quiz5.Ques2;

import java.util.concurrent.atomic.AtomicInteger;

public class SumFixed {

    AtomicInteger count = new AtomicInteger(0);

    int sum(int... vals) {

        count.getAndIncrement();

        int total = 0;
        for (int i = 0; i < vals.length; i++) {
            total += vals[i];
        }
        return total;
    }

    void printInvocations() {
        System.out.println(count.get());
    }
}