package InterviewPractice.ImplementingBarrier.SecondCut;

public class Barrier {
    int released = 0;
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
            // wake up all the threds.
            notifyAll();
            // remember to reset count so that barrier can be reused
            released = totalThreads;
        } else {
            // wait till all threads reach barrier
            while (count < totalThreads)
                wait();
        }

        released--;
        if (released == 0) count = 0;
    }
}