package InterviewPractice.BlockingQueue.Leet.Semaphores.HVN1;

import java.util.concurrent.Semaphore;

// 7 ms, faster than 99.53%
public class BoundedBlockingQueue {
    int[] array;
    int size = 0;
    int capacity;
    int head = 0;
    int tail = 0;
    Semaphore semLock;
    Semaphore semProducer;
    Semaphore semConsumer;

    public BoundedBlockingQueue(int capacity) {
        array = new int[capacity];
        this.capacity = capacity;
        semLock = new Semaphore(1);
        semProducer = new Semaphore(capacity);
        semConsumer = new Semaphore(0);
    }

    public int dequeue() throws InterruptedException {

        semConsumer.acquire();
        semLock.acquire();
        int item;

        if (head == capacity) {
            head = 0;
        }

        item = array[head];
        array[head] = -1;
        head++;
        size--;
        semLock.release();
        semProducer.release();

        return item;
    }

    public void enqueue(int item) throws InterruptedException {

        semProducer.acquire();
        semLock.acquire();

        if (tail == capacity) {
            tail = 0;
        }

        array[tail] = item;
        size++;
        tail++;
        semLock.release();
        semConsumer.release();
    }

    public int size() {
        return size;
    }
}