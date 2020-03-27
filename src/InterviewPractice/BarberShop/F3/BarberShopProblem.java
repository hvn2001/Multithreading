package InterviewPractice.BarberShop.F3;

import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.ReentrantLock;

public class BarberShopProblem {

    final int CHAIRS = 3;
    int waitingCustomers = 0;
    ReentrantLock lock = new ReentrantLock();
    Semaphore waitForCustomerToEnter = new Semaphore(0);
    Semaphore waitForBarberToGetReady = new Semaphore(0);
    Semaphore waitForCustomerToLeave = new Semaphore(0);
    Semaphore waitForBarberToCutHair = new Semaphore(0);

    void customerWalksIn() throws InterruptedException {
        lock.lock();
        if (waitingCustomers == CHAIRS) {
            System.out.println("Customer walks out, all chairs occupied.");
            // Remember to unlock before leaving
            lock.unlock();
            return;
        }
        waitingCustomers++;
        lock.unlock();

        // Let the barber know you are here, in case he's asleep
        waitForCustomerToEnter.release();
        // Wait for the barber to come take you to the salon chair when its your turn
        waitForBarberToGetReady.acquire();
        // TODO: complete the rest of the logic.
    }

    void barber() throws InterruptedException {
        while (true) {
            // wait till a customer enters a shop
            waitForCustomerToEnter.acquire();
            // let the customer know barber is ready
            waitForBarberToGetReady.release();

            System.out.println("Barber cutting hair...");
            Thread.sleep(50);

            // let customer thread know, haircut is done
            waitForBarberToCutHair.release();
            // wait for customer to leave the barber chair
            waitForCustomerToLeave.acquire();
        }
    }
}