package JavaThreadBasics.ThreadPools;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class ThreadPools {

    /*
    void receiveAndExecuteClientOrdersBest() {

        int expectedConcurrentOrders = 100;
        Executor executor = Executors.newFixedThreadPool(expectedConcurrentOrders);

        while (true) {
            final Order order = waitForNextOrder();

            executor.execute(new Runnable() {

                public void run() {
                    order.execute();
                }
            });
        }
    }
    */
}
