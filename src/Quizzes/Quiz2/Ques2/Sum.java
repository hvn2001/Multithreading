package Quizzes.Quiz2.Ques2;

public class Sum {

    int sum(int... vals) {

        int total = 0;
        for (int i = 0; i < vals.length; i++) {
            total += vals[i];
        }
        return total;
    }
}