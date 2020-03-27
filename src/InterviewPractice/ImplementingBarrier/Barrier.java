package InterviewPractice.ImplementingBarrier;

public class Barrier {

    int count = 0;
    int totalThreads;

    public Barrier(int totalThreads) {
        this.totalThreads = totalThreads;
    }

    public synchronized void await() throws InterruptedException {
        // increment the counter whenever a thread arrives at the
        // barrier.
        count++;

        if (count == totalThreads) {
            // wake up all the threads.
            notifyAll();
            // remember to reset count so that barrier can be reused
            count = 0;
        } else {
            // wait if you aren't the nth thread
            wait();
        }
    }
}