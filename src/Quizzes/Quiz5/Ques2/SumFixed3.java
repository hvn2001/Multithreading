package Quizzes.Quiz5.Ques2;

public class SumFixed3 {

    int count = 0;
    Object lock = new Object();

    int sum(int... vals) {

        synchronized (lock) {
            count++;
        }

        int total = 0;
        for (int i = 0; i < vals.length; i++) {
            total += vals[i];
        }
        return total;
    }

    void printInvocations() {
        synchronized (lock) {
            System.out.println(count);
        }
    }
}