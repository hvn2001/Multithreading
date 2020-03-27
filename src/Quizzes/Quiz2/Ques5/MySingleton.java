package Quizzes.Quiz2.Ques5;

class MySingleton {

    MySingleton singleton;

    private MySingleton() {
    }

    MySingleton getInstance() {
        if (singleton == null)
            singleton = new MySingleton();

        return singleton;
    }
}