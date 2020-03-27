package Quizzes.Quiz2.Ques4;

class HitCounter {

    long count = 0;

    void hit() {
        count++;
    }

    long getHits() {
        return this.count;
    }
}