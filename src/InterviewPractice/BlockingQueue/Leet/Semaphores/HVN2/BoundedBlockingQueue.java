package InterviewPractice.BlockingQueue.Leet.Semaphores.HVN2;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.Semaphore;

// similar https://leetcode.com/problems/design-bounded-blocking-queue/discuss/402284/Java-2-semaphores-and-thread-safe-queue
// 8 ms, faster than 58.31%
public class BoundedBlockingQueue {
    Semaphore enq, deq;
    Queue<Integer> q;

    public BoundedBlockingQueue(int capacity) {
        enq = new Semaphore(capacity, true);
        deq = new Semaphore(0, true);
        q = new LinkedList<>();
    }

    public void enqueue(int element) throws InterruptedException {
        enq.acquire();
        q.add(element);
        deq.release();
    }

    public int dequeue() throws InterruptedException {
        deq.acquire();
        int res = q.remove();
        enq.release(1);
        return res;
    }

    public int size() {
        return q.size();
    }
}