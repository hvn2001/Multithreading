package Quizzes.Quiz3.Ques1;

class Demonstration {
    public static void main(String args[]) throws Exception {

        Thread t = new Thread(() -> {
            System.out.println("Hello from thread !");
        });

        t.start();
        t.join();

    }
}