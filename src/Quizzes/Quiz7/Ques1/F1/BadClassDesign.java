package Quizzes.Quiz7.Ques1.F1;

import java.io.File;

public class BadClassDesign {

    private File file;

    public BadClassDesign() throws InterruptedException {
        Thread t = new Thread(() -> {
            System.out.println(this.file);
        });
        t.start();
        t.join();
    }
}