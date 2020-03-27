package InterviewPractice.BarberShop.F5;

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

        // Let the barber know, there's atleast 1 customer
        waitForCustomerToEnter.release();
        // Wait for barber to greet you and lead you to barber chair
        waitForBarberToGetReady.acquire();

        // This is where the customer gets the haircut

        // Wait for haircut to complete
        waitForBarberToCutHair.acquire();
        // Leave the barber chair and let barber thread know chair is vacant
        waitForCustomerToLeave.release();

        lock.lock();
        waitingCustomers--;
        lock.unlock();
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