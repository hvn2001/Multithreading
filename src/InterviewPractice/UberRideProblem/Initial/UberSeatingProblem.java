package InterviewPractice.UberRideProblem.Initial;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.locks.ReentrantLock;

public class UberSeatingProblem {

    private int republicans = 0;
    private int democrats = 0;

    CyclicBarrier barrier = new CyclicBarrier(4);
    ReentrantLock lock = new ReentrantLock();

    void seatDemocrat() throws InterruptedException, BrokenBarrierException {
    }

    void seatRepublican() throws InterruptedException, BrokenBarrierException {
    }

    void seated() {
    }

    void drive() {
    }
}