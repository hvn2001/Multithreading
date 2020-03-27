package Quizzes.Quiz7.Ques1.F2;

import java.io.File;

class Demonstration {
    public static void main(String args[]) throws Exception {
        BadClassDesign bcd = (new BadClassDesign());
        /*
        BadClassDesign
        null
        * */
    }
}

class BadClassDesign {

    // Private field
    private File file;

    public BadClassDesign() throws InterruptedException {
        Thread t = new Thread(() -> {
            System.out.println(this.getClass().getSimpleName());

            // Private field of class is accessible in the anonymous class
            System.out.println(this.file);
        });
        t.start();
        t.join();
    }
}