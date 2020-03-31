package Multithreading.MissedSignals6;

import java.util.concurrent.Semaphore;

class DemonstrationFixedMissedSigna {

    public static void main(String args[]) throws InterruptedException {
        FixedMissedSignalExample.example();
    }
}

class FixedMissedSignalExample {

    public static void example() throws InterruptedException {

        final Semaphore semaphore = new Semaphore(0);

        Thread signaller = new Thread(new Runnable() {

            public void run() {
                semaphore.release();
                System.out.println("Sent signal");
            }
        });

        Thread waiter = new Thread(new Runnable() {

            public void run() {
                try {
                    semaphore.acquire();
                    System.out.println("Received signal");
                } catch (InterruptedException ie) {
                    // handle interruption
                }
            }
        });

        waiter.setName("--Waiter--");
        signaller.setName("--Signaller--");
        waiter.start();
        signaller.start();
        waiter.join();
        signaller.join();
        // Thread.sleep(2000);


        System.out.println("Program Exiting.");
    }
}

