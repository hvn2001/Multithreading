package InterviewPractice.ImplementingBarrier.FinalCut;

public class Barrier {
    int released = 0;
    int count = 0;
    int totalThreads;

    public Barrier(int totalThreads) {
        this.totalThreads = totalThreads;
    }

    public synchronized void await() throws InterruptedException {

        // block any new threads from proceeding till,
        // all threads from previous barrier are released
        while (count == totalThreads) wait();

        // increment the counter whenever a thread arrives at the
        // barrier.
        count++;

        if (count == totalThreads) {
            // wake up all the threds.
            notifyAll();
            // remember to set released to totalThreads
            released = totalThreads;
        } else {
            // wait till all threads reach barrier
            while (count < totalThreads)
                wait();
        }

        released--;
        if (released == 0) {
            count = 0;
            // remember to wakeup any threads
            // waiting on line#14
            notifyAll();
        }
    }
}