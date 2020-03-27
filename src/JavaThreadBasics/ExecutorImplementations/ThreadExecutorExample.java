package JavaThreadBasics.ExecutorImplementations;

import java.util.concurrent.Executor;

class ThreadExecutorExample {

    /*
    void receiveAndExecuteClientOrders() {

        while (true) {
            Order order = waitForNextOrder();
            order.execute();
        }
    }


    void receiveAndExecuteClientOrdersBetter2() {

        while (true) {
            final Order order = waitForNextOrder();

            Thread thread = new Thread(new Runnable() {

                public void run() {
                    order.execute();
                }
            });

            thread.start();
        }
    }
     */

}