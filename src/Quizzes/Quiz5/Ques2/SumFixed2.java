package Quizzes.Quiz5.Ques2;

public class SumFixed2 {

    int count = 0;

    synchronized int sum(int... vals) {

        count++;

        int total = 0;
        for (int i = 0; i < vals.length; i++) {
            total += vals[i];
        }
        return total;
    }

    synchronized void printInvocations() {
        System.out.println(count);
    }
}