package Quizzes.Quiz8.Ques5;

public class Ques5 {
    int countTo100() {

        ThreadLocal<Integer> count = ThreadLocal.withInitial(() -> 0);
        for (int j = 0; j < 100; j++)
            count.set(count.get() + 1);

        return count.get();

    }
}
