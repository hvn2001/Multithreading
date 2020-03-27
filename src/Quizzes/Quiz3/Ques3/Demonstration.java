package Quizzes.Quiz3.Ques3;

class Demonstration {
    public static void main(String args[]) throws Exception {

        Thread[] tasks = new Thread[10];
        for (int i = 0; i < 10; i++) {
            tasks[i] = new Task(i);
            tasks[i].start();
        }

        for (int i = 0; i < 10; i++) {
            tasks[i].join();
        }

        /*
        square root is: 0.0
        square root is: 1.0
        square root is: 1.4142135623730951
        square root is: 1.7320508075688772
        square root is: 2.0
        square root is: 2.449489742783178
        square root is: 2.23606797749979
        square root is: 2.6457513110645907
        square root is: 2.8284271247461903
        square root is: 3.0
        * */
    }
}

class Task<T extends Number> extends Thread {

    T item;

    public Task(T item) {
        this.item = item;
    }

    public void run() {
        System.out.println("square root is: " + Math.sqrt(item.doubleValue()));
    }
}