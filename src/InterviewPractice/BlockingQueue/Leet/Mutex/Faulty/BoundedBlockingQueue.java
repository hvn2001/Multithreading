package InterviewPractice.BlockingQueue.Leet.Mutex.Faulty;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

// 14 / 15 test cases passed.
// 8 ms, faster than 58.31%
// HVN: when right when wrong
public class BoundedBlockingQueue {
    int[] array;
    Lock lock = new ReentrantLock();
    int size = 0;
    int capacity;
    int head = 0;
    int tail = 0;

    public BoundedBlockingQueue(int capacity) {
        // The casting results in a warning
        array = new int[capacity];
        this.capacity = capacity;
    }

    public int dequeue() throws InterruptedException {
        int item;
        while (size == 0) {

        }
        lock.lock();
        if (head == capacity) {
            head = 0;
        }

        item = array[head];
        array[head] = -1;
        head++;
        size--;

        lock.unlock();
        return item;
    }

    public void enqueue(int item) throws InterruptedException {
        while (size == capacity) {

        }
        lock.lock();
        if (tail == capacity) {
            tail = 0;
        }

        array[tail] = item;
        size++;
        tail++;
        lock.unlock();
    }

    public int size() {
        return size;
    }
}